package harmonytech.praagoraa.controller.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import harmonytech.praagoraa.R;
import harmonytech.praagoraa.controller.adapter.ProviderAdapter;
import harmonytech.praagoraa.controller.domain.Provider;
import harmonytech.praagoraa.controller.interfaces.RecyclerViewOnClickListenerHack;
import harmonytech.praagoraa.controller.util.Utility;
import harmonytech.praagoraa.view.ProviderDetailsActivity;
import harmonytech.praagoraa.view.SegmentDetailsActivity;

public class ProviderFragment extends Fragment implements RecyclerViewOnClickListenerHack{

    RecyclerView mRecyclerView;
    public List<Provider> mList;
    public ProviderAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_provider, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mList = ((SegmentDetailsActivity) getActivity()).getProvidersList();
        adapter = new ProviderAdapter(getActivity(), mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter( adapter );

        mRecyclerView.addOnItemTouchListener(new ProviderFragment.RecyclerViewTouchListener( getActivity(), mRecyclerView, this ));

        return view;

    }

    @Override
    public void onClickListener(View view, int position) {
        Intent intent = new Intent(getActivity(), ProviderDetailsActivity.class);
        intent.putExtra(Utility.PROVIDER_NAME, mList.get(position).getName());
        intent.putExtra(Utility.PROVIDER_EMAIL, mList.get(position).getEmail());
        intent.putExtra(Utility.PROVIDER_PHONE, mList.get(position).getPhone());
        intent.putExtra(Utility.PROVIDER_RATE, mList.get(position).getRate());
        intent.putExtra(Utility.PROVIDER_CATEGORY, mList.get(position).getCategory());
        intent.putExtra(Utility.PROVIDER_SUBCATEGORY, mList.get(position).getSubcategory());
        intent.putExtra(Utility.PROVIDER_DESCRIPTION, mList.get(position).getDescription());
        startActivity(intent);
    }

    private static class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener {
        private Context mContext;
        private GestureDetector mGestureDetector;
        private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

        RecyclerViewTouchListener(Context c, final RecyclerView rv, RecyclerViewOnClickListenerHack rvoclh){
            mContext = c;
            mRecyclerViewOnClickListenerHack = rvoclh;

            mGestureDetector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public void onLongPress(MotionEvent e) {
                    super.onLongPress(e);

                    View cv = rv.findChildViewUnder(e.getX(), e.getY());

                    if(cv != null && mRecyclerViewOnClickListenerHack != null){
                        mRecyclerViewOnClickListenerHack.onClickListener(cv,
                                rv.getChildAdapterPosition(cv) );
                    }
                }
            });
        }
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            mGestureDetector.onTouchEvent(e);
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
}

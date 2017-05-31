package harmonytech.eagora.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.domain.Provider;
import harmonytech.eagora.controller.interfaces.RecyclerViewOnClickListenerHack;

public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.MyViewHolder>{

    private List<Provider> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;
    private Context c;

    public ProviderAdapter(Context c, List<Provider> l){
        this.c = c;
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ProviderAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = mLayoutInflater.inflate(R.layout.item_provider, viewGroup, false);
        return new ProviderAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProviderAdapter.MyViewHolder myViewHolder, int position) {

        /*Glide.with(c)
                .load(mList.get((position)).getBanner())
                .centerCrop()
                .into(myViewHolder.bannerSegment);*/
        myViewHolder.nameSegment.setText(mList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r){
        mRecyclerViewOnClickListenerHack = r;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener /*View.OnCreateContextMenuListener*/{
        ImageView bannerSegment;
        TextView nameSegment;

        MyViewHolder(View itemView) {
            super(itemView);
            bannerSegment = (ImageView) itemView.findViewById(R.id.segment_banner);
            nameSegment = (TextView) itemView.findViewById(R.id.segment_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListener(v, getAdapterPosition());
            }
        }
    }
}

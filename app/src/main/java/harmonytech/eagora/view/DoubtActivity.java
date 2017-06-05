package harmonytech.eagora.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import harmonytech.eagora.R;

public class DoubtActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;

    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubt);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add(getResources().getString(R.string.question_1));
        List<String> answer1 = new ArrayList<>();
        answer1.add(getResources().getString(R.string.answer_1));

        listDataHeader.add(getResources().getString(R.string.question_2));
        List<String> answer2 = new ArrayList<>();
        answer2.add(getResources().getString(R.string.answer_2));

        listDataHeader.add(getResources().getString(R.string.question_3));
        List<String> answer3 = new ArrayList<>();
        answer3.add(getResources().getString(R.string.answer_3));

        listDataChild.put(getResources().getString(R.string.question_1), answer1);
        listDataChild.put(getResources().getString(R.string.question_2), answer2);
        listDataChild.put(getResources().getString(R.string.question_3), answer3);

        listAdapter = new harmonytech.eagora.controller.util.ExpandableListAdapter(DoubtActivity.this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }
}

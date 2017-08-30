package com.github.bassaer.scrollobserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private static final int LIST_SIZE = 20;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.main_list_view);
        CustomListAdapter adapter = new CustomListAdapter(this, 0, getListItem());
        mListView.setAdapter(adapter);
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                View item = mListView.getChildAt(0);
                if (item != null) {
                    int scrollY = -item.getTop() + mListView.getFirstVisiblePosition() * item.getHeight();
                    Log.d(
                            MainActivity.class.getSimpleName(),
                            "ScrollY = " + scrollY
                    );
                }
            }
        });
    }

    private List<Object> getListItem() {
        List<Object> list = new ArrayList<>();
        Item item = new Item(getString(R.string.dummy_text));

        for (int i = 0; i < LIST_SIZE; i++) {
            if (i == LIST_SIZE / 2) {
                list.add(View.inflate(this, R.layout.target, null));
                continue;
            }
            list.add(item);
        }
        return list;
    }
}

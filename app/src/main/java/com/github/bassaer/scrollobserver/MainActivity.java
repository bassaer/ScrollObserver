package com.github.bassaer.scrollobserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int LIST_SIZE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.main_list_view);
        CustomListAdapter adapter = new CustomListAdapter(this, 0, getListItem());
        listView.setAdapter(adapter);
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

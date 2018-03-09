package com.kkk.umg.searchboxwithrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.kkk.umg.searchboxwithrecyclerview.adapter.BlogListAdapter;
import com.kkk.umg.searchboxwithrecyclerview.model.BlogData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    EditText search_input;
    RecyclerView recyclerView;
    BlogListAdapter blogListAdapter;
    List<BlogData> blogDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        search_input = (EditText) findViewById(R.id.search_input);
        search_input.addTextChangedListener(this);
        blogDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if ((i % 2) == 0) {
                blogDataList.add(new BlogData(i + " New Title", "This is blog " + i + " description This is blog " + i + " description "));
            } else {
                blogDataList.add(new BlogData(i + " Old Title", "This is blog " + i + " description This is blog " + i + " description"));
            }
        }
        blogListAdapter = new BlogListAdapter(getApplicationContext(), blogDataList);
        recyclerView.setAdapter(blogListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        filter(editable.toString());
    }

    void filter(String text) {
        List<BlogData> temp = new ArrayList<>();
        for (BlogData d : blogDataList) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if (d.getBlog_title().toLowerCase().contains(text.toLowerCase()) ||
                    d.getBlog_desp().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        //update recyclerview
        blogListAdapter.SwapList(temp);
    }
}

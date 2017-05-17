package com.github.frankkwok.rvinheader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BaseQuickAdapter<String, BaseViewHolder> adapter;
    private BaseQuickAdapter<String, BaseViewHolder> headerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new BaseQuickAdapter<String, BaseViewHolder>(android.R.layout.simple_list_item_1) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(android.R.id.text1, item);
            }
        };

        headerAdapter = new BaseQuickAdapter<String, BaseViewHolder>(android.R.layout.simple_list_item_1) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(android.R.id.text1, item + " in header");
            }
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);

        View headerView = LayoutInflater.from(this)
                .inflate(R.layout.header_view, (ViewGroup) recyclerView.getParent(), false);
        RecyclerView rvHeader = (RecyclerView) headerView.findViewById(R.id.rv_header);
        headerAdapter.addData(new ArrayList<String>() {
            {
                add("Header Test 1");
                add("Header Test 2");
                add("Header Test 3");
                add("Header Test 4");
                add("Header Test 5");
                add("Header Test 6");
                add("Header Test 7");
                add("Header Test 8");
                add("Header Test 9");
                add("Header Test 10");
                add("Header Test 11");
                add("Header Test 12");
                add("Header Test 13");
                add("Header Test 14");
                add("Header Test 15");
                add("Header Test 16");
            }
        });
        rvHeader.setAdapter(headerAdapter);

        adapter.addHeaderView(headerView, 0);

        View headerView1 = LayoutInflater.from(this)
                .inflate(R.layout.header_view1, (ViewGroup) recyclerView.getParent(), false);
        adapter.addHeaderView(headerView1, 1);

        adapter.addData(new ArrayList<String>() {
            {
                add("Test 1");
                add("Test 2");
                add("Test 3");
            }
        });
    }


}

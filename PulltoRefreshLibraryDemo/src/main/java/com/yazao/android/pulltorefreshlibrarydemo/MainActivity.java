package com.yazao.android.pulltorefreshlibrarydemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.yazao.android.pulltorefresh.widget.PullToRefreshLayout;
import com.yazao.android.pulltorefresh.widget.PullableListView;
import com.yazao.android.pulltorefreshlibrarydemo.adapter.ListViewAdapter;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements PullToRefreshLayout.OnRefreshListener {

    private PullToRefreshLayout pullToRefreshLayout;
    private PullableListView pullableListView;
    private ListViewAdapter listViewAdapter;
    ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.pulltorefreshlayout);
        pullableListView = (PullableListView) findViewById(R.id.listview);
        datas = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            datas.add("origin data" + i);
        }
        listViewAdapter = new ListViewAdapter(this, datas);
        pullableListView.setAdapter(listViewAdapter);
        pullToRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
        this.pullToRefreshLayout=pullToRefreshLayout;

        this.pullToRefreshLayout
                .refreshFinish(PullToRefreshLayout.SUCCEED);
        for (int i = 0; i < 10; i++) {
            datas.add("refresh data" + i);
        }
        listViewAdapter.notifyDataSetChanged();

    }

    @Override
    public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        this.pullToRefreshLayout=pullToRefreshLayout;

        this.pullToRefreshLayout
                .loadmoreFinish(PullToRefreshLayout.SUCCEED);
        for (int i = 0; i < 20; i++) {
            datas.add("load data" + i);
        }
        listViewAdapter.notifyDataSetChanged();
    }
}

package com.yazao.android.pulltorefreshlibrarydemo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yazao.android.pulltorefreshlibrarydemo.R;

import java.util.ArrayList;

/**
 * Created by shaopingzhai on 15/5/25.
 */
public class ListViewAdapter extends BaseAdapter {
    private Activity context;
    ArrayList<String> datas;

    public ListViewAdapter(Activity context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;

        if (convertView == null) {
            holder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
            convertView.setTag(holder);
        }else {
            holder =(ViewHolder) convertView.getTag();
        }
        holder.tv= (TextView) convertView.findViewById(R.id.tv);
        holder.tv.setText(datas.get(position));
        return convertView;
    }

    class ViewHolder{
        TextView tv;
    }
}

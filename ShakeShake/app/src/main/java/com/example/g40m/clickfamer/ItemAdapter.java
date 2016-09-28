package com.example.g40m.clickfamer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by thm on 2016/1/28.
 */
public class ItemAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    private List<Item> items = new ArrayList();
    private Activity mContext;

    public ItemAdapter(Activity mContext) {
        this.mContext = mContext;
    }

    public void setDatas(List<Item> mAppBeans) {
        this.items = mAppBeans;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.user_item, null);
            viewHolder.nameTV = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.nameTV.setBackgroundResource(R.color.colorAccent);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        setAppView(position, viewHolder);
        return convertView;
    }

    private void setAppView(int position, ViewHolder viewHolder) {
        Item item = getItem(position);
        viewHolder.nameTV.setText(item.getUsername());

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        if (position >= getCount())
            return;
        Item item = getItem(position);
        if(TextUtils.isEmpty(item.getPassword())||TextUtils.isEmpty(item.getUsername())){
            return;
        }
        view.findViewById(R.id.tv_name).setBackgroundResource(R.color.colorPrimary);
        Intent intent = new Intent("com.tcy.union.clickfarmer");
        intent.putExtra("username", item.getUsername());
        intent.putExtra("password", item.getPassword());
        mContext.startActivity(intent);
    }

    class ViewHolder {
        TextView nameTV;
    }
}

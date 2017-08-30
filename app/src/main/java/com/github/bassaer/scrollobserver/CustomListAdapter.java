package com.github.bassaer.scrollobserver;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nakayama on 2017/08/30.
 */

public class CustomListAdapter extends ArrayAdapter<Object>{
    private Context mContext;
    public CustomListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Object> objects) {
        super(context, resource, objects);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Object object = getItem(position);
        if (object instanceof View) {
            return (View) object;
        }
        ViewHolder holder;

        if (convertView == null || !(convertView.getTag() instanceof ViewHolder)) {
            convertView = View.inflate(mContext, R.layout.list_item, null);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Item item = (Item) object;
        if (item != null) {
            holder.text.setText(item.getText());
        }
        return convertView;
    }

    private class ViewHolder {
        TextView text;
    }
}

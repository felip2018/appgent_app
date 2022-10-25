package com.fgarzon.appgent.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fgarzon.appgent.R;
import com.fgarzon.appgent.models.Case;
import com.fgarzon.appgent.models.Notification;

import java.util.ArrayList;

public class NotificationsListAdapter extends ArrayAdapter<Notification> {
    private Context context;
    private ArrayList<Notification> listItems;

    public NotificationsListAdapter(Context context, ArrayList<Notification> listItems) {
        super(context, 0, listItems);
        this.context    = context;
        this.listItems  = listItems;
    }

    @Override
    public int getCount() {
        return this.listItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convertView which is recyclable view
        View currentItemView = convertView;
        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_notifications, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Notification currentItem = getItem(position);

        // then according to the position of the view assign the content
        TextView txtTitle = currentItemView.findViewById(R.id.txt_title);
        txtTitle.setText(currentItem.getType());

        TextView txtDescription = currentItemView.findViewById(R.id.txt_description);
        txtDescription.setText(currentItem.getDescription());

        TextView txtCreatedAt = currentItemView.findViewById(R.id.txt_created_at);
        txtCreatedAt.setText(currentItem.getCreatedAt());

        return currentItemView;

    }
}

package com.fgarzon.appgent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fgarzon.appgent.R;
import com.fgarzon.appgent.models.TraceabilityItem;
import com.fgarzon.appgent.ui.notifications.NotificationsFragment;

import java.util.ArrayList;

public class TraceabilityListAdapter extends ArrayAdapter<TraceabilityItem> {

    private Context context;
    private ArrayList<TraceabilityItem> listItems;

    public TraceabilityListAdapter(Context context, ArrayList<TraceabilityItem> listItems) {
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
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_traceability, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        TraceabilityItem currentItem = getItem(position);

        // then according to the position of the view assign the content
        TextView description = currentItemView.findViewById(R.id.txt_description);
        description.setText(currentItem.getObservations());

        return currentItemView;

    }
}

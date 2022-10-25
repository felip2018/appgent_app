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
import com.fgarzon.appgent.models.TraceabilityItem;

import java.util.ArrayList;

public class CasesListAdapter extends ArrayAdapter<Case> {

    private Context context;
    private ArrayList<Case> listItems;

    public CasesListAdapter(Context context, ArrayList<Case> listItems) {
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
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_cases, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Case currentItem = getItem(position);

        // then according to the position of the view assign the content
        TextView txtTitle = currentItemView.findViewById(R.id.txt_title);
        txtTitle.setText("Case No."+currentItem.getCaseId());

        TextView txtDescription = currentItemView.findViewById(R.id.txt_description);
        txtDescription.setText(currentItem.getDescription());

        TextView txtStatus = currentItemView.findViewById(R.id.txt_status);
        txtStatus.setText(currentItem.getCaseStatus());
        txtStatus.setBackgroundColor(Color.parseColor(getBackgroundByStatus(currentItem.getCaseStatus())));

        return currentItemView;

    }

    public String getBackgroundByStatus(String caseStatus) {
        String color = "";
        switch (caseStatus) {
            case "ABIERTO":
                color = "#62E9FC";
                break;
            case "EN PROCESO":
                color = "#FCFF54";
                break;
            case "FINALIZADO":
                color = "#62FCA9";
                break;
        }
        return color;
    }
}

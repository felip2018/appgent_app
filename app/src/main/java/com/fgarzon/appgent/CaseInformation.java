package com.fgarzon.appgent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.fgarzon.appgent.models.TraceabilityItem;
import com.fgarzon.appgent.adapters.TraceabilityListAdapter;

import java.util.ArrayList;

public class CaseInformation extends AppCompatActivity {

    ListView listTraceability;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_information);
        getSupportActionBar().hide();

        listTraceability = findViewById(R.id.list_view);

        ArrayList<TraceabilityItem> arrayList = new ArrayList<>();
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 1"));
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 2"));
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 3"));
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 4"));
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 5"));
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 6"));
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 7"));
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 8"));
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 9"));
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 10"));
        arrayList.add(new TraceabilityItem(1, "Descripción del caso numero 11"));

        TraceabilityListAdapter myAdapter = new TraceabilityListAdapter(this, arrayList);
        listTraceability.setAdapter(myAdapter);

    }
}
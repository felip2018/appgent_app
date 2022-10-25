package com.fgarzon.appgent.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fgarzon.appgent.CaseInformation;
import com.fgarzon.appgent.R;
import com.fgarzon.appgent.RegisterCase;
import com.fgarzon.appgent.adapters.CasesListAdapter;
import com.fgarzon.appgent.databinding.FragmentHomeBinding;
import com.fgarzon.appgent.models.Case;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;
    Intent intent;
    ListView listView;
    Button btnNewCase;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView    = root.findViewById(R.id.list_view);
        btnNewCase  = root.findViewById(R.id.btn_new_case);

        ArrayList<Case> arrayList = new ArrayList<>();
        arrayList.add(new Case(1, "Caso numero 1", "ABIERTO", "15 de octubre del 2022"));
        arrayList.add(new Case(2, "Caso numero 2", "FINALIZADO", "16 de octubre del 2022"));
        arrayList.add(new Case(3, "Caso numero 3", "EN PROCESO", "17 de octubre del 2022"));

        CasesListAdapter myAdapter = new CasesListAdapter(this.getContext(), arrayList);
        listView.setAdapter(myAdapter);

        btnNewCase.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(root.getContext(), RegisterCase.class);
                startActivity(intent);
            }
        }));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(root.getContext(), "Has pulsado: "+arrayList.get(position).getDescription(), Toast.LENGTH_LONG)
                        .show();
                intent = new Intent(root.getContext(), CaseInformation.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
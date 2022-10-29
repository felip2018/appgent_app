package com.fgarzon.appgent.ui.close;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fgarzon.appgent.MainActivity;
import com.fgarzon.appgent.R;
import com.fgarzon.appgent.Tabs;
import com.fgarzon.appgent.databinding.FragmentCloseBinding;

public class CloseFragment extends Fragment {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    Button btnAcceptClose;

    private FragmentCloseBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCloseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sharedPreferences = this.getActivity().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();

        btnAcceptClose = root.findViewById(R.id.btn_accept_close);

        btnAcceptClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove shared preferences data
                sharedPreferencesEditor.clear();
                sharedPreferencesEditor.apply();
                // Navigate to login screen
                Intent intent = new Intent(root.getContext(), MainActivity.class);
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
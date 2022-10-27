package com.fgarzon.appgent.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fgarzon.appgent.R;
import com.fgarzon.appgent.adapters.NotificationsListAdapter;
import com.fgarzon.appgent.adapters.TraceabilityListAdapter;
import com.fgarzon.appgent.databinding.FragmentNotificationsBinding;
import com.fgarzon.appgent.models.Notification;
import com.fgarzon.appgent.models.TraceabilityItem;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

private FragmentNotificationsBinding binding;

    ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = root.findViewById(R.id.list_view);

        ArrayList<Notification> arrayList = new ArrayList<>();

        NotificationsListAdapter myAdapter = new NotificationsListAdapter(this.getContext(), arrayList);
        listView.setAdapter(myAdapter);

        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
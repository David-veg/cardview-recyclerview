package com.example.cardview_recyclerview.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview_recyclerview.ListAdapter;
import com.example.cardview_recyclerview.ListElement;
import com.example.cardview_recyclerview.R;
import com.example.cardview_recyclerview.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<ListElement> elements;

    private FragmentHomeBinding binding;
    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        super.onCreate(savedInstanceState);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        view = binding.getRoot();

        init(view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void init(View v){
        elements = new ArrayList<>();
        elements.add(new ListElement("#654424","Paulo", "Lima",  "Activo"));
        elements.add(new ListElement("#608421","Julio", "Lima",  "Activo"));
        elements.add(new ListElement("#146466","Jezzer", "Lima",  "Activo"));
        elements.add(new ListElement("#534344", "Jorge", "Lima", "Activo"));
        elements.add(new ListElement("#542444", "Josias", "Lima", "Inactivo"));
        elements.add(new ListElement("#524344", "Daniel", "Lima", "Inactivo"));





        ListAdapter listAdapter =new ListAdapter(elements, getContext());
        RecyclerView recyclerView = v.findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
    }
}
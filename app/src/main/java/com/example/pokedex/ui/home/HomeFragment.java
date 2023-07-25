package com.example.pokedex.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;
import com.example.pokedex.RecyclersContainers.OptionAdapter;
import com.example.pokedex.RecyclersContainers.OptionInfo;
import com.example.pokedex.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private OptionAdapter adapter;
    private List<OptionInfo> opciones;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configurar el RecyclerView y su adaptador
        recyclerView = view.findViewById(R.id.OptionHomeID);
        opciones = new ArrayList<>();
        opciones.add(new OptionInfo("Pokemon", R.drawable.pokemon,"#CE2B21"));
        opciones.add(new OptionInfo("Objeto", R.drawable.item, "#CE2B21"));
        adapter = new OptionAdapter(opciones);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
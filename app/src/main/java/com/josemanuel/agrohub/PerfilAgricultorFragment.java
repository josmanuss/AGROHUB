package com.josemanuel.agrohub;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.josemanuel.agrohub.databinding.FragmentPerfilAgricultorBinding;


public class PerfilAgricultorFragment extends Fragment {

    FragmentPerfilAgricultorBinding binding;

    public PerfilAgricultorFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPerfilAgricultorBinding.inflate(inflater,container,false);

        binding.btnReturn.setOnClickListener(v -> {
            NavHostFragment.findNavController(PerfilAgricultorFragment.this).popBackStack();

        });


        return binding.getRoot();
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        String correo = PerfilAgricultorFragmentArgs.fromBundle(getArguments()).getCORREO();
        binding.tvEmail.setText("Correo electronico: " + correo);
    }



}
package com.josemanuel.agrohub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.josemanuel.agrohub.databinding.FragmentPreCargaBinding;
import com.josemanuel.agrohub.databinding.FragmentRegistroBinding;


public class RegistroFragment extends Fragment {
    FragmentRegistroBinding binding;

    public RegistroFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentRegistroBinding.inflate(inflater, container, false);
        binding.YTCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RegistroFragment.this)
                        .navigate(R.id.action_RegistroFragment_to_LoginFragment);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
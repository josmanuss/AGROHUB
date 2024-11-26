package com.josemanuel.agrohub;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.josemanuel.agrohub.databinding.FragmentPreCargaBinding;

public class PreCargaFragment extends Fragment {

    private FragmentPreCargaBinding binding;

    public PreCargaFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPreCargaBinding.inflate(inflater, container, false);

        binding.buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PreCargaFragment.this)
                        .navigate(R.id.action_PreCargaFragment_to_LoginFragment);
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

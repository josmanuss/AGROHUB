package com.josemanuel.agrohub;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
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

    private void mostrarDialogoSeleccion() {
        new MaterialAlertDialogBuilder(requireContext())
                .setTitle("Seleccione su tipo de usuario")
                .setMessage("Elija una opción para continuar con la configuración del perfil")
                .setPositiveButton("Consumidor", (dialog, which) -> {
                    NavHostFragment.findNavController(PreCargaFragment.this)
                            .navigate(R.id.action_PreCargaFragment_to_LoginFragment);
                })
                .setNeutralButton("Agricultor", (dialog, which) -> {
                    NavHostFragment.findNavController(PreCargaFragment.this)
                            .navigate(R.id.action_PreCargaFragment_to_LoginAgricultorFragment);
                })
                .setNegativeButton("Cancelar", (dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

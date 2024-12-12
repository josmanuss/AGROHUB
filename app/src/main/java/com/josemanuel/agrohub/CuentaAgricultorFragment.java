package com.josemanuel.agrohub;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.josemanuel.agrohub.databinding.FragmentCuentaAgricultorBinding;
import com.josemanuel.agrohub.datos.ApiClient;
import com.josemanuel.agrohub.datos.ApiService;
import com.josemanuel.agrohub.dominio.AgricultorRequest;
import com.josemanuel.agrohub.dominio.AgricultorResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CuentaAgricultorFragment extends Fragment {

    private FragmentCuentaAgricultorBinding binding;

    public CuentaAgricultorFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCuentaAgricultorBinding.inflate(inflater, container, false);

        binding.buttonEnviar.setOnClickListener(view -> {
            if (binding.etNombre.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Por favor, ingrese su nombre.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (binding.etEmail.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Por favor, ingrese su email.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (binding.etDireccion.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Por favor, ingrese su dirección.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (binding.etTelefono.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Por favor, ingrese su teléfono.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (binding.etNombreUsuario.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Por favor, ingrese un nombre de usuario.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (binding.etContrasenia.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Por favor, ingrese una contraseña.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (binding.etCertificacion.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Por favor, ingrese sus preferencias.", Toast.LENGTH_SHORT).show();
                return;
            }
            AgricultorRequest agricultorRequest = new AgricultorRequest(
                    binding.etNombre.getText().toString().trim(),
                    binding.etEmail.getText().toString().trim(),
                    binding.etDireccion.getText().toString().trim(),
                    binding.etTelefono.getText().toString().trim(),
                    binding.etNombreUsuario.getText().toString().trim(),
                    binding.etContrasenia.getText().toString().trim(),
                    binding.etCertificacion.getText().toString().trim()
            );
            ApiService apiService = ApiClient.getClient().create(ApiService.class);
            Call<AgricultorResponse> agricultorResponseCall = apiService.registrarAgricultor(agricultorRequest);
            agricultorResponseCall.enqueue(new Callback<AgricultorResponse>() {
                @Override
                public void onResponse(@NonNull Call<AgricultorResponse> call, @NonNull Response<AgricultorResponse> response) {
                    if(response.isSuccessful()){
                        AgricultorResponse agricultorResponse = response.body();
                        Toast.makeText(getContext(), agricultorResponse != null ? agricultorResponse.getMessage() : null, Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<AgricultorResponse> call, @NonNull Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();

                }
            });
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}
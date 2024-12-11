package com.josemanuel.agrohub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.josemanuel.agrohub.databinding.FragmentRegistroBinding;
import com.josemanuel.agrohub.datos.ApiService;
import com.josemanuel.agrohub.datos.ApiClient;
import com.josemanuel.agrohub.dominio.ConsumidorRequest;
import com.josemanuel.agrohub.dominio.ConsumidorResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

        binding.buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                if (binding.etPreferencias.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getContext(), "Por favor, ingrese sus preferencias.", Toast.LENGTH_SHORT).show();
                    return;
                }
                ConsumidorRequest consumidorRequest = new ConsumidorRequest(

                        binding.etNombre.getText().toString().trim(),
                        binding.etEmail.getText().toString().trim(),
                        binding.etDireccion.getText().toString().trim(),
                        binding.etTelefono.getText().toString().trim(),
                        binding.etNombreUsuario.getText().toString().trim(),
                        binding.etContrasenia.getText().toString().trim(),
                        binding.etPreferencias.getText().toString().trim()
                );

                ApiService apiService = ApiClient.getClient().create(ApiService.class);
                Call<ConsumidorResponse> call = apiService.registrarConsumidor(consumidorRequest);
                call.enqueue(new Callback<ConsumidorResponse>() {
                    @Override
                    public void onResponse(Call<ConsumidorResponse> call, Response<ConsumidorResponse> response) {
                        if (response.isSuccessful()) {
                            ConsumidorResponse consumidorResponse = response.body();
                            if (consumidorResponse != null) {
                                Toast.makeText(getContext(), consumidorResponse.getMessage(), Toast.LENGTH_LONG).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        NavHostFragment.findNavController(RegistroFragment.this)
                                                .navigate(R.id.action_RegistroFragment_to_LoginFragment);
                                    }
                                }, 3000);
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<ConsumidorResponse> call, Throwable t) {
                        Toast.makeText(getContext(), "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


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
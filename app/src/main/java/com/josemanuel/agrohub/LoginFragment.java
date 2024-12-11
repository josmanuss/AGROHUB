package com.josemanuel.agrohub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.josemanuel.agrohub.databinding.FragmentLoginBinding;
import com.josemanuel.agrohub.datos.ApiService;
import com.josemanuel.agrohub.datos.ApiClient;
import com.josemanuel.agrohub.dominio.LoginRequest;
import com.josemanuel.agrohub.dominio.LoginResponse;

import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    HashMap<String, String> usuarios = null;


    public LoginFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuarios = new HashMap<>();
        usuarios.put("manuelito@gmail.com","1234567890");
        usuarios.put("rguerrerojordya@uss.edu.pe","9876543210");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container,false);

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _usuario, _contrasenia;
                _usuario = Objects.requireNonNull(binding.editTextUser.getText()).toString().trim();
                _contrasenia = Objects.requireNonNull(binding.editTextPassword.getText()).toString().trim();
                if(_usuario.isEmpty() &&  _contrasenia.isEmpty()){
                    Toast.makeText(getContext(),"Usuario y contraseña estan en blanco", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if( _usuario.isEmpty()){
                    Toast.makeText(getContext(),"Usuario en blanco", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if ( _contrasenia.isEmpty()){
                    Toast.makeText(getContext(),"Contraseña en blanco", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{


                    LoginRequest loginRequest = new LoginRequest(_usuario,_contrasenia);
                    ApiService apiService = ApiClient.getClient().create(ApiService.class);

                    apiService.loginConsumidor(loginRequest).enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            LoginResponse loginResponse = response.body();

                            Toast.makeText(getContext(),loginResponse.getEmail(),Toast.LENGTH_SHORT).show();

                            LoginFragmentDirections.ActionLoginFragmentToVistaConsumidorFragmente loginFragmentDirections =
                                    LoginFragmentDirections.actionLoginFragmentToVistaConsumidorFragmente(_usuario);
                            NavHostFragment.findNavController(LoginFragment.this).navigate(loginFragmentDirections);


                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Toast.makeText(getContext(), "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });


                }

            }
        });


        binding.textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_LoginFragment_to_RegistroFragment);
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
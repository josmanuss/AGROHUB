package com.josemanuel.agrohub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.josemanuel.agrohub.databinding.FragmentLoginAgricultorBinding;
import com.josemanuel.agrohub.datos.ApiClient;
import com.josemanuel.agrohub.datos.ApiService;
import com.josemanuel.agrohub.dominio.LoginRequest;
import com.josemanuel.agrohub.dominio.LoginResponse;

import retrofit2.*;

import java.util.Objects;


public class LoginAgricultorFragment extends Fragment {

    private FragmentLoginAgricultorBinding binding;

    public LoginAgricultorFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLoginAgricultorBinding.inflate(inflater,container,false);


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
                    apiService.loginAgricultor(loginRequest).enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if(response.isSuccessful()){
                                LoginResponse loginResponse = response.body();
                                Toast.makeText(getContext(),"CORRECTO",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(getContext(),response.message(),Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    });




                }

            }
        });

        binding.textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginAgricultorFragment.this)
                        .navigate(R.id.action_LoginAgricultorFragment_to_cuentaAgricultorFragment);

            }
        });
        return binding.getRoot();
    }
}
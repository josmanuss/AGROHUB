package com.josemanuel.agrohub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.josemanuel.agrohub.databinding.FragmentLoginBinding;
import java.util.HashMap;
import java.util.Objects;


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
        usuarios.put("josemanuel@uss.edu.pe","1234567890");
        usuarios.put("jhamirsilva@gmail.com","87654321");
        usuarios.put("jordy@uss.edu.pe","JORDYRODRIGO");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container,false);

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario, contrasenia;
                usuario = Objects.requireNonNull(binding.editTextUser.getText()).toString().trim();
                contrasenia = Objects.requireNonNull(binding.editTextPassword.getText()).toString().trim();
                if(usuario.isEmpty() &&  contrasenia.isEmpty()){
                    Toast.makeText(getContext(),"Usuario y contraseña estan en blanco", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if( usuario.isEmpty()){
                    Toast.makeText(getContext(),"Usuario en blanco", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if ( contrasenia.isEmpty()){
                    Toast.makeText(getContext(),"Contraseña en blanco", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    if ( usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contrasenia)){
                        Toast.makeText(getContext(),usuario+" - "+contrasenia, Toast.LENGTH_SHORT).show();

                        LoginFragmentDirections.ActionLoginFragmentToPerfilAgricultorFragment accion =
                                LoginFragmentDirections.actionLoginFragmentToPerfilAgricultorFragment(usuario);
                        NavHostFragment.findNavController(LoginFragment.this).navigate(accion);


                    }
                    else{
                        Toast.makeText(getContext(),"INCORRECTO", Toast.LENGTH_SHORT).show();
                    }
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
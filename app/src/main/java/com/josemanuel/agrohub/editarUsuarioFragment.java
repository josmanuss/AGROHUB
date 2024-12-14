package com.josemanuel.agrohub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class editarUsuarioFragment extends Fragment {

    private EditText insertName, insertDirection, insertNumber, insertCantidad, InsertNewContraseña;
    private Button btnActualizarUsuario, btnCancelActulizar;

    public editarUsuarioFragment() {
        // Constructor vacío
    }

    public static editarUsuarioFragment newInstance(String param1, String param2) {
        editarUsuarioFragment fragment = new editarUsuarioFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View rootView = inflater.inflate(R.layout.fragment_editar_usuario, container, false);

        // Inicialización de los campos de texto
        insertName = rootView.findViewById(R.id.insertName);
        insertDirection = rootView.findViewById(R.id.insertDirection);
        insertNumber = rootView.findViewById(R.id.insertNumber);
        insertCantidad = rootView.findViewById(R.id.insertCantidad);
        InsertNewContraseña = rootView.findViewById(R.id.InsertNewContraseña);

        // Botones
        btnActualizarUsuario = rootView.findViewById(R.id.btnActualizarUsuario);
        btnCancelActulizar = rootView.findViewById(R.id.btnCancelActulizar);

        // Acción de botón "Actualizar Usuario"
        btnActualizarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarUsuario();
            }
        });

        // Acción de botón "Cancelar"
        btnCancelActulizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelarActualizacion();
            }
        });

        return rootView;
    }

    private void actualizarUsuario() {
        // Recupera los valores ingresados por el usuario
        String name = insertName.getText().toString().trim();
        String direction = insertDirection.getText().toString().trim();
        String number = insertNumber.getText().toString().trim();
        String cantidad = insertCantidad.getText().toString().trim();
        String newPassword = InsertNewContraseña.getText().toString().trim();

        // Validación básica
        if (name.isEmpty() || direction.isEmpty() || number.isEmpty() || cantidad.isEmpty() || newPassword.isEmpty()) {
            Toast.makeText(getActivity(), "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            // Aquí puedes agregar la lógica para actualizar los datos del usuario
            // Esto podría ser una llamada a la base de datos o API para actualizar los datos

            // Ejemplo de mensaje de éxito
            Toast.makeText(getActivity(), "Usuario actualizado correctamente", Toast.LENGTH_SHORT).show();
        }
    }

    private void cancelarActualizacion() {
        // Limpiar los campos de texto
        insertName.setText("");
        insertDirection.setText("");
        insertNumber.setText("");
        insertCantidad.setText("");
        InsertNewContraseña.setText("");

        // Regresar al fragmento anterior
        requireActivity().onBackPressed();  // Cambio recomendado
    }
}

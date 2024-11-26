package com.josemanuel.agrohub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/**
 * Fragmento simple {@link Fragment}.
 * Usa el método de fábrica {@link Campos_AgricultorFragment#newInstance} para
 * crear una instancia de este fragmento.
 */
public class Campos_AgricultorFragment extends Fragment {

    // Declaramos las vistas que se van a usar
    private ImageView profileImage, logo;
    private EditText nombre, ubicacion, cultivoPrincipal, celular, hectareasTrabajadas, experiencia, correo;
    private Button btnActualizarPerfil;
    private TextView nombreLabel, ubicacionLabel, cultivoPrincipalLabel, celularLabel, hectareasTrabajadasLabel, experienciaLabel, correoLabel, textViewInfoAgr;

    // Parámetros para pasar datos al fragmento
    private static final String ARG_NOMBRE = "nombre";
    private static final String ARG_UBICACION = "ubicacion";
    private static final String ARG_CULTIVO = "cultivo";
    private static final String ARG_CELULAR = "celular";
    private static final String ARG_HECTAREAS = "hectareas";
    private static final String ARG_EXPERIENCIA = "experiencia";
    private static final String ARG_CORREO = "correo";

    public Campos_AgricultorFragment() {
        // Constructor vacío requerido
    }

    /**
     * Método de fábrica para crear una nueva instancia del fragmento
     * con los parámetros proporcionados.
     */
    public static Campos_AgricultorFragment newInstance(String nombre, String ubicacion, String cultivo,
                                                        String celular, String hectareas, String experiencia, String correo) {
        Campos_AgricultorFragment fragment = new Campos_AgricultorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NOMBRE, nombre);
        args.putString(ARG_UBICACION, ubicacion);
        args.putString(ARG_CULTIVO, cultivo);
        args.putString(ARG_CELULAR, celular);
        args.putString(ARG_HECTAREAS, hectareas);
        args.putString(ARG_EXPERIENCIA, experiencia);
        args.putString(ARG_CORREO, correo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Recuperamos los datos pasados como argumentos
            String nombreData = getArguments().getString(ARG_NOMBRE);
            String ubicacionData = getArguments().getString(ARG_UBICACION);
            String cultivoData = getArguments().getString(ARG_CULTIVO);
            String celularData = getArguments().getString(ARG_CELULAR);
            String hectareasData = getArguments().getString(ARG_HECTAREAS);
            String experienciaData = getArguments().getString(ARG_EXPERIENCIA);
            String correoData = getArguments().getString(ARG_CORREO);

            // Usamos estos datos en la UI más adelante
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos el layout para este fragmento
        View rootView = inflater.inflate(R.layout.fragment_campos__agricultor, container, false);

        // Inicializamos las vistas desde el layout
        profileImage = rootView.findViewById(R.id.profile_image);
        logo = rootView.findViewById(R.id.logo);
        nombre = rootView.findViewById(R.id.nombre);
        ubicacion = rootView.findViewById(R.id.ubicacion);
        cultivoPrincipal = rootView.findViewById(R.id.cultivo_principal);
        celular = rootView.findViewById(R.id.celular);
        hectareasTrabajadas = rootView.findViewById(R.id.hectareas_trabajadas);
        experiencia = rootView.findViewById(R.id.experiencia);
        correo = rootView.findViewById(R.id.correo);
        btnActualizarPerfil = rootView.findViewById(R.id.btnActualizarPerfil);
        textViewInfoAgr = rootView.findViewById(R.id.textView2);

        // Rellenamos los campos con los datos pasados en los argumentos
        Bundle args = getArguments();
        if (args != null) {
            nombre.setText(args.getString(ARG_NOMBRE));
            ubicacion.setText(args.getString(ARG_UBICACION));
            cultivoPrincipal.setText(args.getString(ARG_CULTIVO));
            celular.setText(args.getString(ARG_CELULAR));
            hectareasTrabajadas.setText(args.getString(ARG_HECTAREAS));
            experiencia.setText(args.getString(ARG_EXPERIENCIA));
            correo.setText(args.getString(ARG_CORREO));
        }

        // Configuramos el listener para el botón de actualizar perfil
        btnActualizarPerfil.setOnClickListener(v -> {
            // Aquí puedes manejar el evento de actualización
            updateProfile();
        });

        return rootView;
    }

    /**
     * Método para actualizar el perfil con los datos ingresados
     */
    private void updateProfile() {
        String nombreText = nombre.getText().toString();
        String ubicacionText = ubicacion.getText().toString();
        String cultivoText = cultivoPrincipal.getText().toString();
        String celularText = celular.getText().toString();
        String hectareasText = hectareasTrabajadas.getText().toString();
        String experienciaText = experiencia.getText().toString();
        String correoText = correo.getText().toString();

        // Aquí puedes manejar la lógica para actualizar el perfil
        // Ejemplo: hacer una llamada a la API o guardar los datos localmente
        // updateUserProfile(nombreText, ubicacionText, cultivoText, celularText, hectareasText, experienciaText, correoText);
    }
}

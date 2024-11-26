package com.josemanuel.agrohub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.josemanuel.agrohub.databinding.FragmentVistaConsumidorBinding;

public class VistaConsumidorFragment extends Fragment {

    private FragmentVistaConsumidorBinding binding;

    // Opciones del menú
    private static final String[] MENU_OPTIONS = {
            "Inicio",
            "Nosotros",
            "Carrito de compras",
            "Productos",
            "Pedidos",
            "Cerrar sesión"
    };

    public VistaConsumidorFragment() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el diseño utilizando View Binding
        binding = FragmentVistaConsumidorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configurar el botón de menú
        Button menuButton = binding.menuButton;
        menuButton.setOnClickListener(v -> showMenuOptions());

        // Establecer el precio dinámicamente
        Button priceButton = binding.priceButton;
        double pricePerKilo = 50.0; // Ejemplo de precio por kilo
        priceButton.setText("Precio por kilo: $" + pricePerKilo);

        // Configurar el clic en la imagen del producto
        ImageView productImage = binding.productImage;
        productImage.setOnClickListener(v -> {
            String productName = "Arándanos";
            String origin = "Chile";
            String cultivation = "Orgánico";
            String process = "Refrigeración y empaque";

            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setTitle(productName)
                    .setMessage("Origen: " + origin + "\n"
                            + "Cultivo: " + cultivation + "\n"
                            + "Proceso: " + process)
                    .setPositiveButton("Cerrar", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }

    // Método para mostrar el menú emergente
    private void showMenuOptions() {
        if (getContext() == null) return;

        // Crear el adaptador personalizado para las opciones
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, MENU_OPTIONS) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                // Obtener la vista predeterminada
                View view = super.getView(position, convertView, parent);

                // Personalizar colores: fondo verde y texto blanco
                view.setBackgroundColor(getResources().getColor(R.color.green)); // Fondo verde
                TextView textView = (TextView) view;
                textView.setTextColor(getResources().getColor(android.R.color.white)); // Texto blanco
                textView.setPadding(16, 16, 16, 16); // Espaciado
                return view;
            }
        };

        // Crear un ListView para mostrar las opciones
        ListView listView = new ListView(requireContext());
        listView.setAdapter(adapter);
        listView.setDividerHeight(0); // Sin separador entre elementos

        // Crear el AlertDialog con el ListView personalizado
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Menú")
                .setView(listView)
                .setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();

        // Manejo de clics en las opciones
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedOption = MENU_OPTIONS[position];
            handleMenuSelection(selectedOption);
            dialog.dismiss();
        });
    }

    // Método para manejar la selección del menú
    private void handleMenuSelection(String selectedOption) {
        // Realiza la acción deseada según la opción seleccionada
        switch (selectedOption) {
            case "Inicio":
                break;
            case "Nosotros":
                break;
            case "Carrito de compras":
                break;
            case "Productos":
                break;
            case "Pedidos":
                break;
            case "Cerrar sesión":
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

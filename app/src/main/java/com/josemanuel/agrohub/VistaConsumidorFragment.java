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
import androidx.navigation.fragment.NavHostFragment;

import com.josemanuel.agrohub.databinding.FragmentVistaConsumidorBinding;

import java.util.ArrayList;
import java.util.List;

public class VistaConsumidorFragment extends Fragment {

    private FragmentVistaConsumidorBinding binding;

    // Lista para el carrito de compras
    private List<String> shoppingCart = new ArrayList<>();

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

        String usuario = VistaConsumidorFragmentArgs.fromBundle(getArguments()).getCORREO();

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

        // Configurar el botón de agregar al carrito
        Button addToCartButton = binding.addToCartButton;
        addToCartButton.setOnClickListener(v -> addToCart("Arándanos"));

    }

    // Método para agregar un producto al carrito
    private void addToCart(String productName) {
        shoppingCart.add(productName);
        showProductAddedDialog(productName);
    }

    // Método para mostrar un mensaje cuando se agrega un producto al carrito
    private void showProductAddedDialog(String productName) {
        new AlertDialog.Builder(requireContext())
                .setTitle("Producto añadido")
                .setMessage(productName + " ha sido añadido a tu carrito de compras.")
                .setPositiveButton("Cerrar", null)
                .show();
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
    private void handleMenuSelection(@NonNull String selectedOption) {
        // Realiza la acción deseada según la opción seleccionadaa
        switch (selectedOption) {
            case "Inicio":
                // NavHostFragment.findNavController(VistaConsumidorFragment.this).navigate(
                //       R.id.action_VistaConsumidorFragment_to_inicioFragment
                //);
                break;
            case "Nosotros":
                // NavHostFragment.findNavController(VistaConsumidorFragment.this).navigate(
                //       R.id.action_VistaConsumidorFragment_to_nosotrosFragment
                // );
                break;
            case "Carrito de compras":
                NavHostFragment.findNavController(VistaConsumidorFragment.this).navigate(
                        R.id.action_VistaConsumidorFragment_to_cncarritoComprasFragment
                );
                break;
            case "Productos":
                NavHostFragment.findNavController(VistaConsumidorFragment.this).navigate(
                        R.id.action_VistaConsumidorFragment_to_productosFragment
                );
                break;
            case "Pedidos":
                //NavHostFragment.findNavController(VistaConsumidorFragment.this).navigate(
                //      R.id.action_VistaConsumidorFragment_to_pedidosFragment
                // );
                break;
            case "Cerrar sesión":
                //    NavHostFragment.findNavController(VistaConsumidorFragment.this).navigate(
                //          R.id.action_VistaConsumidorFragment_to_loginFragment
                // );
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

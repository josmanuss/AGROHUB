package com.josemanuel.agrohub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.josemanuel.agrohub.databinding.FragmentCnCarritoComprasBinding;

public class CnCarritoComprasFragment extends Fragment {

    private FragmentCnCarritoComprasBinding binding;
    private int cantidadProducto = 1; // Variable para manejar la cantidad

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout using ViewBinding
        binding = FragmentCnCarritoComprasBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configuración inicial
        binding.productQuantity.setText(String.valueOf(cantidadProducto));

        // Botón para aumentar la cantidad
        binding.btnIncrement.setOnClickListener(v -> {
            cantidadProducto++;
            binding.productQuantity.setText(String.valueOf(cantidadProducto));
        });

        // Botón para disminuir la cantidad
        binding.btnDecrement.setOnClickListener(v -> {
            if (cantidadProducto > 1) {
                cantidadProducto--;
                binding.productQuantity.setText(String.valueOf(cantidadProducto));
            } else {
                Toast.makeText(getContext(), "La cantidad mínima es 1", Toast.LENGTH_SHORT).show();
            }
        });

        // Botón para eliminar producto
        binding.btnEliminarProducto.setOnClickListener(v -> eliminarProducto());

        // Botón para agregar producto
        binding.btnAgregarProducto.setOnClickListener(v -> agregarProducto());

        // Botón para realizar pedido
        binding.btnRealizarPedido.setOnClickListener(v -> realizarPedido());
    }

    private void agregarProducto() {
        Toast.makeText(getContext(), "Producto agregado al carrito", Toast.LENGTH_SHORT).show();
        // Aquí puedes agregar la lógica para añadir el producto a tu lista de compras
    }

    private void realizarPedido() {
        Toast.makeText(getContext(), "Pedido realizado con éxito", Toast.LENGTH_SHORT).show();
        // Aquí puedes implementar la lógica para procesar el pedido
    }

    private void eliminarProducto() {
        Toast.makeText(getContext(), "Producto eliminado del carrito", Toast.LENGTH_SHORT).show();
        // Aquí puedes agregar la lógica para eliminar el producto del carrito
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Evitar memory leaks
    }
}

package com.josemanuel.agrohub;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.josemanuel.agrohub.databinding.FragmentDashboardClienteBinding;

public class DashboardClienteFragment extends Fragment {

    FragmentDashboardClienteBinding binding;

    public DashboardClienteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout using View Binding
        binding = FragmentDashboardClienteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Ensure the argument is correctly received
        if (getArguments() != null) {
            // Retrieve the passed argument (email)
            //String correo = DashboardClienteFragmentArgs.fromBundle(getArguments()).getCORREO();


            //binding.greetingTextView.setText("Hola, "+correo);



            //binding.emailTextView.setText(correo);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Clear the binding when the view is destroyed to avoid memory leaks
        binding = null;
    }
}

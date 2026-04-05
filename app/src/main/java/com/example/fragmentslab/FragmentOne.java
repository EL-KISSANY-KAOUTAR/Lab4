package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {

    private TextView show;
    private Button btnMessage;

    public FragmentOne() {
        super(R.layout.fragment__oone); //  XML chargé automatiquement
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        show = view.findViewById(R.id.One);
        btnMessage = view.findViewById(R.id.message);

        // Action du bouton
        btnMessage.setOnClickListener(v -> show.setText("Bonsoirrrr depuis Fragment 1 !"));
    }
    @Override
    public void onResume() {
        super.onResume();
        android.util.Log.d("FragmentOoooneeee", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        android.util.Log.d("FragmentOoooneeee", "onPause()");
    }
}
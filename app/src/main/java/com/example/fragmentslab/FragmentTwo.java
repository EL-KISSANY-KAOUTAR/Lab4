package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    private TextView Value;
    private SeekBar br;
    private int progressss = 0;
    private static final String KEYPROGRESS = "progressss";

    public FragmentTwo() {
        super(R.layout.fragment__ttwo);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Value = view.findViewById(R.id.Value);
        br = view.findViewById(R.id.barre);

        // Restauration de l’état si rotation
        if (savedInstanceState != null) {
            progressss = savedInstanceState.getInt(KEYPROGRESS, 0);
            br.setProgress(progressss);
            Value.setText("Valeur : " + progressss);
        }

        // quand le doigt bouge sur la barre
        br.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // la barre a bougé → on met à jour
            @Override public void onProgressChanged(SeekBar ss, int pr, boolean fromUser) {
                progressss = pr;
                Value.setText("Valeur : " + pr);
            }
            @Override public void onStartTrackingTouch(SeekBar ss) {}
            @Override public void onStopTrackingTouch(SeekBar ss) {}
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEYPROGRESS, progressss);
    }
}
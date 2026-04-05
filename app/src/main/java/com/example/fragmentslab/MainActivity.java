package com.example.fragmentslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button butonfr1, butonfr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butonfr1 = findViewById(R.id.btnFr1);
        butonfr2 = findViewById(R.id.btnFr2);

        // Afficher le premier fragment au démarrage
        if (savedInstanceState == null) {
            replaceFragment(new FragmentOne(), false);
        }

        // Ecoute du Clic sur bouton 1
        butonfr1.setOnClickListener(v -> replaceFragment(new FragmentOne(), true));
        // Ecoute du Clic sur bouton 2
        butonfr2.setOnClickListener(v -> replaceFragment(new FragmentTwo(), true));
    }

    // Méthode de remplacement de fragment
    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, fragment);

        if (addToBackStack) {
            ft.addToBackStack(null); // Revenir en arrière avec le bouton back
        }

        ft.commit(); // exécute et valide la transaction
    }
}
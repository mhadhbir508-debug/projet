package com.example.projet;

import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class GouvernoratsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scrollView = new ScrollView(requireContext());

        LinearLayout layout = new LinearLayout(requireContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);
        layout.setBackgroundColor(Color.rgb(245, 247, 250));

        TextView titre = new TextView(requireContext());
        titre.setText("Les 24 gouvernorats de Tunisie 🇹🇳");
        titre.setTextSize(23);
        titre.setTextColor(Color.rgb(18, 59, 93));
        titre.setGravity(Gravity.CENTER);
        titre.setTypeface(null, Typeface.BOLD);
        titre.setPadding(10, 20, 10, 25);

        layout.addView(titre);

        String[] gouvernorats = {
                "Tunis", "Ariana", "Ben Arous", "Manouba",
                "Nabeul", "Zaghouan", "Bizerte", "Béja",
                "Jendouba", "Le Kef", "Siliana", "Sousse",
                "Monastir", "Mahdia", "Sfax", "Kairouan",
                "Kasserine", "Sidi Bouzid", "Gabès", "Médenine",
                "Tataouine", "Gafsa", "Tozeur", "Kébili"
        };

        for (int i = 0; i < gouvernorats.length; i++) {

            TextView item = new TextView(requireContext());

            item.setText((i + 1) + " - " + gouvernorats[i]);
            item.setTextSize(18);
            item.setTextColor(Color.rgb(18, 59, 93));
            item.setPadding(20, 18, 20, 18);
            item.setBackgroundColor(Color.WHITE);
            item.setElevation(3);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    );

            params.setMargins(0, 6, 0, 6);

            layout.addView(item, params);
        }

        scrollView.addView(layout);

        return scrollView;
    }
}


package com.example.projet;

import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AproposFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scrollView = new ScrollView(requireContext());

        LinearLayout layout = new LinearLayout(requireContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 25, 20, 25);
        layout.setBackgroundColor(Color.rgb(245, 247, 250));

        TextView titre = new TextView(requireContext());
        titre.setText("À propos de Discover Tunisia 🇹🇳");
        titre.setTextSize(23);
        titre.setTextColor(Color.rgb(18, 59, 93));
        titre.setGravity(Gravity.CENTER);
        titre.setTypeface(null, android.graphics.Typeface.BOLD);
        titre.setPadding(10, 20, 10, 25);

        layout.addView(titre);

        TextView presentation = new TextView(requireContext());
        presentation.setText(
                "Discover Tunisia est une application mobile " +
                        "qui permet de découvrir les richesses touristiques " +
                        "de la Tunisie."
        );
        presentation.setTextSize(18);
        presentation.setTextColor(Color.DKGRAY);
        presentation.setPadding(15, 20, 15, 20);
        presentation.setBackgroundColor(Color.WHITE);

        layout.addView(presentation);

        TextView objectifs = new TextView(requireContext());
        objectifs.setText(
                "Objectifs de l'application :\n\n" +
                        "• Découvrir les sites touristiques.\n\n" +
                        "• Consulter les 24 gouvernorats.\n\n" +
                        "• Trouver des restaurants, hôtels et cafés.\n\n" +
                        "• Enregistrer les lieux favoris."
        );
        objectifs.setTextSize(17);
        objectifs.setTextColor(Color.rgb(18, 59, 93));
        objectifs.setPadding(15, 20, 15, 20);
        objectifs.setBackgroundColor(Color.WHITE);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 20, 0, 0);
        layout.addView(objectifs, params);

        scrollView.addView(layout);

        return scrollView;
    }
}

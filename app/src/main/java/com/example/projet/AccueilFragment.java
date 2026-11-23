
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

public class AccueilFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scrollView = new ScrollView(requireContext());

        LinearLayout layout = new LinearLayout(requireContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 25, 20, 25);
        layout.setBackgroundColor(Color.rgb(245, 247, 250));

        TextView titre = new TextView(requireContext());
        titre.setText("Bienvenue à Discover Tunisia 🇹🇳");
        titre.setTextSize(25);
        titre.setTextColor(Color.rgb(18, 59, 93));
        titre.setGravity(Gravity.CENTER);
        titre.setTypeface(null, Typeface.BOLD);
        titre.setPadding(10, 25, 10, 20);

        layout.addView(titre);

        TextView sousTitre = new TextView(requireContext());
        sousTitre.setText("Découvrez la beauté de la Tunisie !");
        sousTitre.setTextSize(20);
        sousTitre.setTextColor(Color.rgb(40, 100, 140));
        sousTitre.setGravity(Gravity.CENTER);
        sousTitre.setPadding(10, 10, 10, 20);

        layout.addView(sousTitre);

        TextView description = new TextView(requireContext());
        description.setText(
                "Bienvenue dans notre application Discover Tunisia. " +
                        "Cette application vous permet de découvrir les plus beaux " +
                        "lieux touristiques de la Tunisie, ses gouvernorats et ses " +
                        "différentes destinations."
        );
        description.setTextSize(17);
        description.setTextColor(Color.rgb(60, 60, 60));
        description.setPadding(15, 20, 15, 20);
        description.setBackgroundColor(Color.WHITE);

        layout.addView(description);

        TextView section = new TextView(requireContext());
        section.setText("Explorez la Tunisie 🌍");
        section.setTextSize(22);
        section.setTextColor(Color.rgb(18, 59, 93));
        section.setTypeface(null, Typeface.BOLD);
        section.setPadding(5, 30, 5, 15);

        layout.addView(section);

        String[] destinations = {
                "🏛️ Sites touristiques",
                "📍 24 gouvernorats",
                "❤️ Vos lieux favoris",
                "🍽️ Restaurants et hôtels"
        };

        for (String destination : destinations) {
            TextView item = new TextView(requireContext());
            item.setText(destination);
            item.setTextSize(18);
            item.setTextColor(Color.rgb(18, 59, 93));
            item.setPadding(20, 20, 20, 20);
            item.setBackgroundColor(Color.WHITE);
            item.setElevation(3);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    );

            params.setMargins(0, 7, 0, 7);
            layout.addView(item, params);
        }

        scrollView.addView(layout);

        return scrollView;
    }
}

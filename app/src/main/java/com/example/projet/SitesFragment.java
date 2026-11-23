package com.example.projet;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SitesFragment extends Fragment {
    private LinearLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scrollView = new ScrollView(requireContext());

        layout = new LinearLayout(requireContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);
        layout.setBackgroundColor(Color.rgb(245, 247, 250));

        TextView titre = new TextView(requireContext());
        titre.setText("Sites touristiques de Tunisie 🇹🇳");
        titre.setTextSize(23);
        titre.setTextColor(Color.rgb(18, 59, 93));
        titre.setGravity(Gravity.CENTER);
        titre.setPadding(10, 20, 10, 25);
        titre.setTypeface(null, android.graphics.Typeface.BOLD);

        layout.addView(titre);

        String[] sites = {
                "Amphithéâtre d'El Jem - Mahdia",
                "Sidi Bou Said - Tunis",
                "Carthage - Tunis",
                "Médina de Tunis - Tunis",
                "Cap Bon - Nabeul",
                "Plage de Hammamet - Nabeul",
                "Médina de Kairouan - Kairouan",
                "Chott el Jerid - Tozeur",
                "Oasis de Chebika - Tozeur",
                "Sahara de Douz - Kébili",
                "Matmata - Gabès",
                "Djerba - Médenine",
                "Ksar Ouled Soltane - Tataouine",
                "Ribat de Monastir - Monastir",
                "Médina de Sousse - Sousse",
                "Îles Kerkennah - Sfax"
        };

        for (int i = 0; i < sites.length; i++) {

            TextView item = new TextView(requireContext());

            item.setText((i + 1) + " - " + sites[i]);
            item.setTextSize(17);
            item.setTextColor(Color.rgb(18, 59, 93));
            item.setPadding(20, 18, 20, 18);
            item.setBackgroundColor(Color.WHITE);
            item.setElevation(3);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    );

            params.setMargins(0, 5, 0, 5);
            layout.addView(item, params);
            String siteSelectionne = sites[i];


            item.setOnClickListener(v -> {

                if (siteSelectionne.contains("Sidi Bou Said")) {

                    Intent intent = new Intent(requireContext(),
                            SidiBouSaidActivity.class);

                    startActivity(intent);

                } else {

                    Intent intent = new Intent(requireContext(),
                            DetailActivity.class);

                    intent.putExtra("nomSite", siteSelectionne);
                    startActivity(intent);
                }
            });

        }

        scrollView.addView(layout);

        return scrollView;
    }
    private void afficherDetails(String nomSite) {

        TextView details = new TextView(requireContext());

        details.setText("Détails de : " + nomSite
                + "\n\nRestaurants"
                + "\nHôtels"
                + "\nCafés");

        details.setTextSize(18);
        details.setTextColor(Color.BLACK);
        layout.addView(details);

        // Afficher les détails dans la même page
    }
}

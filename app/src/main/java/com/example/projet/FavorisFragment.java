
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
import android.content.SharedPreferences;

import androidx.fragment.app.Fragment;

import java.util.HashSet;
import java.util.Set;

public class FavorisFragment extends Fragment {

    private LinearLayout layout;
    private SharedPreferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scrollView = new ScrollView(requireContext());

        layout = new LinearLayout(requireContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);
        layout.setBackgroundColor(Color.rgb(245, 247, 250));

        preferences = requireContext().getSharedPreferences(
                "MesFavoris", android.content.Context.MODE_PRIVATE);

        TextView titre = new TextView(requireContext());
        titre.setText("Mes lieux favoris ❤️");
        titre.setTextSize(24);
        titre.setTextColor(Color.rgb(18, 59, 93));
        titre.setGravity(Gravity.CENTER);
        titre.setTypeface(null, android.graphics.Typeface.BOLD);
        titre.setPadding(10, 20, 10, 25);

        layout.addView(titre);

        afficherFavoris();

        scrollView.addView(layout);

        return scrollView;
    }

    private void afficherFavoris() {

        Set<String> favoris = preferences.getStringSet(
                "listeFavoris", new HashSet<>());

        layout.removeViews(1, layout.getChildCount() - 1);

        if (favoris.isEmpty()) {

            TextView message = new TextView(requireContext());
            message.setText(
                    "❤️ Aucun lieu favori pour le moment.\n\n" +
                            "Ajoutez vos destinations préférées pour les retrouver ici."
            );
            message.setTextSize(18);
            message.setTextColor(Color.rgb(18, 59, 93));
            message.setGravity(Gravity.CENTER);
            message.setPadding(20, 40, 20, 40);
            message.setBackgroundColor(Color.WHITE);

            layout.addView(message);

        } else {

            for (String nom : favoris) {

                TextView item = new TextView(requireContext());
                item.setText("❤️ " + nom + "\n\nAppuyez pour supprimer");
                item.setTextSize(17);
                item.setTextColor(Color.rgb(18, 59, 93));
                item.setPadding(20, 20, 20, 20);
                item.setBackgroundColor(Color.WHITE);
                item.setElevation(3);

                LinearLayout.LayoutParams params =
                        new LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT);

                params.setMargins(0, 6, 0, 6);
                layout.addView(item, params);

                item.setOnClickListener(v -> {
                    Set<String> nouvelleListe = new HashSet<>(favoris);
                    nouvelleListe.remove(nom);

                    preferences.edit()
                            .putStringSet("listeFavoris", nouvelleListe)
                            .apply();

                    afficherFavoris();
                });
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (layout != null) {
            afficherFavoris();
        }
    }
}


package com.example.projet;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String nomSite = getIntent().getStringExtra("nomSite");

        TextView txtNom = findViewById(R.id.txtNom);
        TextView txtGouvernorat = findViewById(R.id.txtGouvernorat);
        TextView txtDescription = findViewById(R.id.txtDescription);

        if (nomSite != null) {

            txtNom.setText(nomSite);

            if (nomSite.contains("El Jem")) {
                txtGouvernorat.setText("Gouvernorat : Mahdia");
                txtDescription.setText(
                        "L'amphithéâtre d'El Jem est un monument romain " +
                                "célèbre en Tunisie et classé au patrimoine mondial " +
                                "de l'UNESCO."
                );

            } else if (nomSite.contains("Sidi Bou Said")) {
                txtGouvernorat.setText("Gouvernorat : Tunis");
                txtDescription.setText(
                        "Sidi Bou Said est un village célèbre pour ses " +
                                "maisons blanches et ses portes bleues."
                );

            } else if (nomSite.contains("Carthage")) {
                txtGouvernorat.setText("Gouvernorat : Tunis");
                txtDescription.setText(
                        "Carthage est un site historique célèbre pour " +
                                "son patrimoine punique et romain."
                );

            } else if (nomSite.contains("Hammamet")) {
                txtGouvernorat.setText("Gouvernorat : Nabeul");
                txtDescription.setText(
                        "Hammamet est une destination touristique connue " +
                                "pour ses plages et sa médina."
                );

            } else if (nomSite.contains("Kairouan")) {
                txtGouvernorat.setText("Gouvernorat : Kairouan");
                txtDescription.setText(
                        "Kairouan est une ville historique connue pour " +
                                "sa grande mosquée et son patrimoine."
                );

            } else if (nomSite.contains("Tozeur") ||
                    nomSite.contains("Chebika")) {
                txtGouvernorat.setText("Gouvernorat : Tozeur");
                txtDescription.setText(
                        "Tozeur est célèbre pour ses oasis, ses palmeraies " +
                                "et ses paysages sahariens."
                );

            } else if (nomSite.contains("Douz")) {
                txtGouvernorat.setText("Gouvernorat : Kébili");
                txtDescription.setText(
                        "Douz est connue comme la porte du Sahara tunisien."
                );

            } else if (nomSite.contains("Matmata")) {
                txtGouvernorat.setText("Gouvernorat : Gabès");
                txtDescription.setText(
                        "Matmata est connue pour ses habitations " +
                                "traditionnelles creusées dans la terre."
                );

            } else if (nomSite.contains("Djerba")) {
                txtGouvernorat.setText("Gouvernorat : Médenine");
                txtDescription.setText(
                        "Djerba est une île connue pour ses plages " +
                                "et son patrimoine culturel."
                );

            } else if (nomSite.contains("Ouled Soltane")) {
                txtGouvernorat.setText("Gouvernorat : Tataouine");
                txtDescription.setText(
                        "Ksar Ouled Soltane est un ancien grenier " +
                                "collectif traditionnel du sud tunisien."
                );

            } else if (nomSite.contains("Monastir")) {
                txtGouvernorat.setText("Gouvernorat : Monastir");
                txtDescription.setText(
                        "Monastir est connue pour son Ribat historique " +
                                "et son patrimoine."
                );

            } else if (nomSite.contains("Sousse")) {
                txtGouvernorat.setText("Gouvernorat : Sousse");
                txtDescription.setText(
                        "La médina de Sousse est un site historique " +
                                "classé au patrimoine mondial de l'UNESCO."
                );

            } else if (nomSite.contains("Kerkennah")) {
                txtGouvernorat.setText("Gouvernorat : Sfax");
                txtDescription.setText(
                        "Les îles Kerkennah sont connues pour leurs " +
                                "paysages marins et leurs traditions de pêche."
                );

            } else {
                txtGouvernorat.setText("Gouvernorat : Tunisie");
                txtDescription.setText(
                        "Découvrez ce magnifique lieu touristique en Tunisie."
                );
            }
        }
    }

    public void ouvrirLieu(View view) {
        String nomLieu = view.getTag().toString();

        String recherche = nomLieu + ", El Jem, Mahdia, Tunisia";

        Uri uri = Uri.parse(
                "https://www.google.com/maps/search/?api=1&query="
                        + Uri.encode(recherche)
        );

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}

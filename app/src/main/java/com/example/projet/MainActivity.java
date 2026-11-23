package com.example.projet;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.appbar.MaterialToolbar;
import  com.google.android.material.navigation.NavigationView;
import android.view.Gravity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    private void afficherFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        DrawerLayout drawerLayout=findViewById(R.id.drawerLayout);
        MaterialToolbar toolbar=findViewById(R.id.toolbar);
        NavigationView navigationView=findViewById(R.id.navigationView);
        toolbar.setNavigationOnClickListener(v ->{drawerLayout.openDrawer(Gravity.LEFT);});
        navigationView.setNavigationItemSelectedListener(item -> {
            int id= item.getItemId();
            if(id==R.id.nav_accueil){
            } else if (id==R.id.nav_sites) {
            } else if (id==R.id.nav_gouvernorats) {
            } else if (id==R.id.nav_favoris) {
            }else if (id==R.id.nav_apropos) {
            }
            drawerLayout.closeDrawer(Gravity.LEFT);
            return true;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
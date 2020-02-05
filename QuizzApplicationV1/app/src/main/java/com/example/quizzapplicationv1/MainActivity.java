package com.example.quizzapplicationv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizzapplicationv1.AccountFragment;
import com.example.quizzapplicationv1.DocsFragment;
import com.example.quizzapplicationv1.HomeFragment;
import com.example.quizzapplicationv1.R;
import com.example.quizzapplicationv1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
 {

     private DrawerLayout drawer;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.quizzapplicationv1.HomeFragment()).commit();



         drawer = findViewById(R.id.drawer_layout);
         NavigationView navigationView = findViewById(R.id.nav_view);
         navigationView.setNavigationItemSelectedListener(this);


    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.nav_docs:
                    selectedFragment = new DocsFragment();
                    break;

                case R.id.nav_account:
                    selectedFragment = new AccountFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;

        }
    };


     //for each fragment replace the fragment_container by the fragment selected
     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
         switch (item.getItemId()) {
             case R.id.nav_message:
                 getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                         new ChapAFragment()).commit();
                 break;
             case R.id.nav_chat:
                 getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                         new ChapBFragment()).commit();
                 break;
             case R.id.nav_profile:
                 getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                         new ChapCFragment()).commit();
                 break;
             case R.id.nav_share:
                 Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.nav_send:
                 Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                 break;
         }

         drawer.closeDrawer(GravityCompat.START);
         return true;
     }

     //Ferme le drawer quand on appuie sur le bouton return
     @Override
     public void onBackPressed() {
         if (drawer.isDrawerOpen(GravityCompat.START)) {
             drawer.closeDrawer(GravityCompat.START);
         } else {
             super.onBackPressed();
         }
     }
 }

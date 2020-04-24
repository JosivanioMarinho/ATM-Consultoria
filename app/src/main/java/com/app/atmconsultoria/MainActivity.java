package com.app.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enviarEmail();

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        String celular = "tel:  81996352894";
        String imagem = "https://br.pinterest.com/pin/692780355151692277/";
        String endereco = "https://www.google.com.br/maps/place/Porto+Digital+-+NGPD+(Núcleo+de+Gestão+do+Porto+Digital)/@-8.0631227,-34.8761157,17z/data=!3m1!4b1!4m5!3m4!1s0x7ab18a3179eebef:0x7caecfbcc5347f69!8m2!3d-8.063128!4d-34.873927";
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));

        Intent intent = new Intent(Intent.ACTION_SEND);
                                                        //pode ser mais de um email
        intent.putExtra(intent.EXTRA_EMAIL, new String[]{"atmconsutoria@contato.com"});
        intent.putExtra(intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra(intent.EXTRA_TEXT, "Mensagem automática");

        intent.setType("message/rfc822");
        //intent.setType("texte/plain");
        //intent.setType("image/*"); // o asterisco serve para definir imagens de tipos diferentes
        //intent.setType("application/pdf");

        startActivity(intent.createChooser(intent, "Compartilhar"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

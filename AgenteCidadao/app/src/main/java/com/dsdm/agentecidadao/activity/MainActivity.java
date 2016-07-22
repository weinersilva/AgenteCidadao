package com.dsdm.agentecidadao.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.dsdm.agentecidadao.R;
import com.dsdm.agentecidadao.fragment.DenunciasFragment;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class MainActivity extends AppCompatActivity {



    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences prefs = getDefaultSharedPreferences(getApplicationContext());
        final boolean jaLogou = prefs.getBoolean("estaLogado", false);

        Button btnverdenuncias = (Button) findViewById(R.id.btn_denuncias);
        btnverdenuncias.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, DenunciasActivity.class);
                startActivity(intent);
            }

        });

        Button btnvernoticias = (Button) findViewById(R.id.btn_noticias);
        btnvernoticias.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, NoticiasActivity.class);
                startActivity(intent);
            }

        });

        Button btnNovaDenuncia = (Button) findViewById(R.id.btn_nova_denuncia);
        btnNovaDenuncia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                if(jaLogou){
                Intent intent = new Intent (MainActivity.this, DenunciaActivity.class);
                startActivity(intent);
                }else {
                    Intent intent = new Intent (MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuprincipal, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

      //String nome = user.getName();
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (item.getItemId() == R.id.sobre)
            startActivity(new Intent(this, SobreActivity.class));

        if (item.getItemId() == R.id.sair)
            try {
                finish();
                System.exit(0);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }


        return super.onOptionsItemSelected(item);
    }


}

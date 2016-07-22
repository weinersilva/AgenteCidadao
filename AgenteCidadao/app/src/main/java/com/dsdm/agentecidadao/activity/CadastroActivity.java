package com.dsdm.agentecidadao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dsdm.agentecidadao.R;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_fragment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}

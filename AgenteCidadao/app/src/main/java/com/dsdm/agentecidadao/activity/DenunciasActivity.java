package com.dsdm.agentecidadao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dsdm.agentecidadao.R;
import com.dsdm.agentecidadao.model.Denuncias;
import com.dsdm.agentecidadao.model.ListaDenuncias;


import com.dsdm.agentecidadao.services.ApiCliente;
import com.dsdm.agentecidadao.services.DenunciasService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class DenunciasActivity  extends AppCompatActivity {

    private static final String TAG = "Agente Cidadão -";
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //return inflater.inflate(R.layout.noticias_fragment, container, false);
        setContentView(R.layout.denuncia_fragment);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.denuncias_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        DenunciasService service = ApiCliente.getClient().create(DenunciasService.class);
        Call<ListaDenuncias> call = service.listDenuncias();

        call.enqueue(new Callback<ListaDenuncias>() {
            @Override
            public void onResponse(Call<ListaDenuncias> call, Response<ListaDenuncias> response) {
                int statusCode = response.code();
                List<Denuncias> denuncia = (List<Denuncias>) response.body();
                recyclerView.setAdapter(new ListaDenuncias(denuncia, R.layout.item_denuncia,getApplicationContext()));

            }

            @Override
            public void onFailure(Call<ListaDenuncias> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


    }

}

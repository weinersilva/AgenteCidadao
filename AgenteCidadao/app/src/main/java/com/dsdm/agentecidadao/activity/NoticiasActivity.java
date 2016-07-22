package com.dsdm.agentecidadao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dsdm.agentecidadao.R;
import com.dsdm.agentecidadao.model.ListaNoticias;
import com.dsdm.agentecidadao.model.Noticias;
import com.dsdm.agentecidadao.services.ApiCliente;
import com.dsdm.agentecidadao.services.NoticiasService;
import com.google.gson.Gson;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NoticiasActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://private-60846-agentecidadao.apiary-mock.com/";
    private static Retrofit retrofit = null;
    private RecyclerView recyclerView;
    private ListaNoticias lnoticias;
    List<Noticias.ItensNoticia> nots;
    private RecyclerView.LayoutManager mLayoutManager;

        @Override
        public void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.noticias_fragment);

            recyclerView = (RecyclerView) findViewById(R.id.noticias_recycler_view);

            OkHttpClient okClient = new OkHttpClient.Builder()
                    .addInterceptor(
                            new Interceptor() {
                                @Override
                                public okhttp3.Response intercept(Chain chain) throws IOException {
                                    Request request = chain.request().newBuilder()
                                            .addHeader("Accept", "Application/JSON").build();
                                    return chain.proceed(request);
                                }
                            }).build();

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(okClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

            NoticiasService service = retrofit.create(NoticiasService.class);


           Call<Noticias> call = service.getNoticiasCall(1);
            call.enqueue(new Callback<Noticias>() {
                @Override
                public void onResponse(Call<Noticias> call, Response<Noticias> response) {
                    Log.d("Agente Cidadão -", "Status Code = "+response.code());
                    if(response.isSuccessful()){
                        nots = new ArrayList<>();
                        Noticias result = response.body();
                        Log.d("Agente Cidadão", "response = " + new Gson().toJson(result));
                        nots = result.getNoticias();
                       // final int d = Log.d("Agente Cidadao", "nº noticias = " + nots.size());
                        lnoticias = new ListaNoticias(nots);

                        mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(lnoticias);

                    }
                }

                @Override
                public void onFailure(Call<Noticias> call, Throwable t) {

                }
            });
        }


}


package com.dsdm.agentecidadao.services;

import com.dsdm.agentecidadao.model.ListaNoticias;
import com.dsdm.agentecidadao.model.Noticias;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Desenvolvimento on 22/07/2016.
 */
public interface NoticiasService {

    @GET("noticias")

    Call<Noticias> getNoticiasCall(@Query("idusuario") int idusuario);

}

package com.dsdm.agentecidadao.services;

import com.dsdm.agentecidadao.model.ListaDenuncias;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Desenvolvimento on 22/07/2016.
 */
public interface DenunciasService {
    @GET("usuarios")
    Call<ListaDenuncias> listDenuncias();
}

package com.dsdm.agentecidadao.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Desenvolvimento on 22/07/2016.
 */
public class Noticias {

    public List<ItensNoticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<ItensNoticia> noticias) {
        this.noticias = noticias;
    }

    private List<ItensNoticia> noticias;


    public static class ItensNoticia {


        public Integer idusuario;
        public String titulo;
        public String data;
        public String descricao;

        public Integer getIdusuario() {
            return idusuario;
        }
        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    }
}
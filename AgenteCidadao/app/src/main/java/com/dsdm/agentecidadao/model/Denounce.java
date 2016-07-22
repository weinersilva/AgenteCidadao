package com.dsdm.agentecidadao.model;

import java.util.Date;
import java.util.List;

public class Denounce {
    private Integer iddenuncia;
    private Integer iduser;
    private Date data;
    private List<ListaImagens> listaImagens;
    private String endereco;
    private String descricao;

    public Integer getIddenuncia() {
        return iddenuncia;
    }

    public void setIddenuncia(Integer iddenuncia) {
        this.iddenuncia = iddenuncia;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ListaImagens> getListaImagens() {
        return listaImagens;
    }

    public void setListaImagens(List<ListaImagens> listaImagens) {
        this.listaImagens = listaImagens;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

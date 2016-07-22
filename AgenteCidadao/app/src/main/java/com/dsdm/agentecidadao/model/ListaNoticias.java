package com.dsdm.agentecidadao.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dsdm.agentecidadao.R;

import java.util.List;

/**
 * Created by Desenvolvimento on 22/07/2016.
 */
public class ListaNoticias extends RecyclerView.Adapter<ListaNoticias.NoticiaViewHolder> {

    public List<Noticias.ItensNoticia> itenslista;


    public ListaNoticias(List<Noticias.ItensNoticia> itenslista){
        this.itenslista = itenslista;
    }

    public static class NoticiaViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout noticiaLayout;
        TextView noticiaTitle;
        TextView data;
        TextView noticiaDescription;

        public NoticiaViewHolder(View v){
            super(v);
            noticiaLayout = (RelativeLayout) v.findViewById(R.id.layoutitemnoticia);
            noticiaTitle = (TextView) v.findViewById(R.id.titulonot);
            data = (TextView) v.findViewById(R.id.datanot);
            noticiaDescription = (TextView) v.findViewById(R.id.descricaonot);
        }
    }

    @Override
    public ListaNoticias.NoticiaViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noticias, parent, false);
        return new NoticiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListaNoticias.NoticiaViewHolder holder, final int position){
        holder.noticiaTitle.setText(itenslista.get(position).getTitulo());
        holder.data.setText(itenslista.get(position).getData());
        holder.noticiaDescription.setText(itenslista.get(position).getDescricao());

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}

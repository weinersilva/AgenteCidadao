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
public class ListaDenuncias extends RecyclerView.Adapter<ListaDenuncias.DenunciaViewHolder> {

    public void setDenuncias(List<Denuncias> denuncias) {
        this.denuncias = denuncias;
    }

    private List<Denuncias> denuncias;
    private int linhalayout;
    private Context context;

    public static class DenunciaViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout denunciaLayout;
        TextView denunciaid;
        TextView data;
        TextView denunciaDescription;

        public DenunciaViewHolder(View v){
            super(v);
            denunciaLayout = (RelativeLayout) v.findViewById(R.id.layoutitemdenuncia);
            denunciaid = (TextView) v.findViewById(R.id.titulodenu);
            data = (TextView) v.findViewById(R.id.datadenu);
            denunciaDescription = (TextView) v.findViewById(R.id.descricaodenu);
        }
    }

    public ListaDenuncias(List<Denuncias> denuncias, int linhalayout, Context context){
        this.denuncias = denuncias;
        this.linhalayout = linhalayout;
        this.context = context;
    }

    @Override
    public ListaDenuncias.DenunciaViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(linhalayout, parent, false);
        return new DenunciaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DenunciaViewHolder holder, final int position){
        holder.denunciaid.setText(denuncias.get(position).getIddenuncia());
        holder.data.setText(denuncias.get(position).getData());
        holder.denunciaDescription.setText(denuncias.get(position).getDescricao());

    }

    @Override
    public int getItemCount() {
        return denuncias.size();
    }

}

package com.dsdm.agentecidadao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsdm.agentecidadao.R;

/**
 * Created by Weiner on 16/07/2016.
 */
public class CadastroFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.cadastro_fragment, container, false);
    }
}

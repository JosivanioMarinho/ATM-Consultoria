package com.app.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        String descricao = "ATM consultoria tem como missão apoiar organizações " +
                "que desejam alcansar o sucesso através da excelência em gestão e " +
                "da busca pela qualidade";

                return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato:")
                .addEmail("atmconsultoria@contanto.com", "Envie um E-mail")
                .addWebsite("google.com", "Visite nosso site")

                .addGroup("Redes sociais")
                .addFacebook("Josivanio Marinho","Facebook")
                .addInstagram("Josivanio M.", "Instagran")
                .addGitHub("josivaniom", "GitHub")

                .addItem(versao)

                .create();

        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}

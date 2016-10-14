package unicap.grafos.unicapmaps.controller;


import android.content.Context;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;
import unicap.grafos.unicapmaps.view.ArestaView;

/**
 * Created by Cais Automação on 06/10/2016. project UnicapMaps
 */

public class GrafoController {

    public GrafoController(){

    }

    public StringBuilder exibirArestas(Grafo grafo){
        StringBuilder lista = new StringBuilder();
        for(Aresta aresta: grafo.getArestas()){
            lista.append(aresta.getA().getId());
            lista.append(" -> ");
            lista.append(aresta.getB().getId());
            lista.append('\n');
        }
        return lista;

    }

    public void showAresta(Grafo grafo, ArestaView arestaView, int idAresta) {
        Aresta aresta = grafo.getAresta(idAresta);
        arestaView.show(aresta);
    }

    public ArrayList<Aresta> buscaDijkstra(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Aresta> buscaLargura(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Aresta> buscaProfundidade(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Aresta> buscaEstrela(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Aresta> buscaGulosa(Vertice vInicial, Vertice vFinal){

        return null;
    }

}

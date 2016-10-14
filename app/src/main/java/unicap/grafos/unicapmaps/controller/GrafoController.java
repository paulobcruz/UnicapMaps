package unicap.grafos.unicapmaps.controller;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 06/10/2016. project UnicapMaps
 */

public class GrafoController {

    public GrafoController(){

    }

    public StringBuilder exibirArestas(Grafo grafo) {
        StringBuilder lista = new StringBuilder();
        for (Aresta aresta : grafo.getArestas()) {
            lista.append(aresta.getA().getId());
            lista.append(" -> ");
            lista.append(aresta.getB().getId());
            lista.append('\n');
        }
        return lista;
    }
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public ArrayList<Aresta> BuscaEmProfundidade(Vertice partida, Vertice chegada, Grafo map){
        //Variaveis
        int [] vetId ;
        vetId = new int [map.countVertices()];int j=0, i=0;
        Vertice vAt;
        Aresta arestaAT;
        ArrayList<Aresta> arestasDovAt, caminho = new ArrayList<Aresta>();
        Queue <Vertice> filaRetorno = new ArrayDeque<Vertice>();
        filaRetorno.add(partida);
        vAt = filaRetorno.peek();
        arestasDovAt=vAt.getArestas();

        while (!filaRetorno.isEmpty()){//percorrer Grafo
            arestaAT=arestasDovAt.get(0);
            caminho.add(j,arestaAT);j++;

        }
            return null;
    }
}

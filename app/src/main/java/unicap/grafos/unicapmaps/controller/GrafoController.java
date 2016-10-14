package unicap.grafos.unicapmaps.controller;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;
<<<<<<< HEAD
import unicap.grafos.unicapmaps.view.ArestaView;
=======
<<<<<<< HEAD
=======
import unicap.grafos.unicapmaps.view.ArestaView;
>>>>>>> upstream/master
>>>>>>> 82477fb9ed89d161b04e0d16cd226b855aa63a4c

/**
 * Created by Cais Automação on 06/10/2016. project UnicapMaps
 */

public class GrafoController {

    private Grafo grafo;

    public GrafoController(){
        Grafo.getInstance();
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

    public void showAresta(Grafo grafo, ArestaView arestaView, int idAresta) {
        Aresta aresta = grafo.getAresta(idAresta);
        arestaView.show(aresta);
    }

    public ArrayList<Aresta> buscaDijkstra(Vertice vInicial, Vertice vFinal){
        /*int menorCusto;
        int custoAcumulado = 0;
        ArrayList<Aresta> caminho = new ArrayList<>();
        Aresta menorAresta;



        while(true) {
            if(vInicial == vFinal){
                return caminho;
            }
            ArrayList<Aresta> arestasAdjacentes;
            arestasAdjacentes = vInicial.getArestas();
            if(arestasAdjacentes != null){
                menorCusto = arestasAdjacentes.get(0).getCusto();
                int idAresta = arestasAdjacentes.get(0).getId();
                for(Aresta atual: arestasAdjacentes){
                    if(atual.getCusto() < menorCusto){
                        menorCusto = atual.getCusto();
                        idAresta = atual.getId();
                    }
                }
                menorAresta = grafo.getAresta(idAresta);
                vInicial = menorAresta.getB();
                caminho.add(menorAresta);
                custoAcumulado += menorCusto;
            }else{
                return null;
            }
        }



        */
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

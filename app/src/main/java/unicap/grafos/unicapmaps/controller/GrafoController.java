package unicap.grafos.unicapmaps.controller;


import android.graphics.Color;
import android.icu.text.IDNA;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Stack;

import unicap.grafos.unicapmaps.controller.Buscas.FactoryBuscas;
import unicap.grafos.unicapmaps.controller.Buscas.InterfaceBuscaEmGrafo;
import unicap.grafos.unicapmaps.dao.InfoBlocos;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Coordenadas;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Trajeto;
import unicap.grafos.unicapmaps.model.Vertice;
import unicap.grafos.unicapmaps.view.ArestaPathView;

/**
 * Created by Cais Automação on 06/10/2016. project UnicapMaps
 */

public class GrafoController {

    private Grafo grafo;

    public GrafoController(){
        grafo = Grafo.getInstance();
    }

    public ArrayList<Aresta> buscar(int idVerticeInicial, int idVerticeFinal, String nomeBusca) {
        Vertice partida = grafo.getVertice(idVerticeInicial);
        Vertice chegada = grafo.getVertice(idVerticeFinal);

        InterfaceBuscaEmGrafo metodoBusca = FactoryBuscas.getInstance(this, nomeBusca);

        return metodoBusca.buscar(partida, chegada);
    }

    public StringBuilder exibirArestas( ArrayList<Aresta> arestas) {
        StringBuilder lista = new StringBuilder();
        if(arestas == null) {
            arestas = grafo.getArestas();
        }
        for (Aresta aresta : arestas) {
            lista.append(aresta.getA().getId());
            lista.append(" -> ");
            lista.append(aresta.getB().getId());
            lista.append('\n');
        }
        return lista;
    }


    public ArrayList<Aresta> getArestasFromVertices(Stack<Vertice> vertices) {
        ArrayList<Aresta> arestas = new ArrayList<>();
        Vertice atual, prox;
        int i;
        for(i = 0; i < vertices.size() - 1; i++){
            atual=vertices.get(i);
            prox=vertices.get(i+1);
            arestas.add(getArestaFromVertices(atual,prox));
        }

        return arestas;
    }



    public ArrayList<ArrayList<Coordenadas>> buscarCoordenadas(ArrayList<Integer> idsVertices) {
        ArrayList<ArrayList<Coordenadas>> coordenadas = new ArrayList<>();
        ArrayList<Aresta> arestas = new ArrayList<>();
        int i;
        for(i = 0; i < idsVertices.size() - 1; i++){
            Vertice vA = grafo.getVertice(idsVertices.get(i));
            Vertice vB = grafo.getVertice(idsVertices.get(i+1));
            arestas.add(getArestaFromVertices(vA,vB));
        }
        for(Aresta aresta: arestas){
            coordenadas.add(aresta.getCoordenadas());
        }
        return coordenadas;

    }

    public Aresta getArestaFromVertices(Vertice A, Vertice B){
        Aresta aresta = null;
        ArrayList<Vertice> adjacentes = A.getAdjacentes();
        if(adjacentes.contains(B)){
            ArrayList<Aresta> arestas = A.getArestas();
            for(Aresta atual: arestas){
                if(atual.getB() == B){
                    aresta = atual;
                    break;
                }
            }
        } else{
            //exceção
            return null;
        }
        return aresta;
    }

    public void logArestas(){
        String TAG = "ARESTA: ";
        ArrayList<Aresta> arestas = grafo.getArestas();
        for(Aresta atual: arestas){
            Vertice A = atual.getA();
            Vertice B = atual.getB();
            String nomeA = A.getNome();
            String nomeB = B.getNome();
            char a = nomeA.charAt(nomeA.length()-1);
            char b = nomeB.charAt(nomeB.length()-1);

            //if(atual.getA() != atual.getB()) {
            //Log.i(TAG, "id:"+ atual.getId() + " (" + atual.getA().getId() + " -> " + atual.getB().getId() +")");
            //Log.i(TAG, "id:"+ atual.getId() + " (" + atual.getA().getNome() + " -> " + atual.getB().getNome() +")");

            Log.i(TAG, "trajetos.add(new Trajeto("+ atual.getA().getId() +", "+ atual.getB().getId() +", "+ a +"_"+ b +"));");
            ///trajetos.add(new Trajeto(0, 1, A_B));
            //}
        }
        //TAG.getClass();
    }

    public ArrayList<Vertice> buscaDijkstra(Vertice vInicial, Vertice vFinal){
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

    public ArrayList<Vertice> buscaLargura(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Vertice> buscaProfundidade(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Vertice> buscaEstrela(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public ArrayList<Vertice> buscaGulosa(Vertice vInicial, Vertice vFinal){

        return null;
    }

    public int calcularDistancia(ArrayList<Aresta> caminho){
        int distancia = 0;
        for(Aresta atual: caminho){
            distancia += atual.getCusto();
        }
        return distancia;
    }

    public void exibirGrafoCompleto(ImageView arestaView, ArestaPathView pathView) {
        ArrayList<ArrayList<Coordenadas>> coordenadas = new ArrayList<>();
        ArrayList<Aresta> arestas = grafo.getArestas();
        int cor;
        for(Aresta atual : arestas){
            cor = Color.BLUE;
            coordenadas.add(atual.getCoordenadas());
            pathView.addPath(coordenadas, cor);
            coordenadas.clear();
        }
        for(Aresta atual : arestas){
            cor = Color.RED;
            if(atual.getA() == atual.getB()){
                pathView.addCircle(atual.getA().getCoordenadas().getX(), atual.getA().getCoordenadas().getY(), cor);
            }
        }

        arestaView.setImageBitmap(pathView.getBitmap());
    }

    public void exibirCaminho(ImageView arestaView, ArestaPathView pathView, ArrayList<Aresta> arestas, int cor) {
        ArrayList<ArrayList<Coordenadas>> coordenadas = new ArrayList<>();
        Vertice vInicial = arestas.get(0).getA();
        Vertice vFinal = arestas.get(arestas.size()-1).getB();

        for(Aresta atual : arestas){
            coordenadas.add(atual.getCoordenadas());
        }
        pathView.addPath(coordenadas, cor);

        pathView.addCircle(vInicial.getCoordenadas().getX(), vInicial.getCoordenadas().getY(), Color.BLACK);
        pathView.addCircle(vFinal.getCoordenadas().getX(), vFinal.getCoordenadas().getY(), Color.BLUE);

        arestaView.setImageBitmap(pathView.getBitmap());
    }

    public int getTotalVertices() {
        return grafo.countVertices();
    }

    public ArrayList<String[]> getInfoBlocos(){
        InfoBlocos infoBlocos = new InfoBlocos();
        return infoBlocos.getInfoBlocos();
    }


}
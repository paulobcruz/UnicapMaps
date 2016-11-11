package unicap.grafos.unicapmaps.dao;

import android.app.admin.DeviceAdminInfo;
import android.util.Log;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Coordenadas;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 10/11/2016. project UnicapMaps
 */

public class GrafoCreator {

    private Grafo grafo;
    private int matrizAdjacencias[][];
    private int coordenadas[][];
    private int grauMatriz;
    private int coordenadasComplementares[][][];
    private String nomesBlocos[];


    GrafoCreator(){

    }

    void construirGrafo(){
        grafo = Grafo.getInstance();
        GrafoController grafoController = new GrafoController();

        carregarDados();
        criarVertices();
        estabelecerAdjacencias();
        configCoordArestas();
        grafoController.logArestas();
        Log.i("--", "----------------------------------------------------------");
        espelharGrafo();
        grafoController.logArestas();
    }

    private void carregarDados() {
        matrizAdjacencias = Dados.getMatrizAdjacencias();
        coordenadas = Dados.getCoordenadasVertices();
        coordenadasComplementares = Dados.getCoordenadasComplementares();
        nomesBlocos = Dados.getNomesBlocos();
        grauMatriz = matrizAdjacencias.length;
    }


    private void criarVertices(){
        //criar vértices
        int id;

        for(id = 0; id < grauMatriz; id++){
            Vertice novo = new Vertice(id);
            Coordenadas ponto = new Coordenadas();
            ponto.setX(coordenadas[id][0]);
            ponto.setY(coordenadas[id][1]);
            novo.setCoordenadas(ponto);
            novo.setNome(nomesBlocos[id]);
            //novo.setDescricao(descricoes[i]);

            grafo.addVertice(novo);
        }
    }

    private void estabelecerAdjacencias() {
        int i;
        int id;
        Vertice adj;
        Aresta aresta;

        //verifica cada vertice se tem adjacencias, a partir da matriz de adjacencias
        for(Vertice atual: grafo.getVertices()){
            id = atual.getId();
            //atual.addAdjacente(atual);  //caso considerar laços, descomentar essa linha
            for(i = 0; i < grauMatriz; i++){
                if(matrizAdjacencias[id][i] == 1){ //se tiver adjacencia, o "i" é o id do vértice adjacente
                    //busca o vertice pelo id "i" e adiciona como adjacente no Vertice atual
                    adj = grafo.getVertice(i);
                    atual.addAdjacente(adj);

                    //cria aresta direcionada e adiciona tanto no grafo quanto no vertice
                    aresta = grafo.addAresta(atual, adj);
                    atual.addAresta(aresta);
                }
            }
        }
    }

    private void configCoordArestas(){
        int i = 0;
        int k, tamanho;

        for(Aresta aresta: grafo.getArestas()){
            Coordenadas p;

            //primeira coordenada
            p = aresta.getA().getCoordenadas();
            aresta.addCoord(p.getX(), p.getY());

            //coordenadas do meio
            /*tamanho = coordenadasComplementares[i].length;
            for(k = 0; k < tamanho; k++) {
                aresta.addCoord(coordenadasComplementares[i][k][0], coordenadasComplementares[i][k][1]);
            }*/

            //ultima coordenada
            p = aresta.getB().getCoordenadas();
            aresta.addCoord(p.getX(), p.getY());

            i++;
        }
    }

    private void espelharGrafo(){
        int i, tamanho;
        Vertice A, B;
        tamanho = grafo.getArestas().size();
        Aresta aresta, novaAresta;
        for(i = 0; i < tamanho; i++){
            aresta = grafo.getAresta(i);
            A = aresta.getA();
            B = aresta.getB();

            if(A != B){
                B.addAdjacente(A, 0);
                novaAresta = grafo.addAresta(B, A);
                B.addAresta(novaAresta);
                ArrayList<Coordenadas> coordenadasInvertidas = inverterCoordenadas(aresta);
                novaAresta.setCoordenadas(coordenadasInvertidas);
            }
        }
    }

    private ArrayList<Coordenadas> inverterCoordenadas(Aresta aresta){
        ArrayList<Coordenadas> coordenadasOriginais = aresta.getCoordenadas();
        ArrayList<Coordenadas> coordenadasInvertidas = new ArrayList<>();

        int i;
        int tamanho = coordenadasOriginais.size() - 1;

        for(i = tamanho; i >= 0; i--){
            coordenadasInvertidas.add(coordenadasOriginais.get(i));
        }
        return coordenadasInvertidas;
    }

    public Grafo getGrafo() {
        return grafo;
    }
}

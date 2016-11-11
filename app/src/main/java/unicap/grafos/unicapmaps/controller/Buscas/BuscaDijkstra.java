package unicap.grafos.unicapmaps.controller.Buscas;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 11/11/2016. project UnicapMaps
 */
public class BuscaDijkstra implements InterfaceBuscaEmGrafo {

    private GrafoController controller;

    public BuscaDijkstra(GrafoController controller) {
        this.controller = controller;
    }

    @Override
    public ArrayList<Aresta> buscar(Vertice partida, Vertice chegada) {
        return null;
    }
}

package unicap.grafos.unicapmaps.controller.Buscas;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Vertice;

/**
 * Created by Cais Automação on 11/11/2016. project UnicapMaps
 */

public interface InterfaceBuscaEmGrafo {
    public ArrayList<Aresta> buscar(Vertice partida, Vertice chegada);
}

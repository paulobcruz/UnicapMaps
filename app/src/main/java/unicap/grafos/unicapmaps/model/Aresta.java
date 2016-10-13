package unicap.grafos.unicapmaps.model;

import android.hardware.usb.UsbConfiguration;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


/**
 * Created by Cais Automação on 06/10/2016. project Unicap Maps
 */
public class Aresta {
    private int id;
    private Vertice A = null;
    private Vertice B = null;
    private int custo;
    private String descricao;
    private ArrayList<Coordenadas> coordTrajeto;
    //private restrições

    Aresta(Vertice a, Vertice b){
        this.A = a;
        this.B = b;
        coordTrajeto = new ArrayList<>();
    }

    private Vertice getAdjacente(Vertice vertice){
        if(vertice == null){
            //exceção
            return null;
        }else{
            if(vertice == A){
                return B;
            }else{
                return A;
            }
        }
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setA(Vertice a) {
        A = a;
    }

    public void setB(Vertice b) {
        B = b;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public Vertice getA() {
        return A;
    }

    public Vertice getB(){
        return B;
    }

    public void addCoord(int x, int y){
        Coordenadas novoPonto = new Coordenadas(x, y);
        coordTrajeto.add(novoPonto);
    }

    public ArrayList<Coordenadas> getCoordTrajeto() {
        return coordTrajeto;
    }
}

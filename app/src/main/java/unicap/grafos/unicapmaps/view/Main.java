package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.controller.GrafoController;
import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Coordenadas;
import unicap.grafos.unicapmaps.model.Grafo;
import unicap.grafos.unicapmaps.model.Vertice;

public class Main extends AppCompatActivity {

    private Grafo grafo = Grafo.getInstance();
    Context context;
    ZoomLayout mapaViewPort;
    ImageView jpgMapa;
    GrafoController grafoController;
    float escalaInicial;
    float escalaArestas;
    int windowWidth;
    int windowHeight;
    int mapaWidth;
    int mapaHeight;
    int larguraOriginal = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        grafoController = new GrafoController();

        // TUDO DAQUI PRA BAIXO AINDA É TESTE

        RelativeLayout mainActivity = (RelativeLayout) findViewById(R.id.root);
        String larguraMapa = Integer.toString(mainActivity.getWidth());
//        Toast.makeText(context, ""+escala, Toast.LENGTH_LONG).show();

        /* TESTES DE GABRIEL*/
        Vertice a = grafo.getVertice(0);
        Vertice b = grafo.getVertice(2);
        ArrayList<Aresta> caminho;

        caminho = grafoController.BuscaEmProfundidade(a, b);
        StringBuilder caminhoString = grafoController.exibirArestas(grafo, caminho);
        //Toast.makeText(context, caminhoString, Toast.LENGTH_LONG).show();
        /*FIM DOS TESTES DE GABRIEL*/



    }

    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        windowWidth = size.x;
        windowHeight = size.y;


        ImageView img = (ImageView) findViewById(R.id.imagem_mapa);
        mapaHeight = img.getHeight();
        mapaWidth = img.getWidth();

        if(mapaWidth > larguraOriginal){
            escalaInicial = mapaWidth*1.0f/larguraOriginal;
        }
        ArestaPathView pathView = new ArestaPathView(mapaWidth, mapaHeight, 2);


        ArrayList<Integer> idsVertices= new ArrayList<>();
        idsVertices.add(0);
        idsVertices.add(1);
        idsVertices.add(2);
        idsVertices.add(7);
        idsVertices.add(15);

        ImageView arestaView = (ImageView) findViewById( R.id.arestaConteiner);
        ArrayList<ArrayList<Coordenadas>> coordenadas;

        coordenadas = grafoController.buscarCoordenadas(grafo, idsVertices);
        pathView.addPath(coordenadas, Color.BLUE);

        idsVertices.clear();
        idsVertices.add(4);
        idsVertices.add(8);

        coordenadas = grafoController.buscarCoordenadas(grafo, idsVertices);
        pathView.addPath(coordenadas, Color.RED);

        arestaView.setImageBitmap(pathView.getBitmap());



        //findViewById(R.id.arestaConteiner).setLayoutParams(new android.widget.RelativeLayout.LayoutParams(mapaWidth, mapaHeight));

        /*mapaViewPort = (ZoomLayout) findViewById(R.id.mapaViewPort);
        mapaViewPort.ajustScale(escalaInicial);*/

    }
}

package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        grafoController = new GrafoController();
        Intent intent = getIntent();
        escalaArestas = intent.getFloatExtra("escala", 1);
        windowWidth = intent.getIntExtra("w_width", 0);
        windowHeight = intent.getIntExtra("w_height", 0);

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

        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        View view = inflater.inflate( R.layout.aresta_view, null );
        ArestaView arestaView = (ArestaView) view.findViewById( R.id.aresta_view );
        RelativeLayout arestaContainer = (RelativeLayout) findViewById(R.id.arestaConteiner);
        arestaContainer.addView(arestaView);



        ArrayList<Integer> idsArestas= new ArrayList<>();
        idsArestas.add(0);
        idsArestas.add(1);
        idsArestas.add(2);
        idsArestas.add(7);
        idsArestas.add(15);


        grafoController.desenharCaminho(grafo, arestaView, idsArestas, escalaArestas);


        //mapaViewPort.removeView(mapaConteudo);
        //mapaViewPort.addFilho(mapaConteudo);


    }

    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);

        ImageView img = (ImageView) findViewById(R.id.imagem_mapa);
        mapaHeight = img.getHeight();
        mapaWidth = img.getWidth();


        if(mapaHeight > windowHeight){
            escalaInicial = windowHeight*1.0f/mapaHeight;
        } else if(mapaWidth < windowWidth){
            escalaInicial = windowWidth*1.0f/mapaWidth;
        }

        findViewById(R.id.arestaConteiner).setLayoutParams(new android.widget.RelativeLayout.LayoutParams(mapaWidth, mapaHeight));






        //img.setScaleX(escalaInicial);
        //img.setScaleY(escalaInicial);
        /*mapaViewPort = (ZoomLayout) findViewById(R.id.mapaViewPort);
        mapaViewPort.ajustScale(escalaInicial);*/

    }
}

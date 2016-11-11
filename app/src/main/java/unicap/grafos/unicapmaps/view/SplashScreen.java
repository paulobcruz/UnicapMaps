package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.dao.GrafoDao;
import unicap.grafos.unicapmaps.model.Grafo;

public class SplashScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    protected void startMain() {
        Intent mainIntent = new Intent(SplashScreen.this, Main.class);
        startActivity(mainIntent);
        finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        LoadGrafo grafoLoader = new LoadGrafo();
        grafoLoader.execute();
    }

    class LoadGrafo extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
            //progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {
            GrafoDao grafoDao = new GrafoDao();
            Grafo grafo = Grafo.getInstance();
            if(grafo.getVertices().size() == 0){
                grafoDao.getGrafo();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            startMain();
        }
    }




}

package unicap.grafos.unicapmaps.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.dao.GrafoDao;
import unicap.grafos.unicapmaps.model.Grafo;

public class SplashScreen extends AppCompatActivity {

    int runOnce = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }

    protected void startMain() {
        Intent mainIntent = new Intent(SplashScreen.this, Main.class);
        startActivityForResult(mainIntent, 0);
        finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(runOnce == 0) {
            runOnce++;
            Grafo grafo = Grafo.getInstance();
            if (grafo.getVertices().size() == 0) {
                LoadGrafo grafoLoader = new LoadGrafo();
                grafoLoader.execute();
            } else {
                startMain();
            }
        }
    }

    class LoadGrafo extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            //ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
            //progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {
            GrafoDao grafoDao = new GrafoDao();
            grafoDao.getGrafo();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            startMain();
        }
    }
}

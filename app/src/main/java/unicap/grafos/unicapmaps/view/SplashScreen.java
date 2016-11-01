package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.Toast;

import unicap.grafos.unicapmaps.R;
import unicap.grafos.unicapmaps.dao.GrafoDao;

public class SplashScreen extends AppCompatActivity {

    float escala;
    int windowWidth;
    int windowHeight;
    int imageWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        GrafoDao dao = new GrafoDao();
        dao.montarGrafo();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        windowWidth = size.x;
        windowHeight = size.y;

        Drawable drawable = getResources().getDrawable(R.drawable.mapa_unicap);
        imageWidth = drawable.getIntrinsicWidth();
        escala = imageWidth*1.0f/windowWidth;


        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        /* Duration of wait */
        int SPLASH_DISPLAY_LENGTH = 1000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashScreen.this, Main.class);
                mainIntent.putExtra("escala", escala);
                mainIntent.putExtra("w_width", windowWidth);
                mainIntent.putExtra("w_height", windowHeight);

                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}

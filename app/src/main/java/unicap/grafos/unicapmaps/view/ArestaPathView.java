package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Coordenadas;

/**
 * Created by cais on 01/11/16.
 */

public class ArestaPathView {

    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    Path path;
    float escala;

    public ArestaPathView(int width, int height, float escala) {
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        path = new Path();
        this.escala = escala;

        setPaint();
    }

    private void setPaint() {
        paint.setStrokeWidth(12);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAlpha(127);
        paint.setAntiAlias(true);
    }

    public void addPath(ArrayList<ArrayList<Coordenadas>> coords, int cor){

        // Line color
        paint.setColor(cor);
        paint.setAlpha(127);

        path.reset();
        path.moveTo(coords.get(0).get(0).getX()*escala, coords.get(0).get(0).getY()*escala); //pega a primeira coordenada do primeiro array

        for(ArrayList<Coordenadas> lista: coords){
            for(Coordenadas ponto: lista){
                path.lineTo(ponto.getX()*escala, ponto.getY()*escala);
            }
        }

        canvas.drawPath(path, paint);
    }

    public Bitmap getBitmap(){
        return bitmap;
    }
}

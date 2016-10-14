package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Aresta;
import unicap.grafos.unicapmaps.model.Coordenadas;

/**
 * Created by Cais Automação on 08/10/2016. project UnicapMaps
 */

public class ArestaView extends View{

    Paint paint = new Paint();
    Path path = new Path();

    public ArestaView(Context context){
        super(context);
    }
    public ArestaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArestaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOriginByView(View view){
        this.setPivotX(view.getX());
        this.setPivotY(view.getPivotY());
    }

    private void setPaint() {
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAlpha(127);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);
    }

    public void show(Aresta aresta) {
        ArrayList<Coordenadas> coords = aresta.getCoordTrajeto();

        setPaint();
        path.reset();
        path.moveTo(coords.get(0).getX(), coords.get(0).getY());
        for(Coordenadas ponto: coords){
            path.lineTo(ponto.getX(), ponto.getY());
        }
    }
}

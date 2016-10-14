package unicap.grafos.unicapmaps.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Cais Automação on 14/10/2016. project UnicapMaps
 */

public class BotaoView extends Button {
    public BotaoView(Context context) {
        super(context);
        setText("Casa");
    }

    public BotaoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setText("Casa");
    }

    public BotaoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setText("Casa");
    }


}

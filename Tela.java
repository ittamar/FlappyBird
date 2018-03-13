package com.ittamar2.flappybird;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by itacode on 30/12/17.
 */

public class Tela {
    private DisplayMetrics displayMetrics;

    public Tela(Context context){
        WindowManager wm= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
       Display display = wm.getDefaultDisplay();
       displayMetrics = new DisplayMetrics();
       display.getMetrics(displayMetrics);
    }

    public int getAltura(){
        return displayMetrics.heightPixels;
    }

}

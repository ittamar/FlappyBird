package com.ittamar2.flappybird;

import android.graphics.Paint;

/**
 * Created by itacode on 30/12/17.
 */

public class Cores {

    public static Paint getCorDoPassaro(){
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        return vermelho;
    }

    public static Paint getCores() {
        Paint verde = new Paint();
        verde.setColor(0xFF00FF00);
        return verde;
    }
}

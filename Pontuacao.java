package com.ittamar2.flappybird;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import static android.graphics.Color.BLUE;

/**
 * Created by itacode on 01/02/18.
 */

public class Pontuacao {

    private Paint paint;
    private  int pontuacao;

    public void desenhaNoCanvas(Canvas canvas) {
            paint = new Paint();
            paint.setColor(Color.WHITE);
             paint.setTextSize(100);
             paint.setTypeface(Typeface.DEFAULT_BOLD);
             paint.setShadowLayer(3,5,5,Color.BLACK);
        canvas.drawText(String.valueOf(pontuacao),100,100,paint);
    }

    public void aumenta() {
        pontuacao ++;
    }

    public void gameOver(Canvas canvas){
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(80);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(3,5,5,Color.BLACK);
        canvas.drawText("GAME OVER" ,10,280,paint);
        canvas.drawText("ALICY KKK!" ,10,370,paint);
    }
}

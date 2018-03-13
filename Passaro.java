package com.ittamar2.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by itacode on 30/12/17.
 */

public class Passaro {
    private static final Paint vermelho = Cores.getCorDoPassaro();
    public static final int X = 100;
    public static final int RAIO = 50;
    private final Context context;
    private final Bitmap passaro;
    private float altura;
    private Tela tela;

    public Passaro( Tela tela, Context context) {
        this.context = context;
        this.tela = tela;
        this.altura =100;
        Bitmap bp = BitmapFactory.decodeResource(this.context.getResources(),R.drawable.passaro);
        //Tamanho do bitmap
        this.passaro =Bitmap.createScaledBitmap(bp,RAIO *2,RAIO * 2,false);
    }

    public void desenhaNo(Canvas canvas){
       // canvas.drawCircle(X,altura,RAIO, vermelho);
        canvas.drawBitmap(passaro,X - RAIO,altura - RAIO ,null);
    }

    public void cai() {
        //A soma da altura mais o raio for maior que getTela acrecenta cin
        boolean chegouNoChao= altura+ RAIO > tela.getAltura();
        if (!chegouNoChao){
            this.altura += 3;
        }

    }

    public void pula() {
        //quando a altura + o raio for maior que zero, o passárro pode pular
        if (altura - (RAIO * 3.9) > 0){
            this.altura -= 150;

        }

    }

    public int getX() {
        return X;
    }

    public int getRAIO() {
        return RAIO;
    }

    public int getAltura() {
        return (int) this.altura ;
    }
}

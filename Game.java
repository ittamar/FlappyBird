package com.ittamar2.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by itacode on 30/12/17.
 */

public class Game extends SurfaceView implements Runnable,View.OnTouchListener {
   // private static final android.R.attr R = ;
    private final Tela tela;
    private Context context;
    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap backgraound;
    private Canos canos;
    private Pontuacao pontuacao;


    public Game(Context context) {
        super(context);
        tela = new Tela(context);
        this.context = context;
        inicializaElementos();
        setOnTouchListener(this);


    }

    private void inicializaElementos() {
        this.passaro = new Passaro( tela,context);
        pontuacao = new Pontuacao();
        canos = new Canos(tela,pontuacao, context);

       Bitmap back = BitmapFactory.decodeResource(getResources(),R.drawable.background);
      backgraound = Bitmap.createScaledBitmap(back,back.getWidth(),tela.getAltura(),false);
    }

    @Override
    public void run() {
        while (isRunning){
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();
            canvas.drawBitmap(backgraound,0,0,null);
            passaro.desenhaNo(canvas);
            canos.move();
            passaro.cai();
             canos.desenhaNo(canvas);
            pontuacao.desenhaNoCanvas(canvas);


            if (new VerificadorDeColisao(passaro, canos).temColisao()){
                isRunning = false;
                pontuacao.gameOver(canvas);
            }
            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void pause(){
        this.isRunning = false;
    }

    public void iniciar(){
        this.isRunning = true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
       passaro.pula();
        return false;
    }
}

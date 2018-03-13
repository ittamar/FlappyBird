package com.ittamar2.flappybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.Random;

/**
 * Created by itacode on 22/01/18.
 */

public class Cano {

    private static final Paint VERDE =Cores.getCores() ;
    private final Bitmap canoInferior;
    private final Bitmap canoSuperior;
    private  int alturaDoCanoInferior;
    private int posicao;//Determina a lateral do cano
    private Context context;
    private Tela tela;
    private Random random = new Random();
    private  final int TAMANHO_DO_CANO = 350;//Determina o tamanho do cano
    private int larguraDoCano = 100;
    private int alturaDoCanoSuperior;


    public Cano(Tela tela, int posicao, Context context) {
        this.tela = tela;
        this.alturaDoCanoInferior = tela.getAltura() - random.nextInt( TAMANHO_DO_CANO);//Determina a altura do cano inferior
        this.posicao = posicao;
        this.context = context;
        this.alturaDoCanoSuperior = 0 + random.nextInt(TAMANHO_DO_CANO);
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        canoInferior = Bitmap.createScaledBitmap(bp,larguraDoCano,alturaDoCanoInferior,false);
        canoSuperior = Bitmap.createScaledBitmap(bp,larguraDoCano,alturaDoCanoSuperior,false);
    }

    public void desenhaNoCanvas(Canvas canvas) {
      for(int i = 0; i<5; i++){
          desenhaCanoInferior(canvas);
         desenhaCanoSuperior(canvas);
      }

    }

    private void desenhaCanoInferior(Canvas canvas) {
      // canvas.drawRect(posicao,alturaDoCanoInferior,posicao+larguraDoCano,tela.getAltura(),VERDE);
        canvas.drawBitmap(canoInferior,posicao,alturaDoCanoInferior,null);
    }

    private void desenhaCanoSuperior(Canvas canvas) {
        //canvas.drawRect(posicao,0,posicao+larguraDoCano,alturaDoCanoSuperior,VERDE);
        canvas.drawBitmap(canoSuperior,posicao,0,null);
    }

    public void move() {
        this.posicao -= 6;//Determina que o cano se mova
    }

    public boolean saiuDatela() {
        return posicao + larguraDoCano < 0;
    }
    //Retorna o valor da variavel posição
    public int getPosicao() {
        return  posicao;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
          if(posicao <  passaro.X + passaro.RAIO && posicao > passaro.getAltura()){
              return  true;
        }else if (this.alturaDoCanoInferior < passaro.getAltura() && posicao < passaro.X + passaro.RAIO
                  && posicao < passaro.getAltura()){
              return true;
          }
          return false;

    }

    public boolean temColisaoVeticalCom(Passaro passaro) {

           if( posicao < passaro.X + passaro.RAIO
                  && passaro.getAltura()- passaro.RAIO < this.alturaDoCanoSuperior){
              return true;
        }
         // Log.i("ALTURA", String.valueOf(passaro.getAltura()));
        Log.i("POSIÇÂO", String.valueOf(posicao));
          if (posicao < passaro.X+passaro.RAIO && passaro.getAltura() + passaro.RAIO-13 > this.alturaDoCanoInferior){
              return  true;
        }
        return false;

    }
}

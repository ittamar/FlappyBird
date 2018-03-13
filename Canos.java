package com.ittamar2.flappybird;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by itacode on 26/01/18.
 */

public class Canos {
    private final int distanciaEntreCanos = 140;//Distancia entre um cano e outro
    private final int quantidade_de_canos = 5;
    List<Cano> listCano = new ArrayList<>();
    private Tela tela;
    private Pontuacao pontuacao;
    private Context context;

    public Canos(Tela tela, Pontuacao pontuacao, Context context) {
        this.tela = tela;
        this.pontuacao = pontuacao;
        this.context = context;
        int posicao = 400;
             for (int i = 0; i < quantidade_de_canos; i++){
             posicao += distanciaEntreCanos;
            Cano cano = new Cano(tela,posicao,context);
            listCano.add(cano);
        }
    }

    public void desenhaNo(Canvas canvas){
        for (Cano cano : listCano){
            cano.desenhaNoCanvas(canvas);
        }
    }

    public void move(){
        ListIterator<Cano> iterator = listCano.listIterator();
        while (iterator.hasNext())
      {
            Cano cano = iterator.next();
            cano.move();
            if (cano.saiuDatela()){
                pontuacao.aumenta();
                iterator.remove();//quando o cano sai da tela, é removido, para não sobrecarregar a memória
                //cria outro cano
                Cano outroCano = new Cano(tela, getMaximo() + distanciaEntreCanos, context);

                iterator.add(outroCano);
            }
        }
    }

    private int getMaximo() {
        int maximo = 0;
        for (Cano cano : listCano){
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public boolean temColisaoComPassaro(Passaro passaro) {
        for (Cano cano : listCano){
            if (cano.temColisaoHorizontalCom(passaro) || cano.temColisaoVeticalCom(passaro)){
                return true;
            }
        }
        return false;
    }
}

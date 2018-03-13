package com.ittamar2.flappybird;

/**
 * Created by itacode on 01/02/18.
 */

class VerificadorDeColisao {
    private Passaro passaro;
    private Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return  canos.temColisaoComPassaro(passaro);
    }
}

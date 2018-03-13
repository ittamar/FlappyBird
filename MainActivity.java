
package com.ittamar2.flappybird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container =(FrameLayout)findViewById(R.id.container);
         game = new Game(this);
        container.addView(game);
    }

    @Override
    public void onPause() {
        super.onPause();
        game.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        game.iniciar();
        new Thread(game).start();
    }
}

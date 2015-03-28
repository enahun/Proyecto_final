package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by development on 21/3/15.
 */
public class Perdiste extends Image {

    Perdiste()
    {

        super(new Texture("perdiste.png"));
        addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer,int buttom)
            {

                    MyGdxGame.reiniciarJuego();

                    return  true;
            }

        });
    }
}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by development on 27/3/15.
 */
public class Nave2 extends Image {

    private Texture nave2;
    private TextureRegion minave2;
    Nave2()
    {
            super(new Texture("nave1.png"));
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("sonido.wav"));
        sound.play();
        setX(-getWidth());
            setY((float) (Math.random() * 1000) % 480 - 100);
            addListener(new ListennerNave2(this)); //se llama de parametro a nave
    }



    @Override
    public void act(float delta)
    {
        //HAce que la pelota se mueva a la derecha.
        float pos_vieja=getX();
        float pos_nueva=pos_vieja+7;
        setX(pos_nueva);
    }
}

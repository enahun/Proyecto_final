package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by development on 27/3/15.
 */
public class Nave1 extends Image {

    Nave1()
    {
        super(new Texture("nave2.png"));
        setX(-getWidth());
        setY((float)(Math.random()*1000)%480-100);
        addListener(new ListennerNave1(this)); //se llama de parametro a Pelotita
    }


    @Override
    public void act(float delta)
    {
        //HAce que la pelota se mueva a la derecha.
        float pos_vieja=getX();
        float pos_nueva=pos_vieja+3;
        setX(pos_nueva);
        //setX(getX()+1);
        /*super.act(delta);
        setY(getY());*/

    }
}

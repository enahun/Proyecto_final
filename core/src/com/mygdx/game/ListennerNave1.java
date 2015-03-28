package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by development on 27/3/15.
 */
public class ListennerNave1 extends InputListener {
    Nave1 nave1;

    ListennerNave1(Nave1 nave1)//recibe una Nave en este constructor
    {
        super();
        this.nave1=nave1;
    }



    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer,int buttom)
    {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("shoot.wav"));
        sound.play();
        MyGdxGame.pel_pres++;
        MyGdxGame.velocidad++;
        if(MyGdxGame.pel_pres>=15)
        {
            MyGdxGame.ganaste.setVisible(true);
            MyGdxGame.ganaste.toFront();
        }
        nave1.remove();


        return  true;
    }

}

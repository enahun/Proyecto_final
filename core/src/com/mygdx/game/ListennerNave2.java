package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by development on 27/3/15.
 */
public class ListennerNave2 extends InputListener {
    Nave2 nave2;

    ListennerNave2(Nave2 nave2)//recibe una Nave en este constructor
    {
        super();
        this.nave2=nave2;
    }


    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer,int buttom)
    {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("shoot.wav"));
        sound.play();
        MyGdxGame.bonus++;
        MyGdxGame.pel_pres++;
        MyGdxGame.velocidad++;
        if(MyGdxGame.pel_pres>=15)
        {
            MyGdxGame.ganaste.setVisible(true);
            MyGdxGame.ganaste.toFront();
        }
        if(MyGdxGame.bonus>=5) //Si el bono es mayor que 5 gana el juego
        {
            MyGdxGame.ganaste.setVisible(true);
            MyGdxGame.ganaste.toFront();
        }
        nave2.remove();
        if(MyGdxGame.bonus>3)
        {
            MyGdxGame.vida++;
        }

        return  true;
    }
}

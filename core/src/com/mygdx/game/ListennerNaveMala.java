package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by development on 27/3/15.
 */
public class ListennerNaveMala extends InputListener{

    NaveMala naveMala;
    ListennerNaveMala(NaveMala naveMala)
    {
        this.naveMala=naveMala;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer,int buttom) {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("shoot.wav"));
        sound.play();
        naveMala.remove();
         if (MyGdxGame.vida <=0) {
            MyGdxGame.perdiste.setVisible(true);
            MyGdxGame.perdiste.toFront();
        }
        MyGdxGame.vida--;

                return true;
            }
        }


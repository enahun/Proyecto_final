package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
    Stage stage;
    int Frame;
    static Ganaste ganaste; //se hizo variable global
    static Perdiste perdiste; //se hizo variable global


    static  ArrayList<Nave1> mi_nave;
    static ArrayList<Nave2> mi_nave2;
    static ArrayList<NaveMala> mi_navemala;

    static int pel_pres=0;
    static int bonus=0,vida=1;
    static int velocidad;

    SpriteBatch sprite_batch;
    BitmapFont bitmap_font;





    @Override
	public void create () {
        Frame=0;
        mi_nave=new ArrayList<Nave1>();                //crea instancia a las clases Templates
        mi_nave2=new ArrayList<Nave2>();                //crea instancia a las clases Templates
        mi_navemala=new ArrayList<NaveMala>();     // //crea instancia a las clases Templates
        stage=new Stage();

        stage.addActor(new Fondo());            //Instancia (agrega el fondo) Ojo hacerlo antes de nave
        stage.addActor(new Nave1());         //Instancia la clase nave en el escenario
        stage.addActor(new Nave2());         //Instancia la clase nave en el escenario
        stage.addActor(new NaveMala());         //Instancia la clase nave en el escenario

        ganaste =new Ganaste();                 //creamos la variable
        ganaste.setVisible(false);              //Escondemos la variable
        stage.addActor(ganaste);                //Se muestra "Ganaste" cuanto es true
        Gdx.input.setInputProcessor(stage);

        perdiste =new Perdiste();                 //creamos la variable
        perdiste.setVisible(false);              //Escondemos la variable
        stage.addActor(perdiste);                //Se muestra "Ganaste" cuanto es true
        Gdx.input.setInputProcessor(stage);

         sprite_batch=new SpriteBatch();
         bitmap_font=new BitmapFont();

    }

	@Override
	public void render () {
        if(!ganaste.isVisible()&& !perdiste.isVisible())
        {
            if (Frame%200==0)
            {
                Nave1 p=new Nave1();
                stage.addActor(p);
                mi_nave.add(p);
            }
            if (Frame%200==0)
            {
                Nave2 p=new Nave2();
                stage.addActor(p);
                 mi_nave2.add(p);
            }
            if (Frame%200==0)
            {
                NaveMala pm=new NaveMala();
                stage.addActor(pm);
                mi_navemala.add(pm);
            }


        }

        stage.draw(); //dibuja los actores en pantalla
        stage.act(); //hace la logica por separado de cada actor
        //Muesta texto en pantalla
        sprite_batch.begin();
        bitmap_font.draw(sprite_batch,"Explotadas :"+pel_pres,100,100);
        bitmap_font.draw(sprite_batch,"Bonus ataque :"+bonus,100,50);
        bitmap_font.draw(sprite_batch,"Vida :"+vida,100,30);

        //bitmap_font.draw(sprite_batch,"Tiempo :"+Frame,100,300);
        sprite_batch.end();
        //Fin de texto en pantalla
        Frame++;
	}

       static void reiniciarJuego()

        {       ganaste.setVisible(false);
                perdiste.setVisible(false);
                for (int i = 0; i < mi_nave.size(); i++) {
                    mi_nave.get(i).remove();
                }

                for (int i = 0; i < mi_nave2.size(); i++) {
                    mi_nave2.get(i).remove();
                }
                for (int i = 0; i < mi_navemala.size(); i++) {
                    mi_navemala.get(i).remove();
                }

                pel_pres = 0;
                bonus = 0;
                velocidad++;
        }
}

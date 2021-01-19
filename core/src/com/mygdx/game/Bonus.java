package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bonus implements IComponent{
    Sprite spriteBonus;
    Texture texture;
    SpaceShip spaceShip;
    public Bonus(Texture texture,int x,SpaceShip spaceShip){
        this.texture = texture;
        this.spriteBonus = new Sprite(texture);
        this.spaceShip = spaceShip;
    }

   public  void draw(Batch batch){
       spriteBonus.draw(batch);
   }

   public void update(){

   }

   public  float getyPosition(){
       return 0;
   }

   public  void dispose(){
       texture.dispose();
   }

   public Sprite getSprite(){
       return spriteBonus;
   }

   public  float getSize(){
        return 0;
   }
}

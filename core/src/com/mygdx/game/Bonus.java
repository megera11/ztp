package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bonus implements IComponent,IBonus{
    Sprite spriteBonus;
    Texture texture;
    SpaceShip spaceShip;
    IMoveStrategy moveStrategy;
    float xPosition;
    float yPosition;

    public Bonus(Texture texture, float x, float y, SpaceShip spaceShip, IMoveStrategy moveStrategy){
        this.texture = texture;
        this.spriteBonus = new Sprite(texture);
        this.spriteBonus.setPosition(x,y);
        this.spaceShip = spaceShip;
        this.xPosition = x;
        this.yPosition = y;
        this.moveStrategy = moveStrategy;
    }

   public  void draw(Batch batch){
       spriteBonus.draw(batch);
   }

   public void update(){
        moveStrategy.move(spriteBonus);
        yPosition = spriteBonus.getY();
        xPosition = spriteBonus.getX();
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
        return spriteBonus.getHeight();
   }

   public void modify(SpaceShip spaceShip){

   }
}

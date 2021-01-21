package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class LvlManager {

    private AliensGame game;
    private float timer;
    private SpaceShip spaceShip;
    private Array<IComponent> lasers;
    private Array<IComponent> enemies;
    private Array<IBonus> bonuses;
    private boolean buildinprogress = false;
    private int currentLevel = 1;
    private LevelBuilderDirector director = new LevelBuilderDirector();
    private Score score;

    public LvlManager(Array<IComponent> lasers, Array<IComponent> enemies, Array<IBonus> bonuses, AliensGame game, String nickname, SpaceShip spaceShip,Score score){
        this.lasers = lasers;
        this.enemies = enemies;
        this.game = game;
        this.score = score;
        this.spaceShip = spaceShip;
        this.bonuses = bonuses;
        this.timer = 0f;
    }

    public void render(float delta){

        timer += Gdx.graphics.getDeltaTime();

        if(enemies.size == 0 && buildinprogress==false){
            if(currentLevel==4){
                score.savetofile();
                game.setScreen(new EndGameScreen(game, score.getScore(), true));
            }
            if(timer >= 5f) {
                timer = 0f;
                this.buildinprogress = true;
                BuildLvl(currentLevel);
            }
        }
    }

    private void BuildLvl(int lvl){

        switch(lvl){
            case 1:
                EasyLevelBuilder easyLevelBuilder = new EasyLevelBuilder();
                director.LvlConstruct(easyLevelBuilder,spaceShip);
                enemies.addAll(easyLevelBuilder.getEnemies());
                bonuses.addAll(easyLevelBuilder.getBonuses());
                currentLevel++;
                break;
            case 2:

                SecondLevelBuilder secondLvlBuilder = new SecondLevelBuilder();
                director.LvlConstruct(secondLvlBuilder,spaceShip);
                enemies.addAll(secondLvlBuilder.getEnemies());
                bonuses.addAll(secondLvlBuilder.getBonuses());
                currentLevel++;
                break;
            case 3:

                BossLevelBuilder bossLevelBuilder = new BossLevelBuilder();
                director.LvlConstruct(bossLevelBuilder,spaceShip);
                enemies.addAll(bossLevelBuilder.getEnemies());
                bonuses.addAll(bossLevelBuilder.getBonuses());
                currentLevel++;
                break;
        }
        buildinprogress=false;


    }

}
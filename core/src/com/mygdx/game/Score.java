package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Score {

    int score;
    String nickname;

    public Score(String nickname){
        this.score = 0;
        this.nickname = nickname;
    }

    public static void printRanking(AliensGame game) {
        FileHandle file = Gdx.files.internal("scores.txt");
        game.font.draw(game.batch, "Ranking:", Gdx.graphics.getWidth() / 2, 450);
        game.font.draw(game.batch, file.readString(), Gdx.graphics.getWidth() / 2, 400);
    }

    public void savetofile() {
        FileHandle file = Gdx.files.local("scores.txt");
        String text = nickname + " " + Integer.toString(score) + "\n" + file.readString();
        file.writeString(text, false);

    }

    public void increasescore(){
        score++;
    }

    public int getScore() {
        return score;
    }
}
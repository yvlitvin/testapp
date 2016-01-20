package com.example.testapp;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by ylitvin on 16.01.2016.
 */
public class EnemyCircle extends SimpleCircle {

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 110;
    public static final int ENEMY_COLOR = Color.RED;
    public static final int FOOD_COLOR = Color.rgb(0, 200, 0);
    public static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy)    {
        super(x, y, radius);
        this.dx = dx;
        this.dy =dy;

    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getHeight());
        int y = random.nextInt(GameManager.getWidth());
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle enemyCircle = new EnemyCircle(x, y, radius, dx, dy);
        enemyCircle.setColor(ENEMY_COLOR);
        return enemyCircle;
    }

    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)) {
            setColor(FOOD_COLOR);
        } else {
            setColor((ENEMY_COLOR));
        }
    }

    protected boolean isSmallerThan(SimpleCircle circle) {
        if (radius < circle.radius){
            return true;

        }
        return false;
    }
    public void moveOneStep() {
        x += dy;
        y +=dy;
        checkBounds();
    }

    private void checkBounds() {
        if (x > GameManager.getWidth() || x < 0) {
            dx =- dx;
        }
        if (y > GameManager.getHeight() || y < 0 ){
            dy =-dy;
        }
    }
}

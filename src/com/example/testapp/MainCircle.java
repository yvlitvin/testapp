package com.example.testapp;

import android.graphics.Color;
import android.graphics.Matrix;

/**
 * Created by ylitvin on 14.01.2016.
 */
public class MainCircle extends SimpleCircle{
    public static final int INT = 50;
    public static final int MAIN_SPEED = 30;
    public static final int OUR_COLOR = Color.BLUE;

    public MainCircle(int x, int y, int radius) {
        super(x, y, INT);
        setColor(OUR_COLOR);
    }


    public void moveMainCircleWhenTouchAt(int x1, int y1) {
        int dx = (x1 - x) * MAIN_SPEED / GameManager.getWidth();
        int dy = (y1 - y) * MAIN_SPEED  / GameManager.getHeight();
        x += dx;
        y += dy;

    }

    public void initRadius() {
        radius = INT;
    }

    public void growRadius(SimpleCircle circle) {
        // pi * newr ^2 == pi *r ^2 + pi * reat ^ 2
        radius = (int) Math.sqrt(Math.pow(radius, 2) + Math.pow(circle.radius, 2));

    }
}

package snake.main.objects;

import snake.main.SnakeMain;

import java.awt.*;

/**
 * Created by Kolja on 20.03.2017.
 */
public class Point {

    public int posX;
    public int posY;

    public Point(){
        setRandomPosition();
    }

    public void setRandomPosition(){
        posX = Math.abs((int)(Math.random()* SnakeMain.height-1));
        posY = Math.abs((int)(Math.random()* SnakeMain.width-1));
    }



}

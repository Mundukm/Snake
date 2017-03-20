package snake.main.objects;

import snake.main.KeyBoard;
import snake.main.SnakeMain;

import java.awt.*;

/**
 * Created by Kolja on 13.03.2017.
 */
public class Snake {

    public int length = 2;
    public int direction = 37;

    public int[] sX = new int[300];
    public int[] sY = new int[300];

    public Snake(int x1, int y1, int x2, int y2){
        sX[0] = x1;
        sX[1] = x2;
        sY[0] = y1;
        sY[1] = y2;
    }

    public void move(){

        for(int i = length; i>0; i--){
            sX[i]=sX[i-1];
            sY[i]=sY[i-1];
        }

        //up
        if(direction==38) sY[0]-- ;
        //down
        if(direction==40) sY[0]++ ;
        //right
        if(direction==39) sX[0]++ ;
        //left
        if(direction==37) sX[0]-- ;

        //walls
        if(sY[0]> SnakeMain.height-1) sY[0] = 0;
        if(sY[0]< 0) sY[0] = SnakeMain.height-1;
        if(sX[0]> SnakeMain.width-1) sX[0] = 0;
        if(sX[0]< 0) sX[0] = SnakeMain.width-1;
    }

    public boolean insideSnake(int x, int y){
        for(int i = 0; i<length;i++){
            if(sX[i]==x&&sY[i]==y) return true;
        }
        return false;
    }

    public void paint(Graphics g){
        for(int i = 1; i<length; i++){
            g.setColor(SnakeMain.snakeBodyColor);
            g.fillRect(sX[i]*SnakeMain.scale+3, sY[i]*SnakeMain.scale+3,SnakeMain.scale-6, SnakeMain.scale-6);
            g.setColor(SnakeMain.snakeHeadColor);
            g.fillRect(sX[0]*SnakeMain.scale+3, sY[0]*SnakeMain.scale+3, SnakeMain.scale-6, SnakeMain.scale-6);
        }
    }


}

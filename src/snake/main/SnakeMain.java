package snake.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import snake.main.objects.*;

/**
 * Created by Kolja on 13.03.2017.
 */
public class SnakeMain extends JPanel implements ActionListener {

    public static Color backgroundColor = Color.pink;
    public static Color snakeBodyColor = Color.CYAN;
    public static Color snakeHeadColor = Color.darkGray;
    public static Color poisonColor = Color.red;
    public static Color appleColor = Color.yellow;
    public static JFrame jFrame;
    public static final int scale = 32;
    public static final int width = 20;
    public static final int height = 20;
    public static int speed = 10;

    public static KeyListener kl = new KeyBoard();
    public static Snake snake = new Snake(5,6,5);
    public Timer timer = new Timer(1000/speed,this);
    public Apple apple = new Apple(snake);
    public Poison poison = new Poison(snake);

    //for painting
    public void paint(Graphics g){

        //background
        g.setColor(backgroundColor);
        g.fillRect(0,0,scale*width, scale*height);

        apple.paint(g);
        poison.paint(g);
        snake.paint(g);
    }

    public SnakeMain(){
        timer.start();
        addKeyListener(kl);
        setFocusable(true);
    }

    public static void main(String [] args){

        //name of window
        jFrame = new JFrame("SCORE" + " : "  + snake.snakeList.size());
        //operation when close
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //sizing
        jFrame.setSize(scale*width+7, scale*height+30);
        //important option just to make our window visible
        jFrame.setVisible(true);
        //do not allow nobody to resize windiw
        jFrame.setResizable(false);
        //our window will be in the center of the screen
        jFrame.setLocationRelativeTo(null);

        jFrame.add(new SnakeMain());

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();

        if(snake.insideSnake(apple.posX, apple.posY)){
            do {

                apple.setRandomPosition(snake);
            }while(snake.insideSnake(apple.posX, apple.posY));
            snake.isEating=true;
            jFrame.setTitle("SCORE" + " : " + (snake.snakeList.size()+1));
        }

        if(snake.selfCrashed()||snake.insideSnake(poison.posX,poison.posY)){
            timer.stop();
            JOptionPane.showMessageDialog(null, "GAME OVER, TRY AGAIN?");
            snake = new Snake(5,6,5);
            apple.setRandomPosition(snake);
            poison.setRandomPosition(snake);
            timer.start();
        }

        repaint();
    }
}

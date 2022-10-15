package lesson11;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    int x;
    int y;
    int d;
    Color color;


    public Ball(int x, int y, int d, Color color) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.color = color;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getD(){
        return d;
    }
    public Color getColor(){
        return color;
    }
    public boolean isInBall(int x, int y){
        int centreX = this.x +d/2;
        int centeY = this.y +d/2;
        int distance = (int)Math.sqrt(Math.pow(centreX -x,2) + Math.pow(centeY -y, 2));
        return distance <= d/2;

    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,d,d);
        g.setColor(Color.black);
        g.drawOval(x,y,d,d);
    }
}

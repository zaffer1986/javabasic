package lesson11;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeWork11 extends JFrame {
    final int CANVAS_WIDTH=500;
    final int CANVAS_HEIGTH=400;

    final int DX=100;

    int x,y,dx;
    Color color;
    ImageIcon image;

    List<Ball> balls;



    final private Color[] colors = {Color.red, Color.green, Color.magenta, Color.orange, Color.gray, Color.blue};
    private Random random = new Random();


    public static void main(String[] args) {
        new HomeWork11();
    }

    public HomeWork11() {
        setTitle("Hello Java");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        CanvasPanel canvasPanel = new CanvasPanel();
        canvasPanel.setPreferredSize(new Dimension(CANVAS_WIDTH,CANVAS_HEIGTH));
        canvasPanel.setBackground(Color.white);

        intBalls();

        image=new ImageIcon("cat.jpg");

//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                super.keyReleased(e);
//                System.out.println(e.getKeyCode());
//                switch (e.getKeyCode()){
//                    case 32:
//                        randomXYColor();
//                        break;
//                    case 38:
//                        y-=5;
//                        break;
//                    case 40:
//                        y+=5;
//                        break;
//                    case 37:
//                        x-=5;
//                        break;
//                    case 39:
//                        x+=5;
//                        break;
//                }
//                canvasPanel.repaint();
//            }
//        });

        canvasPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println(e.getX() +":" +e.getY());
                for (int i = balls.size()-1; i>1; i--){
                    if(balls.get(i).isInBall(e.getX(),e.getY())){
                        balls.remove(i);
                        break;
                    }
                }
                canvasPanel.repaint();
            }
        });


        color =(colors[random.nextInt(colors.length)]);
        x = random.nextInt(CANVAS_HEIGTH -DX);
        y = random.nextInt(CANVAS_WIDTH -DX);
        dx=DX;

        Button repaint = new Button("Repaint");
        repaint.addActionListener(e -> {
                System.out.println("Repaint");
                randomXYColor();
                canvasPanel.repaint();

        });
        Button left;
        left = new Button("left");
        left.addActionListener(e -> {
            x -= 5;
            canvasPanel.repaint();

        });
        Button right = new Button("Right");
        right.addActionListener(e -> {
            x+=5;
            canvasPanel.repaint();

        });
        Button exit = new Button("Exit");
        exit.addActionListener(e -> System.exit(0));


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(repaint);
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(exit);

        add(canvasPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    private void randomXYColor(){
        color =(colors[random.nextInt(colors.length)]);
        x = random.nextInt(CANVAS_HEIGTH -DX);
        y = random.nextInt(CANVAS_WIDTH -DX);
        dx=DX;

    }

    private void intBalls(){
       balls=new ArrayList<>();
       for (int i=0; i<100; i++){
           Color color=(colors[random.nextInt(colors.length)]);
           int d =random.nextInt(100);
           int x = random.nextInt(CANVAS_HEIGTH -d);
           int y = random.nextInt(CANVAS_WIDTH -d);
           balls.add(new Ball(x,y,d,color));

       }
    }

    private static Button getExit() {
        return new Button("Exit");
    }

    private class CanvasPanel extends JPanel {

        public void paint(Graphics g) {
            super.paint(g);
            for (Ball ball : balls){
                ball.paint(g);
            }

            //g.setColor(color);
            //g.fillOval(x,y,dx,dx);
            //g.drawImage(image.getImage(),x,y,dx,dx, null);


//            for (int i = 0; i < 200; i++) {
//                g.setColor(colors[random.nextInt(colors.length)]);
//                int x = random.nextInt(CANVAS_HEIGTH);
//                int y = random.nextInt(CANVAS_WIDTH);
//                int dx = random.nextInt(DX);
//                int dy = random.nextInt(DX);
//                if (random.nextBoolean()) {
//                    g.fillRect(x, y, dx, dy);
//                } else {
//                    g.fillOval(x, y, dx, dy);
//
//                    g.fillOval(x, y, dx, dy);
//                }
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }
    }
}
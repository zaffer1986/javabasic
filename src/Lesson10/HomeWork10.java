package Lesson10;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
/**
 *Java basic: HomeWork10
 *
 @author Muzaffar Eshonqulov
 @todo 10.10.2022
 @date 13.10.2022
 *
 */

public class HomeWork10 extends JFrame {
    final private Color[] colors ={Color.red, Color.green,Color.magenta, Color.orange,Color.gray,Color.blue};
    private Random random=new Random();


    public static void main(String[] args) {
        new HomeWork10();
    }
    public HomeWork10(){
        setTitle("Hello Java");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,400);

        CanvasPanel canvasPanel =new CanvasPanel();
        canvasPanel.setBackground(Color.white);

        Button button = new Button("Repaint");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Repaint");
                canvasPanel.repaint();
            }
        });


        add(canvasPanel, BorderLayout.CENTER);
        add(button,BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    private  class CanvasPanel extends JPanel{

        public void paint(Graphics g){
            super.paint(g);

            for (int i =0; i < 200; i++) {
                g.setColor(colors[random.nextInt(colors.length)]);
                int x = random.nextInt(500);
                int y = random.nextInt(400);
                int dx = random.nextInt(100);
                int dy = random.nextInt(100);
                if (random.nextBoolean()) {
                    g.fillRect(x, y, dx, dy);
                } else {
                    g.fillOval(x, y, dx, dy);

                    g.fillOval(x, y, dx, dy);
                }
                try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
                }
            }

            /*g.setColor(Color.white);
            g.drawLine(10,10,10,100);
            g.setColor(Color.green );
            g.drawRect(20,20,100,50);
            g.setColor(Color.green);
            g.fillRect(50,50,100,50);
            g.drawOval(50,50,100,50);*/
        }
    }
}

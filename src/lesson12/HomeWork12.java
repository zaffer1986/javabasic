package lesson12;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *Java basic: HomeWork12
 *
 @author Muzaffar Eshonqulov
 @todo 17.10.2022
 @date 21.10.2022
 *
 */
public class HomeWork12  extends JFrame {
    private final int Panel_Size=500;
    private final int CELL_SIZE =Panel_Size/3;
    private boolean gameover=false;


    public static void main(String[] args) {
        new HomeWork12();
    }
    public HomeWork12(){
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        HomeWork6.init();

        PaintPanel paintPanel=new PaintPanel();
        paintPanel.setBackground(Color.white);
        paintPanel.setPreferredSize(new Dimension(Panel_Size,Panel_Size));

        paintPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               int x = e.getX()/CELL_SIZE;
                int y = e.getY()/CELL_SIZE;
                // hod cheloveka:
                if (HomeWork6.isCellValid(x, y) && !gameover) {
                    HomeWork6.table[y][x] = 'x';
                    if(HomeWork6.isWin('x')) {
                        System.out.println("you won");
                        gameover=true;
                    }
                    if(HomeWork6.isTableFull()) {
                        System.out.println("sorry, draw!");
                        gameover=true;
                    }
                    //hod komputera
                    if(!gameover){
                        HomeWork6.turnAI();
                        if (HomeWork6.isWin('0')) {
                            System.out.println("AI won!");
                            gameover =true;
                        }
                        if (HomeWork6.isTableFull()) {
                            System.out.println("sorry, draw!");
                            gameover=true;
                        }
                    }

                    paintPanel.repaint();
                }
            }
        });

        Button restart =new Button("Restart");
        restart.addActionListener(e -> {
            HomeWork6.init();
            gameover=false;
            paintPanel.repaint();
        });
        Button exit = new Button("Exit");
        exit.addActionListener(e -> System.exit(0));

        JPanel btnPanel = new JPanel();
        btnPanel.add(restart);
        btnPanel.add(exit);

        add(paintPanel,BorderLayout.CENTER);
        add(btnPanel,BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class PaintPanel extends JPanel{

        public void paint (Graphics g) {
            super.paint(g);
            //risuem ramki
            g.setColor(Color.gray);
            for (int i = 1; i < 3; i++) {
                g.drawLine(0, CELL_SIZE * i, Panel_Size, CELL_SIZE * i);
                g.drawLine(CELL_SIZE * i, 0, CELL_SIZE * i, Panel_Size);
            }
            Graphics2D g2=(Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(8f));
            //prohodim po tablise,risuya krestiki i noliki,esli oni est
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (HomeWork6.table[y][x] == 'x') {
                        g2.setColor(Color.blue);
                        g2.drawLine(x * CELL_SIZE+CELL_SIZE/5, y * CELL_SIZE+CELL_SIZE/5,
                                (x + 1) * CELL_SIZE-CELL_SIZE/5, (y + 1) * CELL_SIZE-CELL_SIZE/5);
                        g2.drawLine((x + 1) * CELL_SIZE-CELL_SIZE/5, y * CELL_SIZE+CELL_SIZE/5,
                                x * CELL_SIZE+CELL_SIZE/5, (y + 1) * CELL_SIZE-CELL_SIZE/5);
                    }
                    if (HomeWork6.table[y][x] == 'o') {
                        g2.setColor(Color.red);
                        g2.drawOval(x * CELL_SIZE + CELL_SIZE/5, y * CELL_SIZE + CELL_SIZE/5, CELL_SIZE - CELL_SIZE/5*2, CELL_SIZE - CELL_SIZE/5*2);
                    }
                }
            }

        }
    }
}

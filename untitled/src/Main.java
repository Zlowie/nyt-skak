import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class Main{
    //initialising variables
    public static boolean whiteturn = true;
    public static int SquareSize = 50;
    public static int BoardSize = 8;
    public static Color SquareColor1 = new Color(238,238,210);
    public static Color SquareColor2 = new Color(118, 150, 86);
    static ArrayList<BondeClass> Bonder = new ArrayList();


    //Main funktion
    public static void main(String[] args) {

        //JFrame oprettes
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                //start drawfunktionerne bliver kaldt
                super.paintComponent(g);
                startBoard(g);
                drawBoard(g);
            }
        };

        //værdierne på vores frme bliver kaldt
        panel.setPreferredSize(new Dimension(SquareSize*BoardSize, SquareSize*BoardSize));
        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Mouselistener bliver oprettet
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //tracker musens click
                int clicks = 0;
                int x = e.getX();
                int y = e.getY();
                System.out.println("X: " + x + ". Y: " + y);

                for (int i = 0; i < Bonder.size(); i++) {
                    //checker om musen har trykket på en square som indenholder en bonde
                    if (x > Bonder.get(i).getxLocation() && x < Bonder.get(i).getxLocation() + SquareSize && y > Bonder.get(i).getyLocation() && y < Bonder.get(i).getyLocation() + SquareSize) {
                        //checker om bonden er hvid eller sort
                        if(whiteturn && Bonder.get(i).isWhite){
                            //flytter velgte bonde
                            Bonder.get(i).moveCheck();
                            Graphics g = panel.getGraphics();
                            clicks = 1;
                            whiteturn = false;

                        }else if (whiteturn == false && Bonder.get(i).isWhite != true){
                            //flytter valgte bonde
                            Bonder.get(i).moveCheck();
                            whiteturn = true;
                        }

                        //gentegner boarded med nye bondepositioner
                        Graphics g = panel.getGraphics();
                        drawBoard(g);
                        Bonder.get(i).drawPremove(g);
                        System.out.println(Bonder.get(i));
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Handle mouse pressed event
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Handle mouse released event
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Handle mouse entered event
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Handle mouse exited event
            }
        });

        //press r to reset
        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_R) {
                    Bonder.clear();
                    Graphics g = panel.getGraphics();
                    startBoard(g);
                    drawBoard(g);
                }
            }
        });


        frame.setVisible(true);
    }

    //drawboard funktion som tegner boarded
    public static void drawBoard(Graphics g) {
        //Drawboard
        for (int i = 0; i < BoardSize; i++) {
            for (int j = 0; j < BoardSize; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(SquareColor1);
                } else {
                    g.setColor(SquareColor2);
                }
                g.fillRect(i * SquareSize, j * SquareSize, SquareSize, SquareSize);

            }
        }
        //tegner bonderne på boardet
        for (int i=0; i < Bonder.size(); i++){
            BondeClass bonde = Bonder.get(i);
            bonde.drawBonde(g);
        }
    }

    //Startboard funktionen som køre når man starter spillet for første gang
    public static void startBoard(Graphics g) {
        //loader alle brikkernes billeder
            BufferedImage Bbonde = null;
            BufferedImage Btårn = null;
            BufferedImage Bspringer = null;
            BufferedImage Bløber = null;
            BufferedImage Bdronning = null;
            BufferedImage Bkonge = null;
            BufferedImage Wbonde = null;
            BufferedImage Wtårn = null;
            BufferedImage Wspringer = null;
            BufferedImage Wløber = null;
            BufferedImage Wdronning = null;
            BufferedImage Wkonge = null;
            try {
                Bbonde = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\BlackPawn.png"));
                Btårn = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\BlackTower.png"));
                Bspringer = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\BlackHorse.png"));
                Bløber = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\BlackRunner.png"));
                Bdronning = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\BlackQueen.png"));
                Bkonge = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\BlackKing.png"));
                Wbonde = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\WhitePawn.png"));
                Wtårn = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\WhiteTower.png"));
                Wspringer = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\WhiteHorse.png"));
                Wløber = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\WhiteRunner.png"));
                Wdronning = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\WhiteQueen.png"));
                Wkonge = ImageIO.read(new File("C:\\Kode\\Java\\nyt-skak\\untitled\\src\\WhiteKing.png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
            //opretter bonder
            if (Bbonde != null) {
                //opretter sortebonder
                BondeClass BBonde1 = new BondeClass(Bbonde, 0, 1, false);
                Bonder.add(BBonde1);
                BondeClass BBonde2 = new BondeClass(Bbonde, 1, 1, false);
                Bonder.add(BBonde2);
                BondeClass BBonde3 = new BondeClass(Bbonde, 2, 1, false);
                Bonder.add(BBonde3);
                BondeClass BBonde4 = new BondeClass(Bbonde, 3, 1, false);
                Bonder.add(BBonde4);
                BondeClass BBonde5 = new BondeClass(Bbonde, 4, 1, false);
                Bonder.add(BBonde5);
                BondeClass BBonde6 = new BondeClass(Bbonde, 5, 1, false);
                Bonder.add(BBonde6);
                BondeClass BBonde7 = new BondeClass(Bbonde, 6, 1, false);
                Bonder.add(BBonde7);
                BondeClass BBonde8 = new BondeClass(Bbonde, 7, 1, false);
                Bonder.add(BBonde8);

                //opretter hvide bonder
                BondeClass WBonde1 = new BondeClass(Wbonde, 0, 6, true);
                Bonder.add(WBonde1);
                BondeClass WBonde2 = new BondeClass(Wbonde, 1, 6, true);
                Bonder.add(WBonde2);
                BondeClass WBonde3 = new BondeClass(Wbonde, 2, 6, true);
                Bonder.add(WBonde3);
                BondeClass WBonde4 = new BondeClass(Wbonde, 3, 6, true);
                Bonder.add(WBonde4);
                BondeClass WBonde5 = new BondeClass(Wbonde, 4, 6, true);
                Bonder.add(WBonde5);
                BondeClass WBonde6 = new BondeClass(Wbonde, 5, 6, true);
                Bonder.add(WBonde6);
                BondeClass WBonde7 = new BondeClass(Wbonde, 6, 6, true);
                Bonder.add(WBonde7);
                BondeClass WBonde8 = new BondeClass(Wbonde, 7, 6, true);
                Bonder.add(WBonde8);
            }
        }
    }
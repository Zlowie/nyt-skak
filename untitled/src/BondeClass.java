import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BondeClass extends PieceClass{

    //henter square size fra PieceClass
    private int SquareSize = PieceClass.getSquareSize();
    private boolean hasMoved = false;

    //bonde moves
    private int[][] whitePawnMoves = {{0,-1},{0,-2},{1,-1},{-1,-1}};
    private int[][] blackPawnMoves = {{0,1},{0,2},{1,1},{-1,1}};
    //private ArrayList<int[]> possibleMoves = new ArrayList<>();

    //premove
    private int[][] premove = new int[1][2];

    //bonde konstruktør
    public BondeClass(BufferedImage PieceImage, int xLocation, int yLocation, boolean isWhite) {
        super(PieceImage, xLocation, yLocation, isWhite);
    }


    //tegner premoves
    public void drawPremove(Graphics g){
        /*for (int i = 0; i < premove.length; i++) {
            g.setColor(Color.red);
            System.out.println("Premove: " + premove[i][0] + ". " + premove[i][1]);
            g.fillRect(super.getxLocation() + premove[i][0] * SquareSize, super.getyLocation() + premove[i][1] * SquareSize, SquareSize, SquareSize);
        }*/
    }
    //tegner bonde
    public void drawBonde(Graphics g){
        //System.out.println("Bonde: " + super.getxLocation() + ". " + super.getyLocation());
        g.drawImage(super.getPieceImage(), super.getxLocation(),super.getyLocation(),SquareSize,SquareSize,null);
    }

    //laver bonde string
    public String toString(){
        return super.toString("Bonde");
    }


    //flytter bonde
    public void moveCheck() {
        if (isWhite) {

            //flyte hvid bonde 1 frem
            this.setyLocation(this.getyLocation()-50);

            //premove[0][0] = whitePawnMoves[0][0];

            /*
            premove [0][0] = whitePawnMoves[0][1] * getSquareSize() + super.getyLocation();
            premove [0][1] = -whitePawnMoves[0][0] * getSquareSize() + super.getxLocation();
            */

            /*
            if (hasMoved == false) {
                super.setyLocation(whitePawnMoves[1][1] * getSquareSize() + super.getyLocation());
                super.setxLocation(-whitePawnMoves[1][0] * getSquareSize() + super.getxLocation());
            }

            whitePawnMoves[2][1] * getSquareSize() + super.getyLocation();
            -whitePawnMoves[2][0] * getSquareSize() + super.getxLocation();

            whitePawnMoves[3][1] * getSquareSize() + super.getyLocation();
            -whitePawnMoves[3][0] * getSquareSize() + super.getxLocation();*/

        } else {
            //flytter sort bunde
            this.setyLocation(this.getyLocation()+50);
        }
    }

}

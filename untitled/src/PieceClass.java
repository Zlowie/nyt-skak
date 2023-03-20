import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PieceClass {

    //initialisere variabler
    public final boolean isWhite;
    private int xLocation = 0;
    private int yLocation = 0;
    private BufferedImage PieceImage;
    private static int SquareSize = 50;

    //class constructor
    public PieceClass(BufferedImage PieceImage, int xLocation, int yLocation, boolean isWhite){
        this.xLocation = xLocation * SquareSize;
        this.yLocation = yLocation * SquareSize;
        this.PieceImage = PieceImage;
        this.isWhite = isWhite;

    }

    //variable settere
    public void setxLocation(int xLocation){
        this.xLocation = xLocation;
    }

    public void setyLocation(int yLocation){
        this.yLocation = yLocation;
    }
    public void setPieceImage(BufferedImage PieceImage){
            this.PieceImage = PieceImage;
    }

    //variable gettere
    public int getxLocation() {
        return xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public int getxLocationSquare() {
        return xLocation / SquareSize;
    }

    public int getyLocationSquare() {
        return yLocation / SquareSize;
    }
    public static int getSquareSize(){
        return SquareSize;
    }

    //her loader billeder ind
    public BufferedImage getPieceImage(){
        return PieceImage;
    }

    //toString funktion
    public String toString(String piecetype){
        String finalString ="x:" + xLocation + " y:" + yLocation + " | "+ piecetype + " | isWhite = " + isWhite;
        return finalString;
    }

    //checks possible moves
    public void moveCheck(){


    }
}

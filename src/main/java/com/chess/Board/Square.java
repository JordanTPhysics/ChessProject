package com.chess.Board;

import javax.swing.*;
import java.awt.*;

public class Square extends JFrame {


    private boolean squareIsWhite;
    private final Point squareLocation;
    private boolean isOccupied;

    public Square(boolean isOccupied, boolean squareIsWhite, Point squareLocation){
        this.squareLocation = squareLocation;
        this.isOccupied = false;
        this.squareIsWhite = squareIsWhite;
    }

public void reset(){
        this.isOccupied = false;
}



    public Point getSquareLocation() {
        return squareLocation;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    @Override
    public String toString() {
        return "Square{" +
                ", location=" + squareLocation +
                ", isOccupied=" + isOccupied +
                '}';
    }

    public boolean isSquareIsWhite() {
        return squareIsWhite;
    }
    public void setSquareIsWhite(boolean squareIsWhite){
        this.squareIsWhite = squareIsWhite;
    }


}

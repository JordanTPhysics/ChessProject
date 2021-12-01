package com.chess.Pieces;

import java.awt.*;

public class Pawn extends Piece{



    public Pawn(String colour, int x, int y, boolean hasMoved, Point pieceLocation) {
        super(x, y, colour, hasMoved, pieceLocation);
        this.colour = colour;
        this.x = x;
        this.y = y;
        this.hasMoved = hasMoved;
        this.pieceLocation = pieceLocation;


    }


    @Override
    public boolean canMove(int finalX, int finalY) {
        int xDif = finalX - this.getX();
        int yDif = finalY - this.getY();
        if(colour == "white" && !hasMoved && xDif == 0 && (yDif == 2 || yDif == 1)) {
            setHasMoved(true);
            return true;
        }
        if(colour == "black" && !hasMoved && xDif == 0 && (yDif == -2 || yDif == -1)){
            setHasMoved(true);
            return true;
        }

    return false;
    }

    @Override
    public int[][] drawPath(int xDif, int yDif) {
        return new int[0][];
    }
}

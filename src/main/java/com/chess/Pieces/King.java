package com.chess.Pieces;

import com.chess.
        Board.Board;

import java.awt.*;

public class King extends Piece{
    public King(String colour, int x, int y, boolean hasMoved, Point pieceLocation) {
        super(x, y, colour, hasMoved, pieceLocation);
        this.colour = colour;
        this.x = x;
        this.y = y;
        this.hasMoved = hasMoved;
        this.pieceLocation=pieceLocation;

    }




    @Override
    public boolean canMove(int finalX, int finalY) {
        int xDif = Math.abs(finalX-this.getX());
        int yDif = Math.abs(finalY-this.getY());
        setHasMoved(true);
        return xDif < 2 && yDif < 2;
    }

    @Override
    public int[][] drawPath(int Xdiff, int Ydiff) {
        return new int[0][];
    }
}

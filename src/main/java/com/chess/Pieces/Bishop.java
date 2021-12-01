package com.chess.Pieces;

import com.chess.Board.Board;

import java.awt.*;

public class Bishop extends Piece{

    public Bishop(String colour, int x, int y, Point pieceLocation) {
        super(x, y, colour, pieceLocation);
        this.colour = colour;
        this.x = x;
        this.y = y;
        this.pieceLocation=pieceLocation;

    }


    @Override
    public boolean canMove(int finalX, int finalY) {
        if(Math.abs(this.getX()-finalX) == Math.abs(this.getY()-finalY)){
            return true;
        }
        return false;
    }

    @Override
    public int[][] drawPath(int Xdiff, int Ydiff) {
        return new int[0][];
    }
}

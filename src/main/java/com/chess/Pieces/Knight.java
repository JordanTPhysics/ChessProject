package com.chess.Pieces;

import com.chess.Board.Board;

import java.awt.*;

public class Knight extends Piece {

    public Knight(String colour, int x, int y, Point piecelocation) {
        super(x, y, colour, piecelocation);
        this.colour = colour;
        this.x = x;
        this.y = y;
        this.pieceLocation=piecelocation;

    }



    @Override
    public boolean canMove(int finalX, int finalY) {
        int Xdiff = Math.abs(x -finalX);
        int Ydiff = Math.abs(y -finalY);
        if(Xdiff*Ydiff == 2){
            return true;
        }


    return true;
    }

    @Override
    public int[][] drawPath(int Xdiff, int Ydiff) {
        return new int[0][];
    }
}

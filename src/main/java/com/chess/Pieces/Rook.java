package com.chess.Pieces;

import com.chess.Board.Board;

import java.awt.*;


public class Rook extends Piece{



    public Rook(String colour, int x, int y, boolean hasMoved, Point pieceLocation) {
    super(x, y, colour, hasMoved, pieceLocation);
        this.colour = colour;
        this.x = x;
        this.x = y;
        this.hasMoved = hasMoved;
        this.pieceLocation=pieceLocation;

    }


    @Override
    public boolean canMove(int finalX, int finalY) {
      if(this.getX() !=finalX && this.getY() !=finalY ){
          return false;
      }

        setHasMoved(true);
      return true;
    }

    @Override
    public int[][] drawPath(int Xdiff, int Ydiff) {
        return new int[0][];
    }
}

package com.chess.Pieces;

import com.chess.Board.Board;

import java.awt.*;

public abstract class Piece {

    boolean hasMoved;
    protected Point pieceLocation;
    public Board board;
    String colour;
    protected int x;
    protected int y;


    public Piece(int x, int y, String colour, boolean hasMoved, Point pieceLocation){
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.hasMoved = hasMoved;
        this.pieceLocation = pieceLocation;



    }

    public Point getPieceLocation() {
        return pieceLocation;
    }

    public void setPieceLocation(Point pieceLocation) {
        pieceLocation.setLocation(x,y);
    }

    public Piece(int x, int y, String colour, Point pieceLocation){
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.pieceLocation = pieceLocation;



    }




    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Board getBoard(){
        return board;
    }
    public void setBoard(Board board){
        this.board=board;
    }



public abstract boolean canMove(int finalX,int finalY );

public abstract int[][] drawPath(int Xdiff,int Ydiff);



}

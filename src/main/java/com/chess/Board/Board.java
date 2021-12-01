package com.chess.Board;


import com.chess.GUI.DrawingImage;
import com.chess.GUI.DrawingShape;
import com.chess.Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
@SuppressWarnings("serial")
public class Board extends JComponent{
    public int turnCounter = 0;

    private final int squareWidth = 65;
    public ArrayList<Piece> WhitePieces;
    public ArrayList<Piece> BlackPieces;

    public ArrayList<DrawingShape> StaticShapes;
    public ArrayList<DrawingShape> PieceGraphics;

    public Piece ActivePiece;

    private final int rank = 8;
    private final int file = 8;
    private Integer[][] BoardGrid;
    private Graphics2D g2;
    private Graphics g;

    public void initGrid() {


      /*  for (int i = 0; i < rank; i++) {

            for (int j = 0; j < file; j++) {
                BoardGrid[i][j] = 0;
                String[] files = {"A","B","C","D","E","F","G","H"};
                JFrame boardLayout = new JFrame();

                GridLayout boardGridLayout = new GridLayout(file, rank,0,0);
                boardGridLayout.addLayoutComponent("Square",new JLabel("Square"));


            }
        }
*/
        new King("white",5,7,true,getLocation(5,7));
        WhitePieces.add(new King("white", 4, 0, false),);

        WhitePieces.add(new Bishop("white", 2, 0, , this));
        WhitePieces.add(new Bishop("white", 5, 0, , this));
        BlackPieces.add(new Bishop("black", 2, 7, , this));
        BlackPieces.add(new Bishop("black", 5, 7, , this));
        WhitePieces.add(new Knight("white", 1, 0, ));
        WhitePieces.add(new Knight("white", 6, 0, getComponent()));
        BlackPieces.add(new Knight("black", 1, 7, this));
        BlackPieces.add(new Knight("black", 6, 7, this));
        BlackPieces.add(new King("black", 4, 7, false, , this));
        WhitePieces.add(new Queen("white", 0, 3, this));
        BlackPieces.add(new Queen("black", 3, 7, this));
        WhitePieces.add(new Rook("white", 0, 0, false, this));
        WhitePieces.add(new Rook("white", 7, 0, false, this));
        BlackPieces.add(new Rook("black", 0, 7, false, this));
        BlackPieces.add(new Rook("black", 7, 7, false, this));
        WhitePieces.add(new Pawn("white", 0, 1, false, this));
        WhitePieces.add(new Pawn("white", 1, 1, false, this));
        WhitePieces.add(new Pawn("white", 2, 1, false, this));
        WhitePieces.add(new Pawn("white", 3, 1, false, this));
        WhitePieces.add(new Pawn("white", 4, 1, false, this));
        WhitePieces.add(new Pawn("white", 5, 1, false, this));
        WhitePieces.add(new Pawn("white", 6, 1, false, this));
        WhitePieces.add(new Pawn("white", 7, 1, false, this));
        BlackPieces.add(new Pawn("black", 0, 6, false, this));
        BlackPieces.add(new Pawn("black", 1, 6, false, this));
        BlackPieces.add(new Pawn("black", 2, 6, false, this));
        BlackPieces.add(new Pawn("black", 3, 6, false, this));
        BlackPieces.add(new Pawn("black", 4, 6, false, this));
        BlackPieces.add(new Pawn("black", 5, 6, false, this));
        BlackPieces.add(new Pawn("black", 6, 6, false, this));
        BlackPieces.add(new Pawn("black", 7, 6, false, this));

    }

    public Board() {

        BoardGrid = new Integer[rank][file];

        StaticShapes = new ArrayList();
        PieceGraphics = new ArrayList();
        WhitePieces = new ArrayList();
        BlackPieces = new ArrayList();

        initGrid();

        this.setBackground(new Color(58, 13, 84));
        this.setPreferredSize(new Dimension(520, 520));
        this.setSize(new Dimension(520, 520));
        this.setMinimumSize(new Dimension(100, 100));
        this.setMaximumSize(new Dimension(1000, 1000));

        this.addMouseListener(mouseAdapter);
        this.addComponentListener(componentAdapter);
        this.addKeyListener(keyAdapter);

        this.setVisible(true);
        this.requestFocus();
        drawBoard();
    }



    private void drawBoard() {
        PieceGraphics.clear();
        StaticShapes.clear();

        ImageIcon board = new ImageIcon("images/board.png");


        StaticShapes.add(new DrawingImage(board, new Rectangle2D.Double(0, 0, board.getIconWidth(), board.getIconHeight())));

        if (ActivePiece != null) {
            ImageIcon active_square = new ImageIcon("images/active_square.png");
            StaticShapes.add(new DrawingImage(active_square, new Rectangle2D.Double(squareWidth * ActivePiece.getX(), squareWidth * ActivePiece.getY(), active_square.getIconWidth(), active_square.getIconHeight())));
        }
        ImageIcon whitePawn = new ImageIcon("images/white_pieces/Pawn.png");
        ImageIcon whiteRook = new ImageIcon("images/white_pieces/Rook.png");
        ImageIcon whiteBishop = new ImageIcon("images/white_pieces/Bishop.png");
        ImageIcon whiteQueen = new ImageIcon("images/white_pieces/Queen.png");
        ImageIcon whiteKing = new ImageIcon("images/white_pieces/King.png");
        ImageIcon whiteKnight = new ImageIcon("images/white_pieces/Knight.png");
        ImageIcon blackPawn = new ImageIcon("images/black_pieces/Pawn.png");
        ImageIcon blackRook = new ImageIcon("images/black_pieces/Rook.png");
        ImageIcon blackBishop = new ImageIcon("images/black_pieces/Bishop.png");
        ImageIcon blackQueen = new ImageIcon("images/black_pieces/Queen.png");
        ImageIcon blackKing = new ImageIcon("images/black_pieces/King.png");
        ImageIcon blackKnight = new ImageIcon("images/black_pieces/Knight.png");



        this.repaint();
    }
        public Piece getPieceLocation(int x, int y){
            for (Piece p : WhitePieces)
            {
                if (p.getX() == x && p.getY() == y)
                {
                    return p;
                }
            }
            for (Piece p : BlackPieces)
            {
                if (p.getX() == x && p.getY() == y)
                {
                    return p;
                }
            }
            return null;
        }



        MouseAdapter mouseAdapter = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {


            }

            @Override
            public void mousePressed(MouseEvent e) {
                int d_X = e.getX();
                int d_Y = e.getY();
                int Clicked_Row = d_Y / squareWidth;
                int Clicked_Column = d_X / squareWidth;
                boolean is_whites_turn = true;
                if (turnCounter % 2 == 1) {
                    is_whites_turn = false;
                }

                Piece clicked_piece = getPieceLocation(Clicked_Column, Clicked_Row);

                if (ActivePiece == null && clicked_piece != null &&
                        ((is_whites_turn && clicked_piece.getColour().equals("white")) || (!is_whites_turn && clicked_piece.getColour().equals("black")))) {
                    ActivePiece = clicked_piece;
                } else if (ActivePiece != null && ActivePiece.getX() == Clicked_Column && ActivePiece.getY() == Clicked_Row) {
                    ActivePiece = null;
                } else if (ActivePiece != null && ActivePiece.canMove(Clicked_Column, Clicked_Row)
                        && ((is_whites_turn && ActivePiece.getColour().equals("white")) || (!is_whites_turn && ActivePiece.getColour().equals("black")))) {
                    // if piece is there, remove it so we can be there
                    if (clicked_piece != null) {
                        if (clicked_piece.getColour().equals("white")) {
                            WhitePieces.remove(clicked_piece);
                        } else {
                            BlackPieces.remove(clicked_piece);
                        }
                    }
                    // do move
                    ActivePiece.setX(Clicked_Column);
                    ActivePiece.setY(Clicked_Row);

                    // if piece is a pawn set has_moved to true
                    if (ActivePiece.getClass().equals(Pawn.class)) {
                        Pawn castedPawn = (Pawn) (ActivePiece);
                        castedPawn.setHasMoved(true);
                    }


                    ActivePiece = null;
                    turnCounter++;
                }

                drawBoard();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
            }


        };

        private void adjustShapePositions ( double dx, double dy){

            StaticShapes.get(0).adjustPosition(dx, dy);
            this.repaint();

        }


        protected void paintComponent (Graphics g){

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            drawBackground(g2);
            drawShapes(g2);
        }

        private void drawBackground (Graphics2D g2){
            g2.setColor(getBackground());
            g2.fillRect(0, 0, getWidth(), getHeight());
        }


        private void drawShapes (Graphics2D g2){
            for (DrawingShape shape : StaticShapes) {
                shape.draw(g2);
            }
            for (DrawingShape shape : PieceGraphics) {
                shape.draw(g2);
            }
        }


        ComponentAdapter componentAdapter = new ComponentAdapter() {

            @Override
            public void componentHidden(ComponentEvent e) {

            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentResized(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }
        };

        KeyAdapter keyAdapter = new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyTyped(KeyEvent e) {

            }
        };






    }







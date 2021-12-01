package com.chess.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI  {

    public ChessFrame chessFrame;

    public static void main(String[] args){
        GUI gui = new GUI();
        gui.chessFrame = new ChessFrame();
        gui.chessFrame.setVisible(true);

    }


}

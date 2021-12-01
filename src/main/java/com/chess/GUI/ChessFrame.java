package com.chess.GUI;

import com.chess.Board.Board;

import javax.swing.*;
import java.awt.*;

public class ChessFrame extends JFrame {

    Component component;

    public ChessFrame(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        component = new Board();
        this.add(component, BorderLayout.CENTER);
        this.setTitle("Chess");
        this.getGraphics();
        this.setLocation(0,0);
        this.pack();
        this.setVisible(true);


    }
}

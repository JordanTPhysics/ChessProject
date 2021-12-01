//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.chess.GUI;

import javax.swing.*;
import java.awt.Graphics2D;

import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

public class DrawingImage implements DrawingShape{
    public ImageIcon imageIcon;
    public Rectangle2D rect;

    public DrawingImage(ImageIcon imageIcon, Rectangle2D rect) {
        this.imageIcon = imageIcon;
        this.rect = rect;
    }

    public boolean contains(Graphics2D g2, double x, double y) {
        return this.rect.contains(x, y);
    }

    public void adjustPosition(double dx, double dy) {
        this.rect.setRect(this.rect.getX() + dx, this.rect.getY() + dy, this.rect.getWidth(), this.rect.getHeight());
    }

    public void draw(Graphics2D g2) {
        Rectangle2D bounds = this.rect.getBounds2D();
        g2.drawImage(imageIcon.getImage(),  (int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getMaxX(), (int)bounds.getMaxY(), 0, 0, this.imageIcon.getIconWidth(), this.imageIcon.getIconHeight(), (ImageObserver)null);
    }
}

package com.qracker.FrameLearn;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.InvocationTargetException;

public class DrawTest {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        EventQueue.invokeAndWait(()->{
            JFrame frame = new DrawFrame();
            frame.setTitle("DrawFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(false);
        });
    }
}

class DrawFrame extends JFrame {
    public DrawFrame() {
        DrawComponent p = new DrawComponent();
        p.setBackground(Color.ORANGE);
        add(p);
        pack();
    }
}

class DrawComponent extends JComponent{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;
    private Color bkgColor;

    public void setBackground(Color bkgColor) {
        this.bkgColor = bkgColor;
    }


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Color defaultColor = g2.getColor();

        //set the color of background
        g2.setColor(bkgColor);
        Rectangle2D bkg = new Rectangle2D.Double(0,0,DEFAULT_WIDTH,DEFAULT_HEIGHT);
        g2.fill(bkg);
        g2.setColor(defaultColor);

        //go on painting with the color before
        g2.setColor(Color.green);
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;
        Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
        g2.draw(rect);

        g2.setColor(Color.BLUE);
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.fill(ellipse);
        g2.draw(ellipse);

        g2.setColor(Color.MAGENTA);
        g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height));

        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
        g2.draw(circle);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
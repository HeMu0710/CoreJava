package com.qracker.ConcurrencyLearn.bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;


public class BounceThread {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        EventQueue.invokeAndWait(()->{
            JFrame frame = new BounceThreadFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BounceThreadFrame extends JFrame {
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    public BounceThreadFrame() {
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp,BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
            Ball ball = new Ball();
            comp.add(ball);
            Runnable r = () -> {
                try{
                    for(int i = 1; i <= STEPS; i++){
                        ball.move(comp.getBounds());
                        comp.repaint();
                        Thread.sleep(DELAY);
                    }
                } catch (InterruptedException e) {
                }
            };
            Thread t = new Thread(r);
            t.start();
    }
}

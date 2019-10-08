package com.qracker.FrameLearn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class ButtonFrameTest {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        EventQueue.invokeAndWait(() -> {
            JFrame frame = new ButtonFrame();
            frame.setVisible(true);
            frame.setTitle("ButtonFrameTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}

class ButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    ButtonFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");

        buttonPanel = new JPanel();
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        add(buttonPanel);

        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }

    private class ColorAction implements ActionListener {
        private Color bkgColor;

        ColorAction(Color c){
            this.bkgColor = c;
        }

        public void actionPerformed(ActionEvent event) {
            buttonPanel.setBackground(bkgColor);
        }
    }
}

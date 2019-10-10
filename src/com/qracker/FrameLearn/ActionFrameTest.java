package com.qracker.FrameLearn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;

public class ActionFrameTest {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        EventQueue.invokeAndWait(()->{
            JFrame frame = new ActionFrame();
            frame.setTitle("ActionFrameTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ActionFrame extends JFrame{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    ActionFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        buttonPanel = new JPanel();
        Action yellowAction = new ColorAction("Yellow",new ImageIcon("yellow-ball.gif"),Color.YELLOW);
        Action blueAction = new ColorAction("Blue",new ImageIcon("blue-ball.gif"),Color.BLUE);
        Action redAction = new ColorAction("Red",new ImageIcon("red-ball.gif"),Color.RED);

        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        add(buttonPanel);

        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"),yellowAction);
        imap.put(KeyStroke.getKeyStroke("ctrl B"),blueAction);
        imap.put(KeyStroke.getKeyStroke("ctrl R"),redAction);

        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow",yellowAction);
        amap.put("panel.blue",blueAction);
        amap.put("panel.red",redAction);
    }

    class ColorAction extends AbstractAction{
        ColorAction(String name, Icon icon, Color c){
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON,icon);
            putValue(Action.SHORT_DESCRIPTION,"Set panel color to" + name.toLowerCase());
            putValue("color", c);
        }

        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("Color");
            buttonPanel.setBackground(c);
        }
    }
}

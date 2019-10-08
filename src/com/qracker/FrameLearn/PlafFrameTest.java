package com.qracker.FrameLearn;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class PlafFrameTest {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        EventQueue.invokeAndWait(()->{
            JFrame frame = new PlafFrame();
            frame.setTitle("PlafFrameTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class PlafFrame extends JFrame{
    private JPanel buttonPanel;

    PlafFrame(){
        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos =UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info: infos
             ) {
            makeButton(info.getName(), info.getClassName());
        }
        add(buttonPanel);
        pack();
    }

    private void makeButton(String name, String className) {
        JButton button = new JButton(name);
        buttonPanel.add(button);

        button.addActionListener(event->{
            try{
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}

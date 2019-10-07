package com.qracker.FrameLearn;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class SizedFrameTest {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        EventQueue.invokeAndWait(()->{
            JFrame frame = new SizedFrame();
            frame.setTitle("SizedFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setResizable(false);
        });
    }
}

class SizedFrame extends JFrame {
    public SizedFrame(){
        //get screen dimensions

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
        Image img = new ImageIcon("icon.gif").getImage();
        setIconImage(img);
    }
}

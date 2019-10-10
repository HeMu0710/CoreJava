package com.qracker.appletLearn;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;

public class NotHelloWorld extends JMenuBar{
    public void init() throws InvocationTargetException, InterruptedException {
        EventQueue.invokeAndWait(()->{
            JLabel label = new JLabel("Not a Hello,World applet?",SwingConstants.CENTER);
            add(label);
        });
    }
}

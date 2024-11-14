package com.wizwolf.client.util;

import org.springframework.util.ResourceUtils;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.net.URL;

public class Splash extends JFrame {
    private static Splash instance = null;
    private Label message;

    public Splash() {
        this.message = new Label("wizwolf");
        this.initUI();
        this.display();
    }

    public static Splash getInstance() {
        if (null == instance) {
            synchronized (Splash.class) {
                if (null == instance) {
                    instance = new Splash();
                }
            }
        }
        return instance;
    }

    public void initUI() {
        this.setBackground(Color.white);
        this.setName("splash");
        this.setUndecorated(true);

        this.message.setFont(new java.awt.Font("Serif", 3, 20));
        this.message.setForeground(SystemColor.activeCaption);
        this.message.setAlignment(Label.CENTER);

        try {
            URL path = ResourceUtils.getURL("classpath:static/images/AD10030.png");
            JPicture aImage = new JPicture(path.getPath());
            this.add(aImage, BorderLayout.WEST);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.add(message, BorderLayout.EAST);
    }

    private void display()
    {
        this.pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle box = getBounds();
        this.setBounds((screen.width - box.width) / 2, (screen.height - box.height) / 2, box.width, box.height);
        this.setVisible(true);
    }

    public void setText (String text)
    {
        this.message.setText(text);
        this.display();
    }

    public void dispose()
    {
        super.dispose();
        Splash.instance = null;
    }
}

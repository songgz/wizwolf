package com.wizwolf.client.util;

import javax.swing.*;
import java.awt.*;

public class JPicture extends JComponent {
    private ImageIcon imgIcon;

    public JPicture(String path) {
        this.imgIcon = new ImageIcon(path);
    }

    @Override
    public Dimension getPreferredSize()
    {
       return new Dimension (this.imgIcon.getIconWidth(), this.imgIcon.getIconHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.imgIcon.getImage(), 0,0,this);
    }
}

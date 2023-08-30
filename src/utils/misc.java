package utils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class misc {

    private static misc instance;

    public static misc getInstance() {
        if (instance == null) {
            instance = new misc();
        }
        return instance;
    }

    public void addComponent(Container container, Component component, int gridx, int gridy,
                             int gridwidth, int gridheight, int anchor, int fill, Insets insets,
                             int ipadx, int ipady, double weightx, double weighty) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty,
                anchor, fill, insets, ipadx, ipady);
        container.add(component, gbc);
    }

    public void addComponent(Container container, Component component, int gridx, int gridy,
                             int gridwidth, int gridheight, int anchor, int fill, Insets insets) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
                0.0, 0.0, anchor, fill, insets, 45, 40);
        container.add(component, gbc);
    }

    public JButton makeDesignButton(JButton jButton, Color colorForeground,
                                    Color colorBackground, String actionCommand, ActionListener listener) {
        Font buttonFont = new Font("Arial", Font.BOLD, 40);
        jButton.setActionCommand(actionCommand);
        jButton.addActionListener(listener);
        jButton.setForeground(colorForeground);
        jButton.setBackground(colorBackground);
        jButton.setFont(buttonFont);
        return jButton;
    }

    public String toCast(double number) {
        return Double.toString(number);
    }
}

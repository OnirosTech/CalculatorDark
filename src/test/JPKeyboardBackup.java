package test;

import utils.misc;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JPKeyboardBackup extends JFrame {

    private static misc ms = misc.getInstance();
    public JPKeyboardBackup(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Basic Calculator - SASB");
        this.setSize(515,565);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.initComponents();//param: listener
    }

    public void initComponents(){
        Color backColor = Color.decode("#656565");
        Color fontColor = Color.decode("#FFFFFF");
        int c = GridBagConstraints.CENTER;
        int b = GridBagConstraints.BOTH;
        Insets ins = new Insets(0,0,0,0);

        int x=0;
        ArrayList<Character> characters = new ArrayList<>(
                Arrays.asList('/','1','2','3','*','4','5','6','-','7','8','9','+','0','.','='));

         /*ms.addComponent(this,
                ms.makeDesignButton(new JButton("+"), backColor, fontColor),
                        0, 3, 1, 1, c, b, ins);*/

        JPanel panel = new JPanel(new GridBagLayout());
        // Crear una matriz de botones
        JButton[][] buttons = new JButton[4][4];
        // Rellenar la matriz con botones y los agrega al panel

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col] = new JButton(""+ characters.get(x++) );
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = col;
                gbc.gridy = row;
                panel.add(buttons[row][col], gbc);
            }
        }

        this.add(panel);
    }

    /*public static void main(String[] args) {
        JPKeyboardBackup calc = new JPKeyboardBackup();
        calc.setVisible(true);;
    }*/

}

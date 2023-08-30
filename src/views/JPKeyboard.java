package views;

import utils.misc;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class JPKeyboard extends JPanel {

    private static final misc ms = misc.getInstance();
    private static JPKeyboard instance;

    public static JPKeyboard getInstance() {
        if (instance == null)
            instance = new JPKeyboard();
        return instance;
    }

    public JPKeyboard(){
        this.setLayout(new GridBagLayout());
        this.initComponents();//param: listener
    }

    public void initComponents(){
        Color backColor = Color.decode("#323435");
        Color fontColor = Color.decode("#ffffff");
        int c = GridBagConstraints.CENTER;
        int b = GridBagConstraints.BOTH;
        Insets ins = new Insets(4,4,4,4);

        ArrayList<Character> characters = new ArrayList<>(
                Arrays.asList('/','1','2','3','x','4','5','6','-','7','8','9','+','0','.','='));

        int r =0; //entero que se encarga de inicializar la variable para recorrer la lista de caracteres
        for (int y = 0; y < 4; y++) {
            for (int x= 0; x < 4; x++) {
                ms.addComponent(
                        this, ms.makeDesignButton(
                                new JButton(""+ characters.get(r)), fontColor, backColor,
                                (characters.get(r)).toString(),CalculatorListener.getInstance()),
                        x, y, 1, 1, c, b, ins);
                r++;
            }
        }
    }

}

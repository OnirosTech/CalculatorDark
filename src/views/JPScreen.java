package views;

import utils.misc;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class JPScreen extends JPanel {

    private static final misc ms = misc.getInstance();
    private JTextPane screenTextPane;
    private String screenText;
    private static JPScreen instance;

    public static JPScreen getInstance() {
        if (instance == null)
            instance = new JPScreen();
        return instance;
    }

    public JPScreen(){
        this.setLayout(new GridBagLayout());
        this.initComponents();//param: listener
    }

    public void initComponents() {
        Color backColor = Color.decode("#323435");
        Color fontColor = Color.decode("#ffffff");
        int c = GridBagConstraints.CENTER;
        int b = GridBagConstraints.BOTH;
        Insets ins = new Insets(4, 4, 8, 8);
        Insets ins1 = new Insets(4, 8, 8, 4);
        Font fontScreen = new Font("Arial", Font.BOLD, 40);

        this.screenText = "0";
        screenTextPane = new JTextPane();
        screenTextPane.setForeground(Color.decode("#044C63"));//Azul Oscuro
        screenTextPane.setBackground(null);
        screenTextPane.setFont(fontScreen);
        screenTextPane.setBorder(new MatteBorder(1,1,1,1, Color.decode("#1A73E8")));
        screenTextPane.setText(screenText);
        screenTextPane.setEditable(false);
        screenTextPane.setName("numberText");
        //screenTextPane.addMouseListener(TicketCreatedListener.getInstance());

        ms.addComponent(this, screenTextPane, 0,0,1,1,c,b,ins1,0,0,0.1,0);

        ms.addComponent(this, ms.makeDesignButton(new JButton("<"), fontColor, backColor, "<", CalculatorListener.getInstance()),
                1, 0, 1, 1, c, b, ins);

    }

    public void setTextScreen(String screenText) {
        this.screenText = screenText ;
        this.screenTextPane.setText(this.screenText);
        System.out.println(this.screenText);
    }

    public String getTextScreen(){
        return screenText;
    }

    public void cleanScreen(){
        this.setTextScreen("");
    }

}

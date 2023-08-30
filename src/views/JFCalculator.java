package views;

import models.Calculator;
import utils.misc;
import javax.swing.*;
import java.awt.*;

public class JFCalculator extends JFrame {

    private final Calculator calculator = Calculator.getInstance();
    private final JPKeyboard keyboard = JPKeyboard.getInstance();
    private final JPScreen screen = JPScreen.getInstance();
    private final misc ms = misc.getInstance();
    private static JFCalculator instance;
    private boolean first = false;

    public static JFCalculator getInstance() {
        if (instance == null)
            instance = new JFCalculator();
        return instance;
    }
    public JFCalculator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Basic Calculator by SASB / 201912254");
        this.setSize(460,575);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        JPanel calc = new JPanel(new GridBagLayout());
        calc.setBackground(Color.decode("#0A222E"));
        screen.setBackground(Color.decode("#0A222E"));
        keyboard.setBackground(Color.decode("#0A222E"));

        ms.addComponent(calc, screen,
                0,0,1,1,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0),
                0,0,1.0,0);
        ms.addComponent(calc, keyboard,
                0,1,1,1,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0),
                0,0,1.0,0);
        this.add(calc);
    }

    public void setInput(String input){
        //si empieza por punto, se convierte en decimal de precision 7
        if(input.equals(".") && screen.getTextScreen().equals("0"))
            screen.setTextScreen(screen.getTextScreen() + input);
        //si empieza por cero, se mantiene el cero
        else if(input.equals("0") && screen.getTextScreen().equals("0"))
            screen.setTextScreen("0");
        else {
            //si empieza por otro numero, el cero se elimina automaticamente
            if (screen.getTextScreen().equals("0") && !input.equals("0"))
                screen.setTextScreen("");
            //si el numero en pantalla ya tiene punto y es menor a 9 caracteres, el nuevo punto no entra
            if (screen.getTextScreen().length() < 15 && screen.getTextScreen().contains(".") && input.equals("."))//
                screen.setTextScreen(screen.getTextScreen() + "");
            //si el total de caracteres son numericos y menor a 8 y hay un punto en el numero en pantalla
            else if (screen.getTextScreen().length() < 13 && !screen.getTextScreen().contains("."))
                screen.setTextScreen(screen.getTextScreen() + input);
            //si el total de caracteres son numericos y menor a 8 y no hay un punto en el numero en pantalla
            else if (screen.getTextScreen().length() < 14 && screen.getTextScreen().contains("."))
                screen.setTextScreen(screen.getTextScreen() + input);
        }
    }

    public void setInputResult(String input){
            screen.setTextScreen(input);
    }

    public void setNumberOne(){
        calculator.setNumberOne(Double.parseDouble(screen.getTextScreen()));
    }

    public void setNumberOne(String lastResult){
        calculator.setNumberOne(Double.parseDouble(lastResult));
    }

    public void setNumberTwo(){
        calculator.setNumberTwo(Double.parseDouble(screen.getTextScreen()));
    }

    public void setOperator(String operator){
        calculator.setOperation(operator);
    }

    public void cleanScreen(){
        screen.cleanScreen();
    }

    public void calculateResult() {
        calculator.resultOperation();
    }

    public String getResult(){
        return calculator.getResult();
    }

    public void setFirst(boolean first){
        this.first = first;
    }

    public boolean getFirst(){
        return this.first;
    }

    public void deleteChar(){
        String currentText = screen.getTextScreen();
        if (!currentText.isEmpty()) {
            String newText = currentText.substring(0, currentText.length() - 1);
            screen.setTextScreen(newText);
        }
    }
}

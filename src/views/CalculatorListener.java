package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorListener implements ActionListener {

    private static CalculatorListener instance;
    private static JFCalculator main = JFCalculator.getInstance();

    public static CalculatorListener getInstance() {
        if (instance == null)
            instance = new CalculatorListener();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        switch (input) {
            case "1", "4", "2", "3", "5", "6", "7", "9", "8", "0", "."-> {//entrada numerica
                if(!main.getFirst()) {//si es el primer numero a operar
                    main.setInput(input);
                }else{//si es el siguiente numero a operar
                    main.setInput(input);
                }
            }
            case "/", "x", "-", "+", "=" -> {//guardando operador y operando
                if(main.getFirst()){
                    main.setNumberTwo();//se guarda el siguiente numero en n2
                    main.calculateResult();//se realiza el calculo de la operacion
                    String result = main.getResult();//se guarda el resultado de la operacion
                    main.cleanScreen();//esta limpieza de pantalla se realiza para poder continuar con algunos de los dos caminos
                    if(input.equals("=")) {//si las operaciones finalizan se muestra finalmente el resultado en pantalla
                        main.setInputResult(result);
                        main.setFirst(false);//se activa nuevamente el guardado en n1
                    }else{//si continuan la operaciones el resultado anterior se guarda en la n1 para operar con n2
                        main.setNumberOne(result);
                        main.setOperator(input);
                        main.cleanScreen();
                    }
                }else {
                    main.setNumberOne();//se guarda el primer numero en n1
                    main.setOperator(input);//se guarda el operador
                    main.setFirst(true);//se desactiva el guardado en n1
                    main.cleanScreen();
                }
            }
            case "<" -> main.deleteChar();//eliminando un caracter en pantalla
        }
    }
}

package models;

import utils.misc;

public class Calculator {

    private final misc m = misc.getInstance();

    private static Calculator instance;
    private double n1;
    private double n2;
    private String operator;
    private String result;

    public static Calculator getInstance() {
        if (instance == null)
            instance = new Calculator();
        return instance;
    }

    public String add(){
        return m.toCast(this.n1 + this.n2);
    }

    public String subtract(){
        return m.toCast(this.n1 - this.n2);
    }

    public String multiply(){
        return m.toCast(this.n1 * this.n2);
    }

    public String divide(){
        String res;
        if (this.n2 == 0)
            res = "ERROR";
        else
            res = m.toCast(this.n1 / this.n2);
        return res;
    }

    public void setNumberOne(double nx){
        this.n1=nx;
    }

    public void setNumberTwo(double nx){
        this.n2=nx;
    }

    public void setOperation(String operatorIn){
        System.out.println(operatorIn);
        this.operator=operatorIn;
    }

    public void resultOperation(){
        switch (this.operator){
            case "+" -> this.result = add();
            case "-" -> this.result = subtract();
            case "x" -> this.result = multiply();
            case "/" -> this.result = divide();
        }
    }

    public String getResult(){
        return this.result;
    }

}
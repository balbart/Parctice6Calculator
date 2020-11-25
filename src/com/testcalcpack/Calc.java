package com.testcalcpack;

enum Operations {divide, plus, minus, multiply, percent};

public class Calc {
    private double firstMember;
    private double secondMember;
    private boolean isFirstReady;
    private Operations operation;
    private boolean isPercentActive;
    Calc(){
        firstMember = 0;
        secondMember = 0;
        isFirstReady = false;
        isPercentActive = false;
    }

    void sentNum(int digit) {
        if (!isFirstReady) {
            firstMember = firstMember * 10 + digit;
        } else {
            secondMember = secondMember * 10 + digit;
        }
    }

    void setOperation(Operations operation) {
        if(operation == Operations.percent){isPercentActive = true;}
        else{
        this.operation = operation;
        this.isFirstReady = true;
        this.secondMember = 0;
        this.isPercentActive = false;
    }
    }

    void total(){
        double totalNum = 0;
        if(isPercentActive){
            secondMember = firstMember / 100 * secondMember;
            isPercentActive = false;
        }
        switch (this.operation) {
            case plus -> {
                totalNum = firstMember + secondMember;
            }
            case minus -> {
                totalNum = firstMember - secondMember;
            }
            case divide -> {
                totalNum = firstMember / secondMember;
            }
            case multiply -> {
                totalNum = firstMember * secondMember;
            }
            default -> {
                System.out.println("wrong input");
            }
        }
        operation = null;
        firstMember = totalNum;
        isFirstReady = false;
    }

    double getCurrentNum(){
        if (!isFirstReady) {
            return firstMember;
        } else {
            return secondMember;
        }
    }

    void eraseSmallestDigit(){
        if(!isFirstReady){
            firstMember = (double) ((int)firstMember / 10);
        }
        else{
            secondMember = (double) ((int)secondMember / 10);
        }
    }

    void clear(){
        isFirstReady = false;
        firstMember = 0;
        secondMember = 0;
    }
}

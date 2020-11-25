package com.testcalcpack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Smat extends JFrame{
    private JPanel Panel;
    private JButton zeroButton;
    private JButton plusButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton sixButton;
    private JButton threeButton;
    private JButton minusButton;
    private JButton divideButton;
    private JButton multiplyButton;
    private JButton percentButton;
    private JButton equalButton;
    private JTextArea textArea1;
    private JButton clearButton;
    private JButton backspaceButton;
    private Calc calc;
    JButton[] numButtonsArray = {
            zeroButton,
            oneButton,
            twoButton,
            threeButton,
            fourButton,
            fiveButton,
            sixButton,
            sevenButton,
            eightButton,
            nineButton
    };

    public Smat() throws HeadlessException{
        setTitle("Калькулятор - велосипед");
        setVisible(true);
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Panel);
        calc = new Calc();
        for(int i = 0; i < 10; i++){
            numButtonsArray[i].addActionListener(new NumberAction(i));
        }
        textArea1.setText(Double.toString(calc.getCurrentNum()));
        minusButton.addActionListener(new OperatorAction(Operations.minus));
        plusButton.addActionListener(new OperatorAction(Operations.plus));
        multiplyButton.addActionListener(new OperatorAction(Operations.multiply));
        divideButton.addActionListener(new OperatorAction(Operations.divide));
        equalButton.addActionListener(new EqualAction());
        percentButton.addActionListener(new OperatorAction(Operations.percent));
        clearButton.addActionListener(new ClearAction());
        backspaceButton.addActionListener(new EraseAction());
    }

    class NumberAction implements ActionListener{
        int number;

        NumberAction(int number) {
            this.number = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calc.sentNum(this.number);
            textArea1.setText(Double.toString(calc.getCurrentNum()));
        }
    }

    class OperatorAction implements ActionListener{
        Operations operation;

        public OperatorAction(Operations operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calc.setOperation(this.operation);
            textArea1.setText(Double.toString(calc.getCurrentNum()));
        }
    }

    class EqualAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calc.total();
            textArea1.setText(Double.toString(calc.getCurrentNum()));
        }
    }


    class ClearAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calc.clear();
            textArea1.setText(Double.toString(calc.getCurrentNum()));
        }
    }

    class EraseAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calc.eraseSmallestDigit();
            textArea1.setText(Double.toString(calc.getCurrentNum()));
        }
    }



}

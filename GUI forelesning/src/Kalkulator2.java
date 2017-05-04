import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

/**
 * Created by slafa on 20.04.2017.
 */
public class Kalkulator2 extends JFrame implements ActionListener

{
    public static void main(String[] args)

    {
        Kalkulator2 k1 = new Kalkulator2();
    }

    JPanel jPNumbers = new JPanel(new GridLayout(4,3));
    JPanel jPText = new JPanel(new GridLayout(1,0));
    JPanel jPOperators = new JPanel(new GridLayout(4,1));

    JButton numBut[] = new JButton[10];
    JTextField jT1 = new JTextField(10);

    JButton btnClear = new JButton("C");
    JButton btnEquals = new JButton("=");
    JButton btnPlus = new JButton("+");
    JButton btnMinus = new JButton("-");
    JButton btnMultiply = new JButton("*");
    JButton btnDivide = new JButton("/");

    String textField = "";
    String storedNr;
    String operator;

    int nr1;
    int nr2;



    public Kalkulator2(){

        jPNumbers.add(jT1);

        for (int i = 0; i < numBut.length; i++){
            numBut[i] = new JButton("" + i);
            jPNumbers.add(numBut[i]);
            numBut[i].addActionListener(this);
        }


        jPNumbers.add(btnClear);
        jPNumbers.add(btnEquals);

        jPOperators.add(btnPlus);
        jPOperators.add(btnMinus);
        jPOperators.add(btnMultiply);
        jPOperators.add(btnDivide);

        btnClear.addActionListener(this);
        btnEquals.addActionListener(this);
        btnPlus.addActionListener(this);
        btnMinus.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);

        jT1.setPreferredSize(new Dimension(50,50));
        jT1.setEditable(false);
        jPText.add(jT1);

        jPOperators.setPreferredSize(new Dimension(100,50));

        add(jPText, BorderLayout.NORTH);
        add(jPNumbers, BorderLayout.CENTER);
        add(jPOperators, BorderLayout.EAST);

        setTitle("Kalkulator");
        setSize(600, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        nr1 = Integer.parseInt(storedNr);
        nr2 = Integer.parseInt(textField);

        Object clicked = e.getSource();
        if (clicked == numBut[0]) {
            textField += 0;
            jT1.setText(textField);

        }
        else if (clicked == numBut[1]){
            textField += 1;
            jT1.setText(textField);

        }
        else if (clicked == numBut[2]){
            textField += 2;
            jT1.setText(textField );

        }
        else if (clicked == numBut[3]){
            textField += 3;
            jT1.setText(textField);

        }
        else if (clicked == numBut[4]){
            textField += 4;
            jT1.setText(textField);

        }
        else if (clicked == numBut[5]){
            textField += 5;
            jT1.setText(textField);

        }
        else if (clicked == numBut[6]){
            textField += 6;
            jT1.setText(textField);

        }
        else if (clicked == numBut[7]){
            textField += 7;
            jT1.setText(textField);

        }
        else if (clicked == numBut[8]){
            textField += 8;
            jT1.setText(textField);

        }
        else if (clicked == numBut[9]){
            textField += 9;
            jT1.setText(textField);

        }
        else if (clicked == btnPlus){
            operator = "+";
            if (storedNr != ""){

            }

        }
        else if (clicked == btnMinus){
            operator = "-";

        }
        else if (clicked == btnDivide){
            operator = "/";

        }
        else if (clicked == btnMultiply){
            operator = "*";
            if (storedNr != ""){

            }

        }
        else if (clicked == btnClear){
            System.out.println("Clear");
            jT1.setText("");
            storedNr = "";
            textField = "";
            operator ="";

        }
        else if (clicked == btnEquals){
            System.out.println(operator);
            switch (operator){
                case "+": jT1.setText("" + (nr1 + nr2));
                    break;

                case "-": jT1.setText("" + (nr1 - nr2));
                    break;

                case "/": jT1.setText("" + (nr1 / nr2));
                    break;

                case "*": jT1.setText("" + (nr1 * nr2));
                    break;

            }


        }


    }
}

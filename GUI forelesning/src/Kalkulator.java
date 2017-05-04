import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by slafa on 18.04.2017.
 */


public class Kalkulator extends JFrame implements ActionListener
{
    public static void main(String[] args)
    {
        Kalkulator k = new Kalkulator();
    }
    //JPanel mainPanel = new JPanel();
    JPanel inputPanel = new JPanel(new GridLayout(3,2));
    JPanel buttonPanel = new JPanel(new GridLayout(1,5));

    JLabel t1 = new JLabel("Tall 1");
    JLabel t2 = new JLabel("Tall 2");
    JLabel t3 = new JLabel("Resultat");

    JTextField ta1 = new JTextField();
    JTextField ta2 = new JTextField();
    JTextField ta3 = new JTextField();

    JButton add = new JButton("+");
    JButton subtract = new JButton("-");
    JButton multiply = new JButton("*");
    JButton divide = new JButton("/");
    JButton avslutt = new JButton("avslutt");



    public Kalkulator(){
        setTitle("Kalkulator");
        add(inputPanel, BorderLayout.NORTH);
        inputPanel.add(t1, BorderLayout.CENTER);
        inputPanel.add(ta1, BorderLayout.CENTER);
        inputPanel.add(t2, BorderLayout.CENTER);
        inputPanel.add(ta2, BorderLayout.CENTER);
        inputPanel.add(t3, BorderLayout.CENTER);
        inputPanel.add(ta3, BorderLayout.CENTER);

        //buttons
        add(buttonPanel, BorderLayout.WEST);
        buttonPanel.add(add);
        buttonPanel.add(subtract);
        buttonPanel.add(multiply);
        buttonPanel.add(divide);
        buttonPanel.add(avslutt);

        //actionlistener
        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        avslutt.addActionListener(this);


        setSize(380,150);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object  r = e.getSource();
        System.out.println(r);
        String clicked = e.getActionCommand();
        try
        {
            int n1 = Integer.parseInt(ta1.getText());
            int n2 = Integer.parseInt(ta2.getText());

        System.out.println(clicked);
        switch (clicked)
        {
            case "+":
                ta3.setText(""+(n1+n2));
                break;
            case "-":
                ta3.setText(""+(n1-n2));
                break;
            case "/":
                ta3.setText(""+(n1/n2));
                break;
            case "*":
                ta3.setText(""+(n1*n2));
                break;
            case "avslutt":
                System.exit(1);
                break;
        }
        }catch (Exception error){
            if(clicked.equals("avslutt"))
                System.exit(1);
            else
            System.out.println(error + " is not a valid input");
        }
    }
}

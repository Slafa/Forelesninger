package SSP;

import javax.swing.*;
import java.awt.*;

/**
 * Created by slafa on 29.04.2017.
 */



public class SspFrame extends JFrame
{

    public static void main(String[] args)
    {
        SspFrame s1 = new SspFrame();
    }

    public SspFrame(){

        JPanel jpBack = new JPanel();
        JPanel jpLeft = new JPanel(new GridLayout(2,1));
        JPanel jpmid = new JPanel();
        JPanel jpRight = new JPanel(new GridLayout(2,1));
        JPanel jpScore = new JPanel(new GridLayout(4,2));
        JPanel jpPlayerScore = new JPanel(new GridLayout(2,1));
        JPanel jpComScore = new JPanel(new GridLayout(2,1));

        JLabel jlPlayerScore = new JLabel("Spiller poeng");
        JLabel jlComScore = new JLabel("Com poeng");

        JTextField jtPlayerScore = new JTextField("0");
        JTextField jtComScore = new JTextField("0");
        JTextArea jtInfo = new JTextArea("grrrrr");

        add(jpBack);
        jpBack.add(jpLeft);
        jpBack.add(jpmid);
        jpBack.add(jpRight);

        //left side
        jpLeft.add(jpPlayerScore, BorderLayout.NORTH);
        jpPlayerScore.add(jlPlayerScore);
        jpPlayerScore.add(jtPlayerScore);


        jpRight.add(jlComScore);
        jpRight.add(jtComScore);
        jpmid.add(jtInfo, BorderLayout.CENTER);

        jpBack.add(jpScore, BorderLayout.NORTH);

        setTitle("Stein Saks Papir");
        setSize(600,400);

        jtInfo.setPreferredSize(new Dimension(250,200));

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }

}

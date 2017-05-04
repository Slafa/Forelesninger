import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by slafa on 18.04.2017.
 */
public class Memory extends JFrame implements ActionListener
{


    public static void main(String[] args)
    {
        Memory m1 = new Memory();
    }

    JPanel mainF = new JPanel(new GridLayout(5,6));

    int but1= -1;
    int but2= -1;
    int check1= -1;
    int check2= -1;
    HashMap hm = new HashMap();
    ArrayList<JButton> buttons = new ArrayList<>();
    ArrayList<Integer> numArr = new ArrayList<>();
    public Memory(){

        //add jButtons into an array
        for (int i = 0; i<30; i++){
            buttons.add(new JButton(""));
        }

        //add numbers into an array
        for (int i = 0; i<30; i++){
            numArr.add((i%15 + 1));
        }

        //shuffle the array
        Collections.shuffle(numArr);
        add(mainF, BorderLayout.CENTER);

        //add values into hashmap
        for (int i = 0; i < 30; i++){
            hm.put("Jb"+i,""+(buttons.get(i)));
        }

        //add buttons into JPannel
        System.out.println(buttons);
        for (int i =0; i< buttons.size(); i++){
            mainF.add(buttons.get(i));
        }

        //add actionlistener to all the buttons
        for (int i = 0; i < buttons.size(); i++){
            buttons.get(i).addActionListener(this);
        }

        setTitle("Memory");
        setSize(600, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void resetNum(){
        but1 = -1;
        but2 = -1;
        check1 = -1;
        check2 = -1;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
        Object clicked = e.getSource();
        if (check1!=-1 && check2!=-1 && but1 != -1 && but2 != -1){
            buttons.get(but1).setText("");
            buttons.get(but2).setText("");
            resetNum();
        }else if(check1!=-1 && check2!=-1) {
            resetNum();
         }

         //click 1
        for (int i = 0; i < buttons.size(); i++){
            if (clicked == buttons.get(i) && (but1 == -1) &&
                    buttons.get(i).getText().equals(""))
            {
                but1 = i;
                check1 = numArr.get(i);
                buttons.get(i).setText("" + numArr.get(i));
                break;
            //click 2

            }
            else if (clicked == buttons.get(i) && but2 == -1 &&
                    clicked != buttons.get(but1) && buttons.get(i).getText().equals(""))
            {
                buttons.get(i).setText("" + numArr.get(i));
                but2 = i;
                check2 = numArr.get(i);
                System.out.println("hest");
                if (check1 == check2)
                {
                    resetNum();
                }
            }
            }

        }
        catch (Exception error){
            System.out.println("you got an error: " + error);
        }
    }
}

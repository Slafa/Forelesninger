package guirep;



import javax.swing.*;
import java.awt.*;

/**
 * Created by slafa on 27.04.2017.
 */
public class fonttest extends JFrame
{
    int fontSize = 56;

    private static fonttest ourInstance = new fonttest();

    public static fonttest getInstance()
    {
        return ourInstance;
    }

    public fonttest()
    {

        Font f = new Font(Font.MONOSPACED, Font.BOLD, 56);

        JLabel label = new JLabel("testing", SwingConstants.CENTER);
        label.setFont(f);
        add(label, BorderLayout.CENTER);
        String[] choiceNames = new String[3];

        choiceNames[0] = "mitt første valg";
        choiceNames[1] = "mitt andre valg";
        choiceNames[2] = "mitt tredde valg";

        JComboBox<String> choices = new JComboBox<>(choiceNames);
        add(choices, BorderLayout.SOUTH);

        setVisible(true);
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Note extends JFrame
{


    public static void main(String[] args)
    {
        Note n1 = new Note();
    }


    private JTextArea txaTextArea;
    private JScrollPane scrollPane;
    JMenuBar menuBar;

    JMenu menu;
    JMenuItem save;
    JMenuItem load;
    JMenuItem exit;

    JMenu format;
    JMenuItem itmtextWrap;
    JMenuItem itmnoTextWrap;
    JMenu mnufontSize;
    JMenuItem[] fontArr;

    int fontSize = 16;
    Font f = new Font(Font.MONOSPACED, Font.BOLD, fontSize);



    public Note()
    {
        fontArr = new JMenuItem[6];
        setTitle("Huskelapp");
        txaTextArea = new JTextArea();
        txaTextArea.setFont(f);
        menuBar = new JMenuBar();

        menu = new JMenu("file");
        save = new JMenuItem("save");
        load = new JMenuItem("load");
        exit = new JMenuItem("exit");
        menu.setMnemonic('f');
        menu.setFont(menu.getFont().deriveFont(16f));

        format = new JMenu("Format");
        format.setMnemonic('o');
        format.setFont(format.getFont().deriveFont(16f));
        itmtextWrap = new JMenuItem("Text wrap");
        itmnoTextWrap = new JMenuItem("No Text wrap");
        mnufontSize = new JMenu("Font size");

        int fontSizeNumber = 16;
        for (int i = 0; i < fontArr.length; i++){

            fontArr[i] = new JMenuItem("" + fontSizeNumber);
            mnufontSize.add(fontArr[i]);
            int finalFontSizeNumber = fontSizeNumber;
            fontArr[i].addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    fontSize = finalFontSizeNumber;
                    //f = f.deriveFont((float)fontSize);
                    //txaTextArea.setFont(f);
                    txaTextArea.setFont(txaTextArea.getFont().deriveFont((float)fontSize));
                }
            });
            fontSizeNumber += 2;
        }


        setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(save);
        menu.add(load);
        menu.add(exit);

        menuBar.add(format);
        format.add(itmtextWrap);
        format.add(itmnoTextWrap);
        format.add(mnufontSize);

        txaTextArea.setLineWrap(true);
        txaTextArea.setWrapStyleWord(true);
        txaTextArea.setFont(f);

        scrollPane = new JScrollPane(txaTextArea);
        add(scrollPane, BorderLayout.CENTER);


        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        save.addActionListener(e-> {save();});

        load.addActionListener(e->{{load();}});

        exit.addActionListener(e->{System.exit(0);});


    }

    private void load()
    {
        txaTextArea.setText("");
        try
        {
            String filename = JOptionPane.showInputDialog(this, "file name");
            Scanner filein = new Scanner(new File(filename));
            while(filein.hasNext()){
                String data = filein.nextLine();
                txaTextArea.append(data + "\n");
            }
            filein.close();

        } catch(IOException ioex) {
            JOptionPane.showMessageDialog(this, "IO-feil: " + ioex.getMessage());
        }
    }

    private void save(){
        try
        {
            String filename = JOptionPane.showInputDialog(this, "file name");
            PrintWriter fileOut = new PrintWriter(new File(filename));
            fileOut.println(txaTextArea.getText());
            fileOut.close();
        }catch (IOException ioex){
            JOptionPane.showMessageDialog(this, "IO-feil: " + ioex.getMessage());

        }
    }
}




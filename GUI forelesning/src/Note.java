import javax.swing.*; // GUI
import java.awt.*; //Layout
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.*;


/**
 * Created by slafa on 28.03.2017.
 */
public class Note extends JFrame implements ActionListener
{
    JTextArea jT1 = new JTextArea();
    JFileChooser fileChooser;
    private Component modalToComponent;
    public File fc(){
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // user selects a file
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile;
        }
return null;
    }
    public Note()
    {
        setTitle("Huskelapp");

        add(jT1, BorderLayout.CENTER);
        jT1.setFont(jT1.getFont().deriveFont(35f));
        JPanel pnlsouth = new JPanel(new GridLayout(1, 3));


        JButton btnExit = new JButton("Avslutt");
        JButton btnSave = new JButton("Save");
        JButton btnLoad = new JButton("Load");

        add(pnlsouth, BorderLayout.SOUTH);
        pnlsouth.add(btnSave);
        pnlsouth.add(btnLoad);
        pnlsouth.add(btnExit);

        btnExit.addActionListener(this);
        btnSave.addActionListener(this);
        btnLoad.addActionListener(this);

        setSize(800, 600);
        pnlsouth.setPreferredSize(new Dimension(100,50));

        btnExit.setFont(btnExit.getFont().deriveFont(25f));
        btnLoad.setFont(btnLoad.getFont().deriveFont(25f));
        btnSave.setFont(btnSave.getFont().deriveFont(25f));

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close app when window is closed

    }

    public void actionPerformed(ActionEvent event)
    {
        String text = event.getActionCommand();

        switch (text)
        {
            case "Avslutt":
                ImageIcon door = new ImageIcon(new ImageIcon("C:\\Users\\slafa\\Dropbox\\skole\\programmering\\PGR101-1 17V Objektorientert programmering 2\\Forelesninger\\GUI forelesning\\door_exit.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                int choice = JOptionPane.showConfirmDialog(null,"are you sure you want to exit?","exit",0,1,door);

                if (choice == YES_OPTION){
                    System.out.println("Avslutter...");
                    System.exit(0);
                    break;
                }
                else{
                    break;
                }

            case "Save":
                String FileSaveName ="";
                fc();
                /*try{

                    if (fileChooser.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        // load from file
                    }
                    String fileName = showInputDialog(this, "Filnavn");
                    PrintWriter fileOut = new PrintWriter(new File(fileName +".txt"));
                    FileSaveName = fileName + ".txt";
                    fileOut.println(jT1.getText());
                    fileOut.close();
                    JOptionPane.showMessageDialog(null,"Saved file as: "+ FileSaveName);

                }catch (IOException ioex){
                    JOptionPane.showMessageDialog(Note.this, "IO-feil: " + ioex.getMessage());
                }
                */

                break;

            case "Load":

                try{
                    //String fileName = showInputDialog(this, "filnavn");
                    Scanner fileIn = new Scanner(fc());
                    while (fileIn.hasNext()){
                        String data = fileIn.nextLine();
                        jT1.append(data + "\n");
                    }
                    fileIn.close();
                }catch(IOException ioex){
                    JOptionPane.showMessageDialog(Note.this, "IO-feil: " + ioex.getMessage());
                }
                System.out.println("Loading file");
                break;

            default:
                System.out.println("Something went wrong");
                break;
        }

    }


}

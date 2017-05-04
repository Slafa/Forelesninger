import static javax.swing.JOptionPane.*;
//import javax.swing.JOptionPane;
import java.util.Scanner;

public class JOptionPaneDialogExample {
    public void mainMethod() {
        Scanner in = new Scanner(System.in);
        showMessageDialog(
            null, "Du må endre passord!");
            
        String name2 = in.nextLine();
        String name = showInputDialog(null,
                "Oppgi brukernavn");
        showMessageDialog(null, "Du er registrert " + name);

        int choice = showConfirmDialog(
                null, "Erase your hard disk?");
        if (choice == YES_OPTION) {
            showMessageDialog(null, "Disk erased!");
        } else
        if (choice == NO_OPTION) {
            showMessageDialog(null, "Disk not erased!");
        } else {
            showMessageDialog(null, "Cancelled!");
        }
        
    }
}

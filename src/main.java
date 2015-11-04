import javax.swing.*;

/**
 * JAVA FINAL PROJECT
 * CIS-175-01 Java II
 *
 * Created by: Chad, Jake, Josie, David
 */

/**
 * Program: Test
 */

public class main
{
    private JLabel leMessage;
    private JPanel panel;

    public main()
    {
        final int Window_H = 100;
        final int Window_W = 350;

        //Create a test window.
        JFrame window = new JFrame();

        //Title
        window.setTitle("Hello World!");

        //Set the size of the window, Width/Height
        window.setSize(Window_W,Window_H);

        //Center program on screen. OSX/Windows confirmed.
        window.setLocationRelativeTo(null);

        //What happens when CLOSE is clicked.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Build and add panel().
        panel();
        window.add(panel);

        //Display window.
        window.setVisible(true);
    }

    private void panel(){

        //JLabel message.
        leMessage = new JLabel("WOW, SUCH JAVA");

        //Create new JPanel.
        panel = new JPanel();

        //Add leMessage to panel
        panel.add(leMessage);

    }

    //Main
    public static void main(String[] args){
        new main();
    }
}

import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 * JAVA FINAL PROJECT
 * CIS-175-01 Java II
 *
 * Created by: Chad, Jake, Josie, David
 */

/**
 * Note 11/16; Added basic layout for the game, using Absolute layout though Oracle.
 *
 *
 */

public class main extends  JFrame
{
    private JPanel panel;

    private JButton btnOne;
    private JButton btnTwo;
    private JTextArea StoryOutput;
    private JTextField StoryInput;
    private JSlider HitCrit;
    private JList Inventory;
    private JLabel Health;
    private JLabel Armor;

    public main()
    {
        final int Window_H = 768;
        final int Window_W = 1024;

        //Create a test window.

        //Title
        setTitle("--Game Title--");

        //Set the size of the window, Width/Height
        setSize(Window_W,Window_H);

        //Center program on screen. OSX/Windows confirmed.
        setLocationRelativeTo(null);

        //What happens when CLOSE is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Disable Maximize button.
        setResizable(false);

        //Construct a new JPanel.
        panel = new JPanel();

        //PoC inventory...
        //Is there an Inventory class?
        String[] InvList = {"Sword", "Shield", "Mace"};

        //Construct GUI components.
        StoryInput = new JTextField (5);
        StoryOutput = new JTextArea (5, 5);
        HitCrit = new JSlider (0, 50);
        Inventory = new JList (InvList);
        Health = new JLabel ("Health: ##%");
        Armor = new JLabel ("Armor ##%");
        btnOne = new JButton ("Null");
        btnTwo = new JButton ("Null");

        //Setting component properties for Hit/Critical slider.
        HitCrit.setOrientation (JSlider.HORIZONTAL);
        HitCrit.setMinorTickSpacing (1);
        HitCrit.setMajorTickSpacing (5);
        HitCrit.setPaintTicks (true);
        HitCrit.setPaintLabels (false);

        //Set StoryOutput to Not Editable
        StoryOutput.setEditable(false);

        //Story line Example.
        StoryOutput.setText("The quick brown fox jumps over the lazy dog.");

        //Positioning of objects on panel. (Positioning is Rough guess as of 11/16)
        //                      (xLeftRight, yUpdown, width, Height)
        StoryOutput.setBounds    (10, 450, 995, 115);
        StoryInput.setBounds   (10, 580, 995, 25);
        Inventory.setBounds     (900, 650, 100, 75);
        HitCrit.setBounds       (450, 680, 400, 50);
        btnOne.setBounds        (10, 700, 100, 25);
        btnTwo.setBounds        (120, 700, 100, 25);
        Health.setBounds        (250, 700, 100, 25);
        Armor.setBounds         (350, 700, 100, 25);

        //Add components to panel.
        add(btnOne);
        add(btnTwo);
        add(StoryOutput);
        add(StoryInput);
        add(HitCrit);
        add(Inventory);
        add(Health);
        add(Armor);

        /**
         * add(panel) and setVisible(true) need to stay below this.
         */

        //add panel.
        add(panel);
        //Display window.
        setVisible(true);

    }

    //Start
    public static void main(String[] args){
        main frame = new main();
    }


}

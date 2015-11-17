import javax.swing.*;


/**
 * JAVA FINAL PROJECT
 * CIS-175-01 Java II
 *
 * Created by: Chad, Jake, Josie, David
 */

/**Notes from Jake;
 * Note 11/16; Added basic layout for the game, using Absolute layout though Oracle.
 * Note 11/16; Fixed comments. Removed unnecessary packages.
 *
 */

public class main extends JFrame
{
    public JPanel panel;
    public JButton btnOne;
    public JButton btnTwo;
    public JTextArea StoryOutput;
    public JTextField StoryInput;
    public JSlider HitCrit;
    public JList Inventory;
    public JLabel Health;
    public JLabel Armor;

    public main()
    {

        //Final window size.
        final int Window_H = 768;
        final int Window_W = 1024;

        //Create a test window.

        //TODO: Game Title
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

        //TODO: Create a Inventory Class.
        String[] InvList = {"Sword", "Shield", "Mace"};

        //TODO: Link GUI components to classes.
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
        //TODO: Create Story Line class/strings.
        StoryOutput.setText("The quick brown fox jumps over the lazy dog.");

        //Positioning of objects on panel. This will give us more control on everything UI based.
        //----------------------(xLeftRight, yUpdown, width, Height)
        //TODO: Finalize setBounds.
        StoryOutput.setBounds   (10, 450, 995, 115);
        StoryInput.setBounds    (10, 580, 995, 25);
        Inventory.setBounds     (900, 650, 100, 75);
        HitCrit.setBounds       (450, 680, 400, 50);
        btnOne.setBounds        (10, 700, 100, 25);
        btnTwo.setBounds        (120, 700, 100, 25);
        Health.setBounds        (250, 700, 100, 25);
        Armor.setBounds         (350, 700, 100, 25);

        //TODO: Create area for gameplay images.
        /**
         *
         *
         *
         */

        //Add components to panel.
        add(btnOne);
        add(btnTwo);
        add(StoryOutput);
        add(StoryInput);
        add(HitCrit);
        add(Inventory);
        add(Health);
        add(Armor);

        //add(panel) and setVisible(true) need to stay below this.
        add(panel);
        setVisible(true);
    }

    //Start
    public static void main(String[] args){
        main frame = new main();
    }

}
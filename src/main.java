import javax.swing.*;

/**
 * JAVA FINAL PROJECT
 * CIS-175-01 Java II
 *
 * Created by: Chad, Jake
 */

public class main
{
    public JPanel panel;
    public JButton btnOne;
    public JButton btnTwo;
    public JTextArea StoryOutput;
    public JTextField StoryInput;
    public JLabel Health;
    public JLabel Armor;
    public int health, armor;

    public main()
    {

        JFrame frame = new JFrame();
        final String GameTitle = "Super Spook 9000";

        //Start the game.
        Level01 L01 = new Level01();

        //Get Player Controller(SO WE CAN MOVE!!! b0ss!!)
        PlayerController PC = L01.GetPC();

        //Set up default health/armor
        PlayerPawn a = L01.GetPlayer();
        health = a.GetHealth();
        armor = a.GetArmor();

        //Final window size.
        final int Window_H = 280;
        final int Window_W = 600;

        //Title
        frame.setTitle(GameTitle);

        //Set the size of the window, Width/Height
        frame.setSize(Window_W,Window_H);

        //Center program on screen. OSX/Windows.
        frame.setLocationRelativeTo(null);

        //What happens when CLOSE is clicked.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Disable Maximize button.
        frame.setResizable(false);

        //Construct a new JPanel.
        panel = new JPanel();

        //Construct GUI components.
        StoryInput = new JTextField (5);
        StoryOutput = new JTextArea (5, 5);
        Health = new JLabel ("Health: " + health + "%");
        Armor = new JLabel ("Armor: " + armor + "%");
        btnOne = new JButton ("Use Sword");
        btnTwo = new JButton ("Use Mace");

        //Set StoryOutput to Not Editable
        StoryOutput.setEditable(false);

        //Story line Example.
        StoryOutput.setText("Welcome to " + GameTitle + "!");

        //Positioning of objects on panel. This will give us more control on everything UI based.
        //----------------------(xLeftRight, yUpdown, width, Height)
        StoryOutput.setBounds   (10, 20, 570, 115);
        StoryInput.setBounds    (10, 150, 570, 25);
        btnOne.setBounds        (10, 200, 100, 25);
        btnTwo.setBounds        (120, 200, 100, 25);
        Health.setBounds        (250, 200, 100, 25);
        Armor.setBounds         (350, 200, 100, 25);


        //Add components to panel.
        frame.add(btnOne);
        frame.add(btnTwo);
        frame.add(StoryOutput);
        frame.add(StoryInput);
        frame.add(Health);
        frame.add(Armor);

        //add(panel) and setVisible(true) need to stay below this.
        frame.add(panel);
        frame.setVisible(true);



    }

    //Start
    public static void main(String[] args){
        new main();

    }
}
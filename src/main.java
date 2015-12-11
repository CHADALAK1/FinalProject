import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JAVA FINAL PROJECT
 * CIS-175-01 Java II
 *
 * Created by: Chad, Jake
 */

public class main
{
    public JPanel panel;
    public JTextArea StoryOutput, LevelGrid;
    public JButton useSword, useMace,goNorth, goSouth, goEast, goWest;
    public JLabel Health, Armor;
    public int health, armor;

    //Start the game.
    Level01 L01 = new Level01();

    //Get Player Controller(SO WE CAN MOVE!!! b0ss!!)
    PlayerController PC = L01.GetPC();

    //Set up default health/armor
    PlayerPawn a = L01.GetPlayer();

    public main()
    {

        JFrame frame = new JFrame();
        final String GameTitle = "Super Spook 9000";

        //Final window size.
        final int Window_H = 280;
        final int Window_W = 600;

        //Get health information to display on window.
        health = a.GetHealth();
        armor = a.GetArmor();

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
        StoryOutput = new JTextArea (5, 5);
        LevelGrid = new JTextArea(50,50);
        Health = new JLabel ("Health: " + health + "%");
        Armor = new JLabel ("Armor: " + armor + "%");
        useSword = new JButton ("Use Sword");
        useMace = new JButton ("Use Mace");
        goNorth = new JButton ("Go North");
        goSouth = new JButton ("Go South");
        goEast = new JButton ("Go East");
        goWest = new JButton ("Go West");

        //Set StoryOutput to Not Editable
        StoryOutput.setEditable(false);

        //Positioning of objects on panel. This will give us more control on everything UI based.
        //----------------------(xLeft/Right, yUp/down, width, Height)
        StoryOutput.setBounds   (10, 20, 450, 115);
        LevelGrid.setBounds     (470, 20, 115, 115);
        goNorth.setBounds       (10, 150, 100, 25);
        goSouth.setBounds       (120, 150, 100, 25);
        goEast.setBounds        (240, 150, 100, 25);
        goWest.setBounds        (360, 150, 100, 25);
        useSword.setBounds      (10, 200, 100, 25);
        useMace.setBounds       (120, 200, 100, 25);
        Health.setBounds        (250, 200, 100, 25);
        Armor.setBounds         (350, 200, 100, 25);


        //Add components to panel.
        frame.add(useSword);
        frame.add(useMace);
        frame.add(goNorth);
        frame.add(goSouth);
        frame.add(goEast);
        frame.add(goWest);
        frame.add(StoryOutput);
        frame.add(LevelGrid);
        frame.add(Health);
        frame.add(Armor);

        //add(panel) and setVisible(true) need to stay below this.
        frame.add(panel);
        frame.setVisible(true);


        //TODO: Get health and armor
        //TODO: Interation in PlayerPawn
        //TODO: Feedback for monster.

        //TODO: This fails to work, it doesn't loop.
        int die = 0;
        do {
            //useSword.addActionListener(new swordActionListener());
            //useMace.addActionListener(new maceActionListener());
            goNorth.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    PC.moveNorth();
                    StoryOutput.append("Player went NORTH one step. \n");
                }
            });
            goSouth.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    PC.moveSouth();
                    StoryOutput.append("Player went SOUTH one step. \n");
                }
            });
            goEast.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    PC.moveEast();
                    StoryOutput.append("Player went EAST one step. \n");
                }
            });
            goWest.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    PC.moveWest();
                    StoryOutput.append("Player went WEST one step. \n");
                }
            });

            die++;
            System.out.println(die);
        }
        while (die == 5);

        if (die == 5)
        {
            System.exit(0);
        }


    }

    //Start
    public static void main(String[] args){new main();}
}
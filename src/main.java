import javax.swing.*;
import java.awt.*;
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
        StoryOutput = new JTextArea (2000, 39);
        Font font = new Font("Arial", Font.ITALIC, 8);
        JScrollPane sp = new JScrollPane(StoryOutput);
        LevelGrid = new JTextArea(50,50);
        LevelGrid.setFont(font);
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
        sp.setBounds            (10, 20, 450, 115);
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
        frame.add(sp);
        frame.add(LevelGrid);
        frame.add(Health);
        frame.add(Armor);

        //add(panel) and setVisible(true) need to stay below this.
        frame.add(panel);
        frame.setVisible(true);


        ActionClass actionEvent = new ActionClass();

            useSword.addActionListener(actionEvent);
            useSword.setActionCommand("4");

            useMace.addActionListener(actionEvent);
            useMace.setActionCommand("5");

            goNorth.addActionListener(actionEvent);
            goNorth.setActionCommand("0");

            goSouth.addActionListener(actionEvent);
            goSouth.setActionCommand("1");

            goEast.addActionListener(actionEvent);
            goEast.setActionCommand("2");

            goWest.addActionListener(actionEvent);
            goWest.setActionCommand("3");

    }

    //This class will perform the direction of player. Then goto carry on to continue game.
    class ActionClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int action = Integer.parseInt(e.getActionCommand());

            switch (action) {
                case 0:
                    PC.moveNorth();
                    StoryOutput.append("Player went NORTH one step. \n");
                    carryOn("North");
                    break;
                case 1:
                    PC.moveSouth();
                    StoryOutput.append("Player went SOUTH one step. \n");
                    carryOn("South");
                    break;
                case 2:
                    PC.moveEast();
                    StoryOutput.append("Player went EAST one step. \n");
                    carryOn("East");
                    break;
                case 3:
                    PC.moveWest();
                    StoryOutput.append("Player went WEST one step. \n");
                    carryOn("West");
                    break;
                case 4:
                    StoryOutput.append("Player swung Sword! \n");
                    carryOn("Sword");
                    break;
                case 5:
                    StoryOutput.append("Player swung Mace! \n");
                    carryOn("Mace");
                    break;
            }
        }
    }

    public String carryOn (String action)
    {
        //Refresh Health and Armor with each iteration.
        a.GetHealth();
        a.GetArmor();

        //Call SetVisualGrid to refresh, clear LevelGrid, then apply updated information for a 'map'.
        L01.SetVisualGrid();
        LevelGrid.setText("");

        //TODO: Does not display X (walls) and does not refresh player location.
        char[][] VisualGrid = L01.GetVisualGrid();

        for(int x = 0; x < VisualGrid.length; x++)
        {
            for(int y = 0; y < VisualGrid[x].length; y++)
            {
                LevelGrid.append(Character.toString(VisualGrid[x][y]));
                //System.out.print(VisualGrid[x][y]);
            }
            //System.out.print("\n");
            LevelGrid.append("\n");
        }

        //Turn action into a command, complete necessary game code. IE: wall, item, fight.
        //TODO: Battle. Random 'crits' upon CPU and PLAYER weapons. (damage+crit%).
        //TODO: Feedback for monster.
        /** pseudo code
         *
         *          if ( battle triggered )         <Dont forget CriticalHitChance/buff  for 'hit' action.
         *          {
         *              do
         *               {
         *                  if (player is first from Turn() )
         *                      {
         *                          wait for action
         *                          append StoryOutput with action
         *                          'hit' monster with sword or mace.
         *                          change Turn()
         *                      }
         *                   if (monster is first from Turn() )
         *                      {
         *                          do action
         *                          append StoryOutput with action
         *                          'hit' player
         *                          change Turn()
         *                      }
         *               }
         *
         *               while (battle ended or a.IsDead())
         *
         *               if (battle ended)
         *                  {
         *                      Give player bonus
         *                      Display win on Story output
         *                  }
         *
         */


        //Result if player pressed on Use <weapon> instead of moving.
        if (action.equals("Sword") || action.equals("Mace"))
        {
            PC.GetControlledPawn().InteractBattle();

            //Debug
            System.out.println("Used "  + action);
        }

        //Interact will pickup any items (armor or health).
        PC.GetControlledPawn().Interact();



        //TODO: (Win ending?).. Count NPC to 0.


        //Keep towards the end to check for player's death.
        if (a.IsDead())
        {
            StoryOutput.append("Game Over!");
            try
            {
                Thread.sleep(5000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            System.exit(0);
        }

        return null;
    }




    //Start
    public static void main(String[] args){new main();}
}
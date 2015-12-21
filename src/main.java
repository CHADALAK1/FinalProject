import javax.swing.*;
import javax.swing.text.DefaultCaret;
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
    public boolean inbattle = true;

    //Start the game.
    Level01 L01 = new Level01();

    //Get Player Controller in order to move.
    PlayerController PC = L01.GetPC();

    //Set up default health/armor
    PlayerPawn a = L01.GetPlayer();

    public main()
    {

        JFrame frame = new JFrame();
        final String GameTitle = "Super Spook 9000, a CIS-175 Java II final project. By: Chad and Jake";

        //Final window size.
        final int Window_H = 280;
        final int Window_W = 700;

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
        DefaultCaret autoScroll = (DefaultCaret)StoryOutput.getCaret();
        autoScroll.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
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
        LevelGrid.setBounds     (470, 20, 200, 210);
        goNorth.setBounds       (10, 150, 100, 25);
        goSouth.setBounds       (120, 150, 100, 25);
        goEast.setBounds        (240, 150, 100, 25);
        goWest.setBounds        (360, 150, 100, 25);
        useSword.setBounds      (10, 200, 100, 25);
        useMace.setBounds       (120, 200, 100, 25);
        Health.setBounds        (250, 200, 100, 25);
        Armor.setBounds         (350, 200, 100, 25);

        //Tutorial.
        StoryOutput.setText("Press a button to start.... \n");

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

        //Call carryOn to update the map automatically.
        carryOn("");

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
        health = a.GetHealth();
        Health.setText("Health: " + health + "%");
        armor = a.GetArmor();
        Armor.setText("Armor: " + armor + "%");

        //Call SetVisualGrid to refresh, clear LevelGrid, then apply updated information for a 'map'.
        L01.SetVisualGrid();
        LevelGrid.setText("");

        String[][] VisualGrid = L01.GetVisualGrid();

        for(int x = 0; x < VisualGrid.length; x++)
        {
            for(int y = 0; y < VisualGrid[x].length; y++)
            {
                LevelGrid.append ((VisualGrid[y][x]) + "");
            }
            LevelGrid.append("\n");
        }

        //Result if player pressed on Use <weapon> instead of moving.
        if (action.equals("Sword") || action.equals("Mace"))
        {
            if(action.equals("Sword"))
                PC.GetControlledPawn().InteractBattle(0);

            if(action.equals("Mace"))
                PC.GetControlledPawn().InteractBattle(1);

            //Debug
            System.out.println("Used "  + action);
        }

        //Interact will pickup any items (armor or health).
        PC.GetControlledPawn().Interact();

        //If/When a battle is in place. User cannot move.
        //BATTLE TO THE DEATH
        if(L01.GetReferee() != null)
        {

            //Disable movement within battle.
            goNorth.setEnabled(false);
            goSouth.setEnabled(false);
            goEast.setEnabled(false);
            goWest.setEnabled(false);

            //Stand your ground after discovering a monster.
            if(inbattle)
            {
                StoryOutput.append("AHHH, A MONSTER!\n");
                StoryOutput.append("I must fight to the death!\n");
                inbattle = false;
            }

            //Referee Announcer
            StoryOutput.append(L01.GetReferee().GetAnnouncement());

            if(L01.GetReferee().GetMonster().GetWeapon().get(0).GetHasMissed())
            {
                StoryOutput.append("Monster has missed!\n");
            }

            if(L01.GetReferee().GetMonster().GetWeapon().get(0).GetHasCritted())
            {
                StoryOutput.append("Monster has Critted you!\n");
            }

            if(action.equals("Sword"))
            {
                if (L01.GetReferee().GetPlayer().GetWeapon().get(0).GetHasMissed())
                {
                    StoryOutput.append("Player has missed!\n");
                }

                if(L01.GetReferee().GetPlayer().GetWeapon().get(0).GetHasCritted())
                {
                    StoryOutput.append("You SUPER hit the monster!\n");
                }
            }

            if(action.equals("Mace"))
            {
                if (L01.GetReferee().GetPlayer().GetWeapon().get(1).GetHasMissed())
                {
                    StoryOutput.append("Player has missed!\n");
                }

                if(L01.GetReferee().GetPlayer().GetWeapon().get(1).GetHasCritted())
                {
                    StoryOutput.append("You SUPER hit the monster!\n");
                }
            }


        }
        else
        {
            //End battle settings.
            inbattle = true;
            goNorth.setEnabled(true);
            goSouth.setEnabled(true);
            goEast.setEnabled(true);
            goWest.setEnabled(true);
        }

        //Checker to disable X button in collision of a wall in the direction of ROTATE.
        if(a.GetCurrentLevel().GetLevel()[a.GetForwardVector().GetX()][a.GetForwardVector().GetY()] instanceof Wall && a.GetCurrentLevel().GetLevel()[a.GetForwardVector().GetX()][a.GetForwardVector().GetY()].GetHasCollision())
        {
            if(a.GetRotation() == Rotator.NORTH)
                goNorth.setEnabled(false);
            if(a.GetRotation() == Rotator.SOUTH)
                goSouth.setEnabled(false);
            if(a.GetRotation() == Rotator.EAST)
                goEast.setEnabled(false);
            if(a.GetRotation() == Rotator.WEST)
                goWest.setEnabled(false);

        }



        //Winner if Player defeats boss.
        if(L01.GetBossP() == null)
        {
            StoryOutput.append("You win! \n");
            StoryOutput.append("Congratulations!!!!!!!!!!!! \n");

            endGame();
        }


        //Int and (2) if will check how the game will end.
        //Either Win or Lose.
        int NPC_count = 0;

        for(int x = 0; x < L01.GetMonsters().size(); x++)
        {
            NPC_count++;
        }

        //Debug
        //System.out.print(NPC_count);

        if (NPC_count == 0)
        {
            StoryOutput.append("You win! \n");
            StoryOutput.append("Congratulations!!!!!!!!!!!! \n");

            endGame();
        }


        //Keep towards the end to check for player's death.
        if (a.IsDead())
        {
            StoryOutput.append("You died! Game Over... \n");
            StoryOutput.append("Restart the game to play again. \n");

            endGame();
        }

        if(L01.GetReferee() != null)
        {
            L01.GetReferee().SetAnnouncement("");
        }


        //DERP
        return null;

    }

    public void endGame()
    {
        useSword.setEnabled(false);
        useMace.setEnabled(false);
        goNorth.setEnabled(false);
        goSouth.setEnabled(false);
        goEast.setEnabled(false);
        goWest.setEnabled(false);
    }



    //Start
    public static void main(String[] args){new main();}
}
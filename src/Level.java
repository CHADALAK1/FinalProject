import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Chad Reddick on 11/19/15.
 * <p>
 *     Level Class is an Object that holds the 2DArray points so the Pawn
 *     can move into the Array slots throughout the 2DArray.
 * </p>
 */
public class Level
{
    /**
     *<b>Hallway</b>
     * <p>private</p>
     * A 2D Arrays that any Entity can be in for the hallway. Must be Initialized
     */
    private Entity[][] Grid;

    /**
     * <b>VisualGrid</b>
     * <p>private</p>
     * A 2D Array of chars that visually show text what the world look like
     */
    private String[][] VisualGrid;

    /**
     * <b>Player</b>
     * <p>private</p>
     * PlayerPawn object to spawn player into the level
     */
    private PlayerPawn Player;

    /**
     * <b>PC</b>
     * <p>private</p>
     * PlayerController object to control the Player Pawn
     */
    private PlayerController PC;

    /**
     * <b>Referee</b>
     * <p>private</p>
     * BattleReferee Object to have level spawn and set battles in charge of this object
     */
    private BattleReferee Referee;

    /**
     * <b>Monsters</b>
     * <p>private</p>
     * MonsterPawn ArrayList that holds the amount of monsters in the
     * level to spawn
     */
    private ArrayList<MonsterPawn> Monsters = new ArrayList<MonsterPawn>();

    /**
     * <b>BossP</b>
     * <p>private</p>
     * Boss object that's in the level to defeat the game
     */
    private BossPawn BossP;

    /**
     * <b>MonsterControllers</b>
     * <p>private</p>
     * MonsterController ArrayList that holds the Controllers for the Monsters.
     * Reasoning for this is to know what NPC controls MonsterPawn in the world
     */
    private ArrayList<MonsterController> MonsterControllers = new ArrayList<MonsterController>();

    /**
     * <b>MaxBoundaries</b>
     * <p>private</p>
     * Holds the Vector2D value of the x and y max boundaries of the level
     * initializes at <b>SetGridSize</b> Method
     */
    private Vector2D MaxBoundaries;

    /**
     * <b>StoryString</b>
     * <p>private</p>
     * String object that holds the current event in the story Scroll Window
     * @see main
     */
    private String StoryString;

    /**
     * <b>GetGrid</b>
     * returns the level Grid 2DArray
     * @return Grid
     */
    public Entity[][] GetLevel()
    {
        return Grid;
    }

    /**
     * <b>SetHallwaySize</b>
     * Sets the size of the Hallway 2D Array
     * @param Size Vector2D coordinates Size of the room
     */
    public void SetGridSize(Vector2D Size)
    {
        Grid = new Entity[Size.GetX()][Size.GetY()];
        //Where MaxBoundaries is initialized
        MaxBoundaries = new Vector2D(Size.GetX(), Size.GetY());
        SetMaxBoundaries();
    }

    /**
     * <b>SetMaxBoundaries</b>
     * Sets the MaxBoundaries Vectors into Wall objects
     * <p><b>MUST HAVE SetGridSize INITIALIZED BEFORE CALLING</b></p>
     */
    public void SetMaxBoundaries()
    {
        if(GetMaxBoundaries() != null)
        {
            for(int i = 0; i < GetMaxBoundaries().GetX(); i++)
            {
                GetLevel()[i][0] = new Wall();
            }
            for(int i = 0; i < GetMaxBoundaries().GetY(); i++)
            {
                GetLevel()[0][i] = new Wall();
            }
            for(int i = 0; i < GetMaxBoundaries().GetX(); i++)
            {
                GetLevel()[i][GetMaxBoundaries().GetY() - 1] = new Wall();
            }
            for(int i = 0; i < GetMaxBoundaries().GetY(); i++)
            {
                GetLevel()[GetMaxBoundaries().GetX() - 1][i] = new Wall();
            }
        }
    }

    /**
     * <b>GetVisualGrid</b>
     * Gets the VisualGrid
     * @return VisualGrid
     */
    public String[][] GetVisualGrid()
    {
        return VisualGrid;
    }

    /**
     * <b>SetVisualGrid</b>
     * Initializes the VisualGrid chars <b>AFTER</b> the level and objects have
     * been initialized.
     */
    public void SetVisualGrid()
    {
        VisualGrid = new String[GetMaxBoundaries().GetX()][GetMaxBoundaries().GetY()];
        for(int i = 0; i<Grid.length; i++)
        {
            for(int j = 0; j < Grid[i].length; j++)
            {
                if(GetLevel()[i][j] instanceof Door)
                {
                    GetVisualGrid()[i][j] = "D  ";
                }
                else if (GetLevel() [i] [j] instanceof  BossPawn)
                {
                    GetVisualGrid()[i][j] = "B  ";
                }
                else if(GetLevel()[i][j] instanceof MonsterPawn)
                {
                    GetVisualGrid()[i][j] = "M  ";
                }
                else if(GetLevel()[i][j] instanceof PlayerPawn)
                {
                    GetVisualGrid()[i][j] = "P  ";
                }
                else if (GetLevel() [i] [j] instanceof Potion)
                {
                    GetVisualGrid()[i][j] = "H  ";
                }
                else if (GetLevel() [i] [j] instanceof Armor)
                {
                    GetVisualGrid()[i][j] = "A  ";
                }
                else if (GetLevel() [i] [j] instanceof Key)
                {
                    GetVisualGrid() [i] [j] = "K  ";
                }
                else if (GetLevel()[i][j] instanceof Wall)
                {
                    GetVisualGrid()[i][j] = "▓  ";
                }
                else
                {
                    GetVisualGrid()[i][j] = "— ";
                }
            }
        }
    }

    /**
     * GetMaxBoundaries
     * Method that returns the Vector2D value of MaxBoundaries
     * @see Vector2D
     * @return MaxBoundaries
     */
    public Vector2D GetMaxBoundaries()
    {
        return MaxBoundaries;
    }


    /**
     * <b>GetMonsters</b>
     * returns the amount of monsters in the Level
     * @return Monsters
     */
    public ArrayList<MonsterPawn> GetMonsters()
    {
        return Monsters;
    }

    /**
     * <b>GetMonsterControllers</b>
     * returns the ArrayList of MonsterControllers in the Level
     * @return MonsterControllers
     */
    public ArrayList<MonsterController> GetMonsterControllers()
    {
        return MonsterControllers;
    }

    /**
     * <b>GetPlayer</b>
     * returns the PlayerPawn in the Level
     * @return Player
     */
    public PlayerPawn GetPlayer()
    {
        return Player;
    }

    /**
     * <b>GetPC</b>
     * returns the PC object
     * @return PC
     */
    public PlayerController GetPC()
    {
        return PC;
    }

    /**
     * <b>GetBattleReferee</b>
     * Gets the BattleReferee object called Referee
     * @return Referee
     */
    public BattleReferee GetReferee()
    {
        return Referee;
    }

    /**
     * <b>GetStoryString</b>
     * returns the story string value
     * @return StoryString
     */
    public String GetStoryString()
    {
        return StoryString;
    }

    /**
     * <b>GetBossP</b>
     * returns the BossPawn object named BossP
     * @return BossP
     */
    public BossPawn GetBossP()
    {
        return BossP;
    }

    /**
     * <b>SpawnPlayer</b>
     * Creates a player in the Level along with its location and rotation
     * @param NewPlayer when creating, use new PlayerPawn()
     * @param NewPC  when creating, use new PlayerController()
     * @param Loc Vector2D for where the player will be spawned
     * @param Rot Rotator for where the player will be facing when spawned
     * @param NewSword for the player's Sword Object
     * @param NewMace for the player's Mace Object
     */
    public void SpawnPlayer(PlayerPawn NewPlayer,PlayerController NewPC, Vector2D Loc, Rotator Rot, Weapon NewSword, Weapon NewMace)
    {
        //if there's no player object in this level
        if(Player == null)
        {
            //if the level exists
            if(GetLevel() != null)
            {
                //Set the Player object
                Player = NewPlayer;

                PC = NewPC;

                PC.Possess(Player);

                //assign the player's location in the Level Object
                GetLevel()[Loc.GetX()][Loc.GetY()] = Player;

                //Set the Location locally with the player
                Player.SetLocation(Loc.GetX(), Loc.GetY());

                //Set the player's rotation
                Player.Rotate(Rot);

                //Sets the ForwardVector for the Player Vector2D
                switch(Rot)
                {
                    case NORTH:
                        Player.SetForwardVector(new Vector2D(GetPlayer().GetLocation().GetX(),GetPlayer().GetLocation().GetY() - 1));
                        break;
                    case SOUTH:
                        Player.SetForwardVector(new Vector2D(GetPlayer().GetLocation().GetX(),GetPlayer().GetLocation().GetY() + 1));
                        break;
                    case EAST:
                        Player.SetForwardVector(new Vector2D(GetPlayer().GetLocation().GetX() + 1,GetPlayer().GetLocation().GetY()));
                        break;
                    case WEST:
                        Player.SetForwardVector(new Vector2D(GetPlayer().GetLocation().GetX() - 1,GetPlayer().GetLocation().GetY() - 1));
                        break;
                    default:
                        break;
                }

                Player.SetWeapon(NewSword);
                Player.SetWeapon(NewMace);
            }
        }
    }

    /**
     * <b>SpawnMonster</b>
     * Spawns Monster in the Level.
     * @param NewMonster Monster to spawn in the level
     * @param Loc Location of the monster in the level
     */
    public void SpawnMonster(MonsterPawn NewMonster, Vector2D Loc)
    {
        //Initialize Controller AI for new spawned monster
        MonsterController TempController = new MonsterController();

        //Set it's local Location
        NewMonster.SetLocation(Loc.GetX(), Loc.GetY());

        //Initialize it's World Location
        GetLevel()[NewMonster.GetLocation().GetX()][NewMonster.GetLocation().GetY()] = NewMonster;

        //have MonsterController Possess the new spawned MonsterPawn
        TempController.Possess(NewMonster);

        NewMonster.SetCollision(true);

        /**Setup for random choice for monster Weapon**/

        //Store temp Weapon object
        Weapon TempWeap;
        //Random class value
        Random rand = new Random();
        //Random range integer
        int RandRange = rand.nextInt((3-1) + 1) + 1;

        //switch statement to check for random weapon result
        switch(RandRange)
        {
            //Dagger
            case 1:
                TempWeap = new Dagger();
                NewMonster.SetWeapon(TempWeap);
                TempWeap.SetOwner(NewMonster);
                break;
            //Sword
            case 2:
                TempWeap = new Sword();
                NewMonster.SetWeapon(TempWeap);
                TempWeap.SetOwner(NewMonster);
                break;
            //Mace
            case 3:
                TempWeap = new Mace();
                NewMonster.SetWeapon(TempWeap);
                TempWeap.SetOwner(NewMonster);
                break;
            default:
                break;
        }

        //Add to Monsters ArrayList
        Monsters.add(NewMonster);

        //add the controller to the MonsterControllers ArrayList
        MonsterControllers.add(TempController);
    }

    public void SpawnBoss(BossPawn Boss, Vector2D Loc)
    {
        BossController TempController = new BossController();

        Boss.SetLocation(Loc.GetX(), Loc.GetY());

        GetLevel()[Boss.GetLocation().GetX()][Boss.GetLocation().GetY()] = Boss;

        TempController.Possess(Boss);

        Boss.SetCollision(true);

        BossP = Boss;
    }

    /**
     * <b>KillBoss</b>
     * Destroys the BossP instance
     */
    public void KillBoss()
    {
        BossP = null;
    }

    /**
     * <b>SpawnReferee</b>
     * Spawn the BattleReferee object when a battle is happening in the level
     * @param NewRef BattleReferee to spawn and reference with Referee object
     */
    public void SpawnReferee(BattleReferee NewRef)
    {
        Referee = NewRef;
    }

    /**
     * <b>DestroyReferee</b>
     * Removes the Referee from battle when the battle is completed
     */
    public void DestroyReferee()
    {
        if(Referee != null)
        {
            Referee = null;
        }
    }

    /**
     * <b>GetPlayerLocation</b>
     * returns the Vector2D location of the Player
     * @return Player.GetLocation()
     */
    public Vector2D GetPlayerLocation()
    {
        return Player.GetLocation();
    }

    /**
     * <b>SetPlayerLocation</b>
     * Sets a new location for the player in the level
     * @param NewLocation New Vector2D location for the player to be
     */
    public void SetPlayerLocation(Vector2D NewLocation)
    {
        Vector2D PrevLoc = GetPlayerLocation();
        Player.SetLocation(NewLocation.GetX(),NewLocation.GetY());
        GetLevel()[GetPlayer().GetLocation().GetX()][GetPlayer().GetLocation().GetY()] = Player;
        GetLevel()[PrevLoc.GetX()][PrevLoc.GetY()] = new Entity();
    }

    /**
     * <b>SetStoryString</b>
     * Sets the StoryString value in that particular time(Must clear on each new story output)
     * @param NewStory New StoryString value
     */
    public void SetStoryString(String NewStory)
    {
        StoryString = NewStory;
    }

}

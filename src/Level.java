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
     * An Array of 2D Arrays that any Entity can be in for the hallway. Must be Initialized
     */
    private Entity[][] Grid[];

    /**
     * <b>Player</b>
     * <p>private</p>
     * PlayerPawn object to spawn player into the level
     */
    private PlayerPawn Player;

    /**
     * <b>Monsters</b>
     * <p>private</p>
     * MonsterPawn Array that holds the amount of monsters in the
     * level to spawn
     */
    private MonsterPawn[] Monsters;

    /**
     * <b>MaxBoundaries</b>
     * <p>private</p>
     * Holds the Vector2D value of the x and y max boundaries of the level
     * initializes at <b>SetGridSize</b> Method
     */
    private Vector2D MaxBoundaries;

    /**
     * <b>GetGrid</b>
     * returns the level Grid 2DArray
     * @param Slot Which Hallway in the Array
     * @return Grid
     */
    public Entity[][] GetLevel(int Slot)
    {
        return Grid[Slot];
    }

    /**
     * <b>SetHallwaySize</b>
     * Sets the size of the Hallway 2D Array
     * @param Slot Which Hallway in the Array
     * @param Size Vector2D coordinates Size of the room
     */
    public void SetGridSize(int Slot, Vector2D Size)
    {
        Grid[Slot] = new Entity[Size.GetX()][Size.GetY()];
        //Where MaxBoundaries is initialized
        MaxBoundaries = new Vector2D(Size.GetX(), Size.GetY());
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
     * <b>SetTotalHallways</b>
     * Method that sets the size of the Hallway array
     * @param Size How many hallways in level
     */
    public void SetTotalLevels(int Size)
    {
        Grid = new Entity[0][0][Size];
    }

    /**
     * <b>SetBounds</b>
     * Method that sets the collision bounds of the Level Grid
     * @param GetGrid Array to set bounds to the Level
     * @param Slot int variable to tell which slot
     * @param Loc Vector that holds the X and Y coordinate to set bound location
     */
    public void SetBounds(Entity[][][] GetGrid,int Slot, Vector2D Loc)
    {
        if(GetGrid[Loc.GetX()][Loc.GetY()][Slot] == null)
        {
            //Create Wall at Location
            GetGrid[Loc.GetX()][Loc.GetY()][Slot] = new Wall();
        }
    }

    /**
     * <b>GetMonsters</b>
     * returns the amount of monsters in the Level
     * @return Monsters
     */
    public MonsterPawn[] GetMonsters()
    {
        return Monsters;
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
     * <b>SpawnPlayer</b>
     * Creates a player in the Level along with its location and rotation
     * @param NewPlayer when creating, use new PlayerPawn()
     * @param Loc Vector2D for where the player will be spawned
     * @param Rot Rotator for where the player will be facing when spawned
     */
    public void SpawnPlayer(PlayerPawn NewPlayer, Vector2D Loc, Rotator Rot)
    {
        //if there's no player object in this level
        if(Player == null)
        {
            //if the level exists
            if(GetLevel(0) != null)
            {
                //Set the Player object
                Player = NewPlayer;

                //assign the player's location in the Level Object
                GetLevel(0)[Loc.GetX()][Loc.GetY()] = Player;

                //Set the Location locally with the player
                Player.SetLocation(Loc.GetX(), Loc.GetY());

                //Set the player's rotation
                Player.Rotate(Rot);

                //Sets the ForwardVector for the Player Vector2D
                switch(Rot)
                {
                    case NORTH:
                        Player.SetForwardVector(new Vector2D(Loc.GetX(),Loc.GetY() - 1));
                        break;
                    case SOUTH:
                        Player.SetForwardVector(new Vector2D(Loc.GetX(),Loc.GetY() + 1));
                        break;
                    case EAST:
                        Player.SetForwardVector(new Vector2D(Loc.GetX() + 1,Loc.GetY()));
                        break;
                    case WEST:
                        Player.SetForwardVector(new Vector2D(Loc.GetX() - 1,Loc.GetY() - 1));
                        break;
                    default:
                        break;
                }
            }
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
        Player.SetLocation(NewLocation.GetX(),NewLocation.GetY());
    }

}

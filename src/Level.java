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
    private Entity[][] Hallway[];

    /**
     *<b>Room</b>
     * <p>private</p>
     * An Array of 2D Arrays that any Entity can be in for the Room. Must be Initialized
     */
    private Entity[][] Room[];

    /**
     * <b>Player</b>
     * <p>private</p>
     * PlayerPawn object to spawn player into the level
     */
    private PlayerPawn Player = new PlayerPawn();

    /**
     * <b>Monsters</b>
     * <p>private</p>
     * MonsterPawn Array that holds the amount of monsters in the
     * level to spawn
     */
    private MonsterPawn[] Monsters;

    /**
     * <b>GetGrid</b>
     * returns the level Grid 2DArray
     * @param Slot Which Hallway in the Array
     * @return Grid
     */
    public Entity[][] GetHallway(int Slot)
    {
        return Hallway[Slot];
    }

    /**
     * <b>SetHallwaySize</b>
     * Sets the size of the Hallway 2D Array
     * @param Slot Which Hallway in the Array
     * @param Size Vector2D coordinates Size of the room
     */
    public void SetHallwaySize(int Slot, Vector2D Size)
    {
        Hallway[Slot] = new Entity[Size.GetX()][Size.GetY()];
    }

    /**
     * <b>GetRoom</b>
     * returns the Room Entity object
     * @param Slot Which Room in the Array
     * @return Room
     */
    public Entity[][] GetRoom(int Slot)
    {
        return Room[Slot];
    }

    /**
     * <b>SetRoomSize</b>
     * Method that sets the X and Y area of the Room Array
     * @param Slot Which Room in the Array
     * @param Size Vector2D coordinates Size of the room
     */
    public void SetRoomSize(int Slot,Vector2D Size)
    {
        Room[Slot] = new Entity[Size.GetX()][Size.GetY()];
    }

    /**
     * <b>SetTotalRooms</b>
     * Method that sets the size of the Room Array
     * @param Size How many rooms in level
     */
    public void SetTotalRooms(int Size)
    {
        Room = new Entity[0][0][Size];
    }

    /**
     * <b>SetTotalHallways</b>
     * Method that sets the size of the Hallway array
     * @param Size How many hallways in level
     */
    public void SetTotalHallways(int Size)
    {
        Hallway = new Entity[0][0][Size];
    }

    /**
     * <b>SetBounds</b>
     * Method that sets the collision bounds of the Level Grid
     * @param Grid Array to set bounds to(Hallway, Room, etc.)
     * @param Slot int variable to tell which slot
     * @param Loc Vector that holds the X and Y coordinate to set bound location
     * @param Bounds boolean to turn on or off collision
     */
    public void SetBounds(Entity[][][] Grid,int Slot, Vector2D Loc, boolean Bounds)
    {
        if(Grid[Loc.GetX()][Loc.GetY()][Slot] != null)
        {
            Grid[Loc.GetX()][Loc.GetY()][Slot].SetCollision(Bounds);
        }
    }

    public MonsterPawn[] GetMonsters()
    {
        return Monsters;
    }

    public PlayerPawn GetPlayer()
    {
        return Player;
    }

    public void SpawnPlayer(PlayerPawn NewPlayer, Vector2D Loc, Rotator Rot)
    {
        if(Player != null)
        {
            if(GetHallway(0) != null)
            {
                GetHallway(0)[Loc.GetX()][Loc.GetY()] = NewPlayer;
                NewPlayer.SetLocation(Loc.GetX(), Loc.GetY());
                NewPlayer.Rotate(Rot);
            }
        }
    }

    public Vector2D GetPlayerLocation()
    {
        return Player.GetLocation();
    }

    public void SetPlayerLocation(Vector2D NewLocation)
    {
        Player.SetLocation(NewLocation.GetX(),NewLocation.GetY());
    }

}

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
     * A 2D Array that any Entity can be in for the hallway. Must be Initialized
     */
    private Entity Hallway[][];

    /**
     *<b>Room</b>
     * A 2D Array that any Entity can be in for the Room. Must be Initialized
     */
    private Entity Room[][];

    /**
     * <b>GetGrid</b>
     * returns the level Grid 2DArray
     * @return Grid
     */
    public Entity[][] GetHallway()
    {
        return Hallway;
    }

    /**
     * <b>SetGrid</b>
     * Sets the size of the 2D Array Grid
     * @param X Horizonal Dimension
     * @param Y Vertical Dimension
     */
    public void SetHallway(int X, int Y)
    {
        Hallway = new Entity[X][Y];
    }

    /**
     * <b>GetRoom</b>
     * returns the Room Entity object
     * @return Room
     */
    public Entity[][] GetRoom()
    {
        return Room;
    }

    /**
     * <b>SetRoomSize</b>
     * Method that sets the X and Y area of the Room Array
     * @param X
     * @param Y
     */
    public void SetRoomSize(int X, int Y)
    {
        Room = new Entity[X][Y];
    }

    /**
     * <b>SetBounds</b>
     * Method that sets the collision bounds of the Level Grid
     * @param Grid Array to set bounds to(Hallway, Room, etc.)
     * @param X Horizontal Dimension
     * @param Y Vertical Dimension
     * @param Bounds boolean to turn on or off collision
     */
    public void SetBounds(Entity[][] Grid,int X, int Y, boolean Bounds)
    {
        if(Grid[X][Y] != null)
        {
            Grid[X][Y].SetCollision(Bounds);
        }
    }
    
}

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
     *<b>Grid</b>
     * A 2D Array that any Entity can be in. Must be Initialized
     * in order to make level layout.
     */
    private Entity Grid[][];

    /**
     * <b>GetGrid</b>
     * returns the level Grid 2DArray
     * @return Grid
     */
    public Entity[][] GetGrid()
    {
        return Grid;
    }

    /**
     * <b>SetGrid</b>
     * Sets the size of the 2D Array Grid
     * @param X Horizonal Dimension
     * @param Y Vertical Dimension
     */
    public void SetGrid(int X, int Y)
    {
        Grid = new Entity[X][Y];
    }

    /**
     * <b>SetBounds</b>
     * Method that sets the collision bounds of the Level Grid
     * @param X Horizontal Dimension
     * @param Y Vertical Dimension
     * @param Bounds boolean to turn on or off collision
     */
    public void SetBounds(int X, int Y, boolean Bounds)
    {
        GetGrid()[X][Y].SetCollision(true);
    }




}

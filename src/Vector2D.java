/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     Vector2D is a object that holds the location on the X and Y
 *     coordinates of a particular location.
 * </p>
 */
public class Vector2D
{
    /**
     * <b>int X</b>
     * <p>private</p>
     * integer value that holds the horizontal value of the object
     */
    private int X;

    /**
     * <b>int Y</b>
     * <p>private</p>
     * integer value that holds the vertical value of the object
     */
    private int Y;

    /**
     * <b>CONSTRUCTOR</b>
     * @param x
     * @param y
     */
    Vector2D(int x, int y)
    {
        X = x;
        Y = y;
    }

    /**
     * <b>GetX</b>
     * gets the X value of the vector
     * @return X
     */
    public int GetX()
    {
        return X;
    }

    /**
     * <b>GetY</b>
     * gets the Y value of the vector
     * @return Y
     */
    public int GetY()
    {
        return Y;
    }
}

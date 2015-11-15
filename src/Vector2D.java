/**
 * Created by chadreddick on 11/15/15.
 * <p>
 *     Vector2D is a object that holds the location on the X and Y
 *     coordinates of a particular location.
 * </p>
 */
public class Vector2D
{
    /**
     * int X
     * private
     * integer value that holds the horizontal value of the object
     */
    private int X;

    /**
     * int Y
     * private
     * integer value that holds the vertical value of the object
     */
    private int Y;

    /**
     * CONSTRUCTOR
     * @param x
     * @param y
     */
    Vector2D(int x, int y)
    {
        X = x;
        Y = y;
    }

    /**
     * GetX
     * gets the X value of the vector
     * @return X
     */
    public int GetX()
    {
        return X;
    }

    /**
     * GetY
     * gets the Y value of the vecor
     * @return Y
     */
    public int GetY()
    {
        return Y;
    }
}

import java.awt.Image;
import java.awt.image.*;

/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     Entity is an Object class that is like an empty Game object.
 *     Reasoning for this class is to make things easier when getting the location
 *     of objects inside the level or setting new locations for the Entity inside
 *     the level. Also for a default base object for nearly all of the classes(besides
 *     the Controller class)
 * </p>
 */
public class Entity
{
    /**
     * <b>Location</b>
     * Holds a Vector2D Object of the Entity's location in the level
     */
    Vector2D Location;

    /**
     * <b>SplashArt</b>
     * Image object that holds the entity's splash art
     */
    Image SplashArt;

    /**
     * <b>SetLocation</b>
     * Method that sets the Location of the Entity in the level
     * @param x
     * @param y
     */
    public void SetLocation(int x, int y)
    {
        Location = new Vector2D(x,y);
    }

    /**
     * <b>GetLocation</b>
     * Method that gets the current location of the Entity in the level
     * @return Location
     */
    public Vector2D GetLocation()
    {
        return Location;
    }
}

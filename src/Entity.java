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
     * <p>private</p>
     * Holds a Vector2D Object of the Entity's location in the level
     */
    private Vector2D Location;

    /**
     * <b>SplashArt</b>
     * <p>private</p>
     * Image object that holds the entity's splash art
     */
    private Image SplashArt;

    /**
     * <b>boolean bHasCollision</b>
     * <p>private</p>
     * boolean that checks if this Entity has Collision bounds
     */
    private boolean bHasCollision;

    /**
     * <b>CurrentLevel</b>
     * <p>private</p>
     * Level Object that holds the level the Entity is currently inside
     */
    private Level CurrentLevel;

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

    public void SetCollision(boolean Collision)
    {
        bHasCollision = Collision;
    }

    /**
     * <b>SerCurrentLevel</b>
     * Sets the new current level for the Entity. If the Entity
     * is needed to be in a different level, this method will be of that
     * use
     * @param NewLevel Parameter to assign CurrentLevel
     */
    public void SetCurrentLevel(Level NewLevel)
    {
        CurrentLevel = NewLevel;
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

    /**
     * <b>GetHasCollision</b>
     * Method that returns the bHasCollision boolean
     * @return bHasCollision
     */
    public boolean GetHasCollision()
    {
        return bHasCollision;
    }

    public Level GetCurrentLevel()
    {
        return CurrentLevel;
    }
}

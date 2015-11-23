/**
 * <p>
 *     Door class is an object inherited from Entity. This object can
 *     either be already unlocked or require a Key to open
 *     @see Key for locked details
 * </p>
 */
public class Door extends Wall
{
    /**
     * <b>boolean IsLocked</b>
     * <p>private</p>
     * Determines if this door requires a key to be opened
     * @author Chad Reddick
     */
    private boolean IsLocked;

    /**
     * <b>CONSTRUCTOR</b>
     * @author Chad Reddick
     * @param Locked to initialize if the door requires a key
     */
    Door(boolean Locked)
    {
        IsLocked = Locked;
    }

    /**
     * <b>UnlockDoor</b>
     * @author Chad Reddick
     * Method that sets IsLocked to false;
     */
    public void UnlockDoor()
    {
        IsLocked = false;
    }
}

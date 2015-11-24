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
     * <b>boolean bIsLocked</b>
     * <p>private</p>
     * Determines if this door requires a key to be opened
     * @author Chad Reddick
     */
    private boolean bIsLocked;

    /**
     * <b>CONSTRUCTOR</b>
     * @author Chad Reddick
     * @param Locked to initialize if the door requires a key
     */
    Door(boolean Locked)
    {
        bIsLocked = Locked;
    }

    public void Use()
    {
        super.Use();

        //if Door is locked
        if(GetIsLocked())
        {
            //if the player has the key
            if(GetCurrentLevel().GetPlayer().GetInventory().contains(Key.class))
            {
                //Unlock the door
                UnlockDoor();
            }
        }
    }

    /**
     * <b>GetIsLocked</b>
     * returns to check if this door is locked
     * @return bIsLocked
     */
    public boolean GetIsLocked()
    {
        return bIsLocked;
    }

    /**
     * <b>UnlockDoor</b>
     * @author Chad Reddick
     * Method that sets IsLocked to false;
     */
    public void UnlockDoor()
    {
        bIsLocked = false;
        SetCollision(false);
    }
}

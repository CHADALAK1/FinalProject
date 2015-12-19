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
     * <b>LockName</b>
     * <p>private</p>
     * Holds the Lock name(for the key) to open the door
     * @see Key
     */
    private String LockName;

    /**
     * <b>CONSTRUCTOR</b>
     * @author Chad Reddick
     * @param Locked to initialize if the door requires a key
     * @param NewLevel Level this object is in
     * @pram NewLock Key name it needs to unlock this door
     */
    Door(boolean Locked, Level NewLevel, String NewLock)
    {
        bIsLocked = Locked;
        SetCurrentLevel(NewLevel);
        LockName = NewLock;
    }

    @Override
    public void Use()
    {
        super.Use();

        //if Door is locked
        if(GetIsLocked())
        {
            //if the player has the key
            for(int i = 0; i < GetCurrentLevel().GetPlayer().GetInventory().size(); i++)
            {
                if (GetCurrentLevel().GetPlayer().GetInventory().get(i) instanceof Key &&
                        GetCurrentLevel().GetPlayer().GetInventory().get(i).GetName() == GetLockName())
                {
                    //Unlock the door
                    UnlockDoor();
                    //remove the key
                    GetCurrentLevel().GetPlayer().GetInventory().remove(i);
                }
            }
        }
        else
        {
            System.out.println("Door is locked");
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
     * <b>GetLockName</b>
     * returns the String value for the Lock it needs to open
     * @return LockName
     */
    public String GetLockName()
    {
        return LockName;
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
        System.out.println("You unlocked the Door!");
    }
}

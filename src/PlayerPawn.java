import java.util.*;

/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     PlayerPawn class is an object inherited from Pawn that ONLY the
 *     Player can possess and control.Reasoning for this is
 *     to separate ownership of which Pawn is controlled and vise-
 *     versa.
 * </p>
 */
public class PlayerPawn extends Pawn
{
    /**
     * <b>Inventory</b>
     * <p>private</p>
     * An ArrayList that holds Items the PlayerPawn is currently holding
     */
    private ArrayList<Item> Inventory = new ArrayList<Item>();

    /**
     * <b>CONSTRUCTOR</b>
     */
    PlayerPawn()
    {
        SetHealth(100);
        SetArmor(50);
    }

    /**
     * <b>GetInventory</b>
     * returns the ArrayList of Items called Inventory
     * @return Inventory
     */
    public ArrayList<Item> GetInventory()
    {
        return Inventory;
    }

    public void Interact()
    {
        //override the method
        super.Interact();

        //check if there's a door in front of the player
        if(GetCurrentLevel().GetLevel(GetLevelSlot())[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof Door)
        {
            GetCurrentLevel().GetLevel(GetLevelSlot())[GetForwardVector().GetX()][GetForwardVector().GetY()].Use();
        }
    }
}

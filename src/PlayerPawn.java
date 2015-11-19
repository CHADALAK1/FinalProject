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

    public void Interact()
    {
        //override the method
        super.Interact();
    }
}

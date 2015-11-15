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
     * Inventory
     * An ArrayList that holds Items the PlayerPawn is currently holding
     */
    ArrayList<Item> Inventory = new ArrayList<Item>();

    PlayerPawn()
    {
        SetHealth(100);
        SetArmor(50);
    }
}

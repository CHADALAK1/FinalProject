/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     NPCPawn class is an object inherited by Pawn. Its the
 *     vessel that the NPCController will possess. NPCPawns
 *     too can be killed and destroyed just like any other Pawns.
 *     Consequences or perks can become of doing killing or living.
 * </p>
 */
public class NPCPawn extends Pawn
{
    /**
     * <b>int XPValue</b>
     * <p>private</p>
     * an integer value that gives the PlayerController if the Player kills
     * the NPCPawn
     */
    private int XPValue;

    /**
     * <b>XPValue</b>
     * Method that gets the XPValue of the Pawn
     * @return XPValue
     */
    public int GetXPValue()
    {
        return XPValue;
    }
}

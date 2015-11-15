/**
 * Created by Chad Reddick on 11/15/15.
 */
public class NPCPawn extends Pawn
{
    /**
     * int XPValue
     * private
     * an integer value that gives the PlayerController if the Player kills
     * the NPCPawn
     */
    private int XPValue;

    /**
     * XPValue
     * Method that gets the XPValue of the Pawn
     * @return XPValue
     */
    public int GetXPValue()
    {
        return XPValue;
    }
}

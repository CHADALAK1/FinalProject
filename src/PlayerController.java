/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     PlayerController class is an object inherited by Controller
 *     which only can possess a PlayerPawn. Reasoning for this is
 *     to separate ownership of which Pawn is controlled and vise-
 *     versa.
 * </p>
 */
public class PlayerController extends Controller
{
    /**
    <b>CONSTRCUTOR</b>
     */
    PlayerController()
    {

    }

    /**
     <b>int XP</b>
     * <p>private</p>
     * <p>
     *     XP(or Experience Points) makes the player have the ability to increase
     *     stats based on XP range and ratio. Reason for XP to be in PlayerController
     *     Class and NOT in Controller class is because we only want the Player to
     *     increase in their own ranks against Monsters and Bosses.
     * </p>
     */
    private int XP;

    /**
     * <b>GetXP</b>
     * Method that Gets the XP value
     * @return XP
     */
    public int GetXP()
    {
        return XP;
    }

    /**
     * <b>SetXP</b>
     * method that sets the XP value
     * @param NewXP integer value parameter that sets the XP
     */
    public void SetXP(int NewXP)
    {
        XP = NewXP;
    }

    /**
     * <b>AddedXP</b>
     * Method that adds more to the XP value
     * @param AddedXP integer value parameter that adds more to XP
     */
    public void AddXP(int AddedXP)
    {
        if(AddedXP > 0)
        {
            XP += AddedXP;
        }
    }

    /**
     * Below are the calls to move player in 'x' direction.
     */
    public void moveNorth()
    {
        GetControlledPawn().MoveUp();
    }

    public void moveSouth()
    {
        GetControlledPawn().MoveDown();
    }

    public void moveWest()
    {
        GetControlledPawn().MoveLeft();
    }

    public void moveEast()
    {
        GetControlledPawn().MoveRight();
    }

}

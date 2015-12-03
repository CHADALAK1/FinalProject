/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     Controller class is an object that has the ability to control and
 *     possess pawns.
 *     @see  Pawn for more concept details
 * </p>
 */

public class Controller
{
    /**
    <b>ControlledPawn</b>
    * <p>private</p>
    * Pawn Object that holds the Pawn the Controller has Possessed
    * Use GetControlledPawn() method to retrieve the Pawn Object
     */
    private Pawn ControlledPawn;

    /**
    <b>Possess</b>
    * Allows the Controller class to control and possess a Pawn
    * @param Vessel  Vessel is for which pawn to possess
    */
    public void Possess(Pawn Vessel)
    {
        if(ControlledPawn == null)
        {
            ControlledPawn = Vessel;
            ControlledPawn.SetController(this);
        }
    }

    /**
    <b>GetControlledPawn</b>
    * @return the ControlledPawn object if not null
    * @see  Pawn
    */
    public Pawn GetControlledPawn()
    {
        if(ControlledPawn == null)
        {
            System.out.println("Controller does not own any Pawn");
            ControlledPawn = null;
        }
        return ControlledPawn;
    }
}

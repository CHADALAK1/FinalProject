/**
 * Created by chadreddick on 11/15/15.
 */
public class Controller
{
    /*
    ControlledPawn
    * private
    * Pawn Object that holds the Pawn the Controller has Possessed
    * Use GetControlledPawn() method to retrieve the Pawn Object
     */
    private Pawn ControlledPawn;

    /*
    Possess method
    * Allows the Controller class to control and possess a Pawn
    @param Vessel
    * Vessel is for which pawn to possess
    */
    public void Possess(Pawn Vessel)
    {
        if(ControlledPawn == null)
        {
            ControlledPawn = Vessel;
        }
    }

    /*
    GetControlledPawn
    * This Method returns the ControlledPawn object if not null
    */
    public Pawn GetControlledPawn()
    {
        if(ControlledPawn == null)
        {
            return null;
        }
        return ControlledPawn;
    }


}

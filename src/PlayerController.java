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
    /*
    CONSTRCUTOR
     */
    PlayerController()
    {
        //Possess a PlayerPawn upon Game Startup
        Possess(new PlayerPawn());
    }
}

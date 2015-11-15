/**
 * Created by chadreddick on 11/15/15.
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

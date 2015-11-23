/**
 * Created by Chad Reddick on 11/19/15.
 */
public class Level01 extends Level
{
    /**
     * <b>CONSTRUCTOR</b>
     */
    public Level01()
    {
        //Set the amount of levels
        SetTotalLevels(1);

        //Set the hallway and room sizes
        SetGridSize(0,new Vector2D(50,50));

        //Spawn the player
        SpawnPlayer(GetPlayer(),new Vector2D(10,10),Rotator.NORTH);

        //Set the Current Level for the Player
        GetPlayer().SetCurrentLevel(this);
    }
}

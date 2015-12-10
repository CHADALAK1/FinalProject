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
        SetTotalLevels(0);

        //Set the hallway and room sizes
        SetGridSize(0,new Vector2D(50,50));

        //Spawn the player
        SpawnPlayer(new PlayerPawn(), new PlayerController(), new Vector2D(10,10),Rotator.NORTH);

        //Spawn the Monster
        SpawnMonster(new MonsterPawn(),new Vector2D(35,35));

        //Set the Current Level for the Player
        GetPlayer().SetCurrentLevel(this);
    }
}

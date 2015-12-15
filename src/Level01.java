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

        //Set the hallway and room sizes
        SetGridSize(new Vector2D(50,50));

        //Spawn the player
        SpawnPlayer(new PlayerPawn(), new PlayerController(), new Vector2D(10,10),Rotator.NORTH);

        //Spawn the Monster
        SpawnMonster(new MonsterPawn(),new Vector2D(8,10));

        //Set the Current Level for the Player
        GetPlayer().SetCurrentLevel(this);

        //Set the grid visuals AFTER everything is initialized in the level
        SetVisualGrid();
    }
}

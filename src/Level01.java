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
        //Set the amount of rooms and hallways
        SetTotalRooms(2);
        SetTotalHallways(1);

        //Set the hallway and room sizes
        SetRoomSize(0,new Vector2D(20,20));
        SetRoomSize(1,new Vector2D(40,40));
        SetHallwaySize(0,new Vector2D(50,30));

        //Spawn the player
        SpawnPlayer(GetPlayer(),new Vector2D(10,10),Rotator.NORTH);

        //Set the Current Level for the Player
        GetPlayer().SetCurrentLevel(this);
    }
}

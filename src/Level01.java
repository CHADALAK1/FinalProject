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
        SetGridSize(new Vector2D(20,20));

        //Set walls into grid.
        //Template: GetLevel()[][] = new Wall();

        GetLevel()[1][3] = new Wall();
        GetLevel()[3][3] = new Wall();
        GetLevel()[4][3] = new Wall();
        GetLevel()[5][3] = new Wall();
        GetLevel()[6][3] = new Wall();
        GetLevel()[7][3] = new Wall();
        GetLevel()[8][3] = new Wall();
        GetLevel()[9][3] = new Wall();
        GetLevel()[10][3] = new Wall();
        GetLevel()[12][3] = new Wall();
        GetLevel()[13][3] = new Wall();
        GetLevel()[14][3] = new Wall();
        GetLevel()[15][3] = new Wall();
        GetLevel()[16][3] = new Wall();
        GetLevel()[17][3] = new Wall();
        GetLevel()[18][3] = new Wall();
        GetLevel()[18][3] = new Wall();
        GetLevel()[9][1] = new Wall();
        GetLevel()[9][2] = new Wall();
        GetLevel()[5][4] = new Wall();
        GetLevel()[12][4] = new Wall();
        GetLevel()[5][5] = new Wall();
        GetLevel()[12][5] = new Wall();
        GetLevel()[5][6] = new Wall();
        GetLevel()[11][6] = new Wall();
        GetLevel()[12][6] = new Wall();
        GetLevel()[13][6] = new Wall();
        GetLevel()[14][6] = new Wall();
        GetLevel()[15][6] = new Wall();
        GetLevel()[17][6] = new Wall();
        GetLevel()[18][6] = new Wall();
        GetLevel()[11][7] = new Wall();
        GetLevel()[11][8] = new Wall();
        GetLevel()[5][9] = new Wall();
        GetLevel()[11][9] = new Wall();
        GetLevel()[5][10] = new Wall();
        GetLevel()[11][10] = new Wall();
        GetLevel()[1][11] = new Wall();
        GetLevel()[2][11] = new Wall();
        GetLevel()[3][11] = new Wall();
        GetLevel()[4][11] = new Wall();
        GetLevel()[5][11] = new Wall();
        GetLevel()[7][11] = new Wall();
        GetLevel()[8][11] = new Wall();
        GetLevel()[9][11] = new Wall();
        GetLevel()[10][11] = new Wall();
        GetLevel()[11][11] = new Wall();
        GetLevel()[15][11] = new Wall();
        GetLevel()[16][11] = new Wall();
        GetLevel()[17][11] = new Wall();
        GetLevel()[18][11] = new Wall();
        GetLevel()[10][13] = new Wall();
        GetLevel()[1][14] = new Wall();
        GetLevel()[2][14] = new Wall();
        GetLevel()[3][14] = new Wall();
        GetLevel()[4][14] = new Wall();
        GetLevel()[5][14] = new Wall();
        GetLevel()[6][14] = new Wall();
        GetLevel()[10][14] = new Wall();
        GetLevel()[10][15] = new Wall();
        GetLevel()[4][16] = new Wall();
        GetLevel()[5][16] = new Wall();
        GetLevel()[6][16] = new Wall();
        GetLevel()[10][16] = new Wall();
        GetLevel()[11][16] = new Wall();
        GetLevel()[12][16] = new Wall();
        GetLevel()[13][16] = new Wall();
        GetLevel()[14][16] = new Wall();
        GetLevel()[15][16] = new Wall();
        GetLevel()[16][16] = new Wall();
        GetLevel()[17][16] = new Wall();
        GetLevel()[18][16] = new Wall();
        GetLevel()[4][17] = new Wall();
        GetLevel()[4][18] = new Wall();

        //Set doors into map.
        //Template: GetLevel()[][] = new Door();
        //TODO: Started addition of Door()
        //TODO: Broken && boolean status?
        /*
        GetLevel()[2][3] = new Door(false);
        GetLevel()[11][3] = new Door(true);
        GetLevel()[16][6] = new Door(true);
        */

        //TODO: Keys should have an Identifier to unlock doors in series.
        /**
            Key #1 = opens door 1
            Key #2 = opens door 2 (which room will have boss key #3 )
            Key #3 = open boss door 3.
         */
        //Set keys into map (to open doors).
        //Template: GetLevel()[][] = new Key();
        //TODO: Started addition of Key()
        GetLevel()[17][1] = new Key();
        GetLevel()[3][10] = new Key();
        GetLevel()[17][17] = new Key();

        //Set health into map.
        //TODO: Instance?

        //Set armor into map.
        //Template: GetLevel()[][] = new Armor();
        //TODO: Started addition of Armor()
        GetLevel()[1][2] = new Armor();
        GetLevel()[18][4] = new Armor();
        GetLevel()[17][12] = new Armor();
        GetLevel()[17][18] = new Armor();

        //Spawn the player (horizontal , vertical)
        SpawnPlayer(new PlayerPawn(), new PlayerController(), new Vector2D(2,18),Rotator.NORTH, new Sword(), new Mace());

        //Spawn the Monster(s) into map. (horizontal , vertical)
        //TODO: Rand for weapons.
        SpawnMonster(new MonsterPawn(),new Vector2D(11,2), new Sword());
        SpawnMonster(new MonsterPawn(),new Vector2D(15,4),new Mace());
        SpawnMonster(new MonsterPawn(),new Vector2D(9,5),new Sword());
        SpawnMonster(new MonsterPawn(),new Vector2D(3,8), new Mace());
        SpawnMonster(new MonsterPawn(),new Vector2D(17,8),new Sword());
        SpawnMonster(new MonsterPawn(),new Vector2D(6,10),new Mace());
        SpawnMonster(new MonsterPawn(),new Vector2D(15,15), new Sword());
        SpawnMonster(new MonsterPawn(),new Vector2D(15,17),new Mace());
        SpawnMonster(new MonsterPawn(),new Vector2D(7,18),new Sword());

        //Spawn the Boss into map
        //TODO: Need boss. 2 down by 6 right

        //Set the Current Level for the Player
        GetPlayer().SetCurrentLevel(this);

        for(int i = 0; i < GetMonsters().size(); i++)
        {
            GetMonsters().get(i).SetCurrentLevel(this);
        }

        //Set the grid visuals AFTER everything is initialized in the level
        SetVisualGrid();
    }
}

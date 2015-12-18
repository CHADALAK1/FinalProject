/**
 * Created by Chad Reddick on 12/11/15.
 *
 * <p>
 *     BattleReferee is a class that holds the rules for the battle sequences.
 *     Once the Monster or player is dead, the Referee will destroy itself
 *     from the Level
 * </p>
 */
public class BattleReferee
{
    /**
     * <b>Player</b>
     * <p>private</p>
     * Holds the PlayerPawn fighting the Monster
     */
    private PlayerPawn Player;

    /**
     * <b>Monster</b>
     * <p>private</p>
     * Holds the MonsterPawn fighting the Player
     */
    private MonsterPawn Monster;

    /**
     * <b>bIsPlayerTurn</b>
     * <p>private</p>
     * Boolean value that checks if the Player can do something during the battle
     */
    private boolean bIsPlayerTurn;

    /**
     * <b>bIsMonsterTurn</b>
     * <p>private</p>
     * Boolean value that checks if the Monster can do something during the battle
     */
    private boolean bIsMonsterTurn;

    /**
     * <b>CONSTRUCTOR</b>
     * @param MP MonsterPawn object fighting
     * @param PP PlayerPawn object fighting
     */
    BattleReferee(MonsterPawn MP, PlayerPawn PP)
    {
        Monster = MP;
        Player = PP;
    }

    /**
     * <b>Turn</b>
     * Checks on which pawn's turn it is when in battle
     * @param DeadPawn Which pawn to check is dead(NOT USED YET)
     */
    public void Turn(Pawn DeadPawn)
    {
        if(GetPlayer().GetHealth() > 0 || GetMonster().GetHealth() > 0)
        {
            //if called when player ends turn
            if (GetIsPlayerTurn() && !GetIsMonsterTurn())
            {
                //make it the monster's turn
                SetIsMonsterTurn(true);
                SetIsPlayerTurn(false);
                GetMonster().PrepareAttack();
            }
            //if called when monster ends turn
            else
            {
                //make it the player's turn
                SetIsMonsterTurn(false);
                SetIsPlayerTurn(true);
            }
        }
        else
        {
            EndMatch();
        }
    }

    /**
     * <b>EndMatch</b>
     * Ends the match between monster and player.
     * Also Destroys self upon ending
     */
    public void EndMatch()
    {
        System.out.println("REFEREE LEFT");
        Monster = null;
        GetPlayer().GetCurrentLevel().DestroyReferee();
    }

    /**
     * <b>GetPlayer</b>
     * Gets the Player object
     * @return Player
     */
    public PlayerPawn GetPlayer()
    {
        return Player;
    }

    /**
     * <b>GetMonster</b>
     * Gets the Monster object
     * @return Monster
     */
    public MonsterPawn GetMonster()
    {
        return Monster;
    }

    /**
     * <b>GetIsPlayerTurn</b>
     * Gets the bIsPlayerTurn boolean
     * @return bIsPlayerTurn
     */
    public boolean GetIsPlayerTurn()
    {
        return bIsPlayerTurn;
    }

    /**
     * <b>GetIsMonsterTurn</b>
     * Gets the bIsMonsterTurn boolean
     * @return bIsMonsterTurn
     */
    public boolean GetIsMonsterTurn()
    {
        return bIsMonsterTurn;
    }

    /**
     * <b>SetIsPlayerTurn</b>
     * Sets the bIsPlayerTurn boolean true or false
     * @param Turn the new boolean to set true or false to bIsPlayerTurn
     */
    public void SetIsPlayerTurn(boolean Turn)
    {
        bIsPlayerTurn = Turn;
    }

    /**
     * <b>SetIsMonsterTurn</b>
     * Sets the bIsMonsterTurn boolean true or false
     * @param Turn the new boolean to set true or false to bIsMonsterTurn
     */
    public void SetIsMonsterTurn(boolean Turn)
    {
        bIsMonsterTurn = Turn;
    }
}

/**
 * Created by chadreddick on 12/11/15.
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
        Turn();
    }

    public void Turn()
    {
        if(GetIsPlayerTurn() && !GetIsMonsterTurn())
        {
            SetIsMonsterTurn(true);
            SetIsPlayerTurn(false);
        }
        else
        {
            SetIsMonsterTurn(false);
            SetIsPlayerTurn(true);
        }
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

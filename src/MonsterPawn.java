/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     MonsterPawn class is a class inherited from NPCPawn.
 *     MonsterPawn has the ability to attack and have random
 *     stats based on how MonsterPawn and MonsterController is
 *     spawned in the level.
 * </p>
 */
public class MonsterPawn extends NPCPawn
{
    /**
     * CONSTRUCTOR
     */
    public MonsterPawn()
    {
        SetCollision(true);
        SetName("DerpY");
        SetHealth(100);
        SetArmor(10);
        SetIsDead(false);
    }

    /**
     * <b>Attack</b>
     * Makes the MonsterPawn attack the player
     */
    public void Attack()
    {
        //if the player is in the level
        if (GetCurrentLevel().GetPlayer() != null)
        {
            //Store the player pawn in local variable(for easier typing
            PlayerPawn P = GetCurrentLevel().GetPlayer();
            //if there is a BattleReferee on the scene
            if (GetCurrentLevel().GetReferee() != null)
            {
                //if it's the monster's turn
                if (GetCurrentLevel().GetReferee().GetIsMonsterTurn())
                {
                    System.out.println("Monster is now Attacking...");
                    GetWeapon().get(0).ApplyDamage(P);
                    GetCurrentLevel().GetReferee().Turn(P);
                }
            }
        }
    }


    /**
     * <b>PrepareAttack</b>
     * Does pre-initial logic before the MonsterPawn attacks
     */
    public void PrepareAttack()
    {
        Attack();
    }
}

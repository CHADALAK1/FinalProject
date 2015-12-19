import java.util.Random;

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
        System.out.println(GetName());
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
            //if we hit the player(2/3 chance)
            if (!MissChance(1,3))
            {
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
            else
            {
                System.out.println("MONSTER HAS MISSED....");
                GetCurrentLevel().GetReferee().Turn(P);
            }
        }
    }

    /**
     * <b>MissChance</b>
     * boolean return that tells the monster if we managed to hit the player
     * @param min minimum range the monster will hit(RandRange)
     * @param max maximum range the monster will hit(RandRange)
     * @return bHasHit
     */
    private boolean MissChance(int min, int max)
    {
        Random rand = new Random();
        boolean bHasHit;

        int MissChance = rand.nextInt((max - min) + 1) + min;
        if(MissChance == 3)
        {
            bHasHit = true;
        }
        else
        {
            bHasHit = false;
        }

        return bHasHit;
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

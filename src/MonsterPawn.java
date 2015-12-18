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
    public MonsterPawn()
    {
        SetCollision(true);
        SetName("DerpY");
        System.out.println(GetName());
        SetHealth(100);
        SetArmor(10);
        SetIsDead(false);
    }

    public void Attack()
    {
        if(GetCurrentLevel().GetPlayer() != null)
        {
            PlayerPawn P = GetCurrentLevel().GetPlayer();
            if(GetCurrentLevel().GetReferee() != null)
            {
                if (GetCurrentLevel().GetReferee().GetIsMonsterTurn())
                {
                    System.out.println("Monster is now Attacking...");
                    GetWeapon().get(0).ApplyDamage(P);
                    GetCurrentLevel().GetReferee().Turn(P);
                }
            }
        }
    }

    public void PrepareAttack()
    {
        Attack();
    }
}

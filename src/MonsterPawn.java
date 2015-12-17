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
    }

    public void Attack()
    {
        if(GetCurrentLevel().GetPlayer() != null)
        {
            PlayerPawn P = GetCurrentLevel().GetPlayer();
            if(GetCurrentLevel().GetReferee().GetIsMonsterTurn())
            {
                GetWeapon().get(0).ApplyDamage(P);
                GetCurrentLevel().GetReferee().SetIsMonsterTurn(false);
                GetCurrentLevel().GetReferee().SetIsPlayerTurn(true);
            }
        }
    }
}

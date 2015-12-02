/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     PlayerPawn class is an object inherited from Pawn that ONLY the
 *     Player can possess and control.Reasoning for this is
 *     to separate ownership of which Pawn is controlled and vise-
 *     versa.
 * </p>
 */
public class PlayerPawn extends Pawn
{
    /**
     * <b>CONSTRUCTOR</b>
     */
    PlayerPawn()
    {
        SetHealth(100);
        SetArmor(50);
    }

    public void Interact()
    {
        //override the method
        super.Interact();

        //check if there's a door in front of the player
        if(GetCurrentLevel().GetLevel(GetLevelSlot())[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof Door)
        {
            GetCurrentLevel().GetLevel(GetLevelSlot())[GetForwardVector().GetX()][GetForwardVector().GetY()].Use();
        }

        //check if there's a weapon in front of the player
        if(GetCurrentLevel().GetLevel(GetLevelSlot())[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof Item)
        {

        }
        //check if there's a monster in front of the player
        if(GetCurrentLevel().GetLevel(GetLevelSlot())[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof MonsterPawn)
        {
            for(int i = 0; i < GetCurrentLevel().GetMonsters().length; i++)
            {
                if(GetForwardVector() == GetCurrentLevel().GetMonsters()[i].GetLocation() &&
                        !GetCurrentLevel().GetMonsters()[i].IsDead())
                {
                    GetWeapon().ApplyDamage(GetCurrentLevel().GetMonsters()[i]);
                }
            }
        }
    }
}

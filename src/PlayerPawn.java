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

    @Override
    public void Interact()
    {
        //override the method
        super.Interact();

        //check if there's a door in front of the player
        if(GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof Door)
        {
            GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()].Use();
        }

        //check if there's a Item in front of the player
        if(GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof Item)
        {
            //Pick up the Item
            GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()].Pickup();
        }
        //check if there's a monster in front of the player
        if(GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof MonsterPawn)
        {
            //find out which monster it is
            for(int i = 0; i < GetCurrentLevel().GetMonsters().size(); i++)
            {
                //if the monster found in the ArrayList is the same one the player's ForwardVector is(also check if monster isnt dead
                if (GetForwardVector() == GetCurrentLevel().GetMonsters().get(i).GetLocation() &&
                        !GetCurrentLevel().GetMonsters().get(i).IsDead())
                {
                    //if the player has a weapon in hand
                    if(GetWeapon() != null)
                    {
                        //if there's no BattleReferee in the level
                        if(GetCurrentLevel().GetReferee() == null)
                        {
                            //spawn the referee                                     Monster player's attacking      Player
                            GetCurrentLevel().SpawnReferee(new BattleReferee(GetCurrentLevel().GetMonsters().get(i), this));
                            //Set the player's turn
                            GetCurrentLevel().GetReferee().SetIsPlayerTurn(true);
                            //ensure it's not the monsters turn
                            GetCurrentLevel().GetReferee().SetIsMonsterTurn(false);
                            //apply damage to the monster
                            GetWeapon().ApplyDamage(GetCurrentLevel().GetMonsters().get(i));
                            //end player's turn
                            GetCurrentLevel().GetReferee().Turn();
                        }
                        //if there is a BattleReferee in the level
                        else
                        {
                            //if it's the player's tur
                            if(GetCurrentLevel().GetReferee().GetIsPlayerTurn())
                            {
                                //apply damage to the monster
                                GetWeapon().ApplyDamage(GetCurrentLevel().GetMonsters().get(i));
                                //end turn
                                GetCurrentLevel().GetReferee().Turn();
                            }
                        }
                    }
                }
            }
        }
    }
}

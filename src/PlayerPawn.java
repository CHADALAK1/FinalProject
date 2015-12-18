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
            System.out.println("AH A MONSTER");
            //find out which monster it is
            for(int i = 0; i < GetCurrentLevel().GetMonsters().size(); i++)
            {
                //if the monster found in the ArrayList is the same one the player's ForwardVector is(also check if monster isnt dead
                if (GetForwardVector().GetX() == GetCurrentLevel().GetMonsters().get(i).GetLocation().GetX() &&
                        GetForwardVector().GetY() == GetCurrentLevel().GetMonsters().get(i).GetLocation().GetY() &&
                        !GetCurrentLevel().GetMonsters().get(i).IsDead())
                {
                    System.out.println("I KNOW THIS MONSTER");
                    //if there's no BattleReferee in the level
                    if(GetCurrentLevel().GetReferee() == null)
                    {
                        System.out.println("Spawning Referee....");
                        //spawn the referee                                     Monster player's attacking      Player
                        GetCurrentLevel().SpawnReferee(new BattleReferee(GetCurrentLevel().GetMonsters().get(i), this));
                        //Set the player's turn
                        GetCurrentLevel().GetReferee().SetIsPlayerTurn(true);
                        //ensure it's not the monsters turn
                        GetCurrentLevel().GetReferee().SetIsMonsterTurn(false);

                        if(GetCurrentLevel().GetReferee() != null)
                        {
                            System.out.println("REFEREEE IS IN PLACE");
                        }
                    }
                }
            }
        }
    }

    @Override
    public void InteractBattle(int WeapSlot)
    {
        super.InteractBattle(WeapSlot);

        //check if there's a monster in front of the player
        if(GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof MonsterPawn)
        {
            //find out which monster it is
            for(int i = 0; i < GetCurrentLevel().GetMonsters().size(); i++)
            {
                //if the monster found in the ArrayList is the same one the player's ForwardVector is(also check if monster isnt dead
                if (GetForwardVector().GetX() == GetCurrentLevel().GetMonsters().get(i).GetLocation().GetX() &&
                        GetForwardVector().GetY() == GetCurrentLevel().GetMonsters().get(i).GetLocation().GetY())
                {
                    //if the player has a weapon in hand
                    if(GetWeapon() != null)
                    {
                        //if there's no BattleReferee in the level
                        if(GetCurrentLevel().GetReferee() != null)
                        {
                            if(GetCurrentLevel().GetReferee().GetIsPlayerTurn())
                            {
                                if(GetCurrentLevel().GetMonsters().get(i).GetHealth() > 0)
                                {
                                    GetWeapon().get(WeapSlot).ApplyDamage(GetCurrentLevel().GetReferee().GetMonster());
                                    System.out.println("Hit for " + GetWeapon().get(WeapSlot).GetMeleeDamage().GetDamageAmount() +
                                            " with a " + GetWeapon().get(WeapSlot).GetName());
                                    //end player's turn
                                    GetCurrentLevel().GetReferee().Turn(GetCurrentLevel().GetMonsters().get(i));
                                }
                                else
                                {
                                    Vector2D Loc = GetCurrentLevel().GetMonsters().get(i).GetLocation();
                                    System.out.println("DEAD MONSTER");
                                    GetCurrentLevel().GetReferee().GetMonster().SetHealth(0);
                                    GetCurrentLevel().GetReferee().EndMatch();
                                    GetCurrentLevel().GetMonsters().remove(i);
                                    GetCurrentLevel().GetLevel()[Loc.GetX()][Loc.GetY()] = new Entity();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

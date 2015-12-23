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
        //check if there's a monster in front of the player
        if(GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof BossPawn)
        {
            System.out.println("AH A MONSTER");
            //if there's no BattleReferee in the level
            if(GetCurrentLevel().GetReferee() == null)
            {
                System.out.println("Spawning Referee....");
                //spawn the referee                                     Monster player's attacking      Player
                GetCurrentLevel().SpawnReferee(new BattleReferee(GetCurrentLevel().GetBossP(), this));
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

    @Override
    public void InteractBattle(int WeapSlot) {
        super.InteractBattle(WeapSlot);

        //check if there's a monster in front of the player
        if (GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof MonsterPawn)
        {
            //find out which monster it is
            for (int i = 0; i < GetCurrentLevel().GetMonsters().size(); i++)
            {
                //if the monster found in the ArrayList is the same one the player's ForwardVector is
                if (GetForwardVector().GetX() == GetCurrentLevel().GetMonsters().get(i).GetLocation().GetX() &&
                        GetForwardVector().GetY() == GetCurrentLevel().GetMonsters().get(i).GetLocation().GetY())
                {
                    //if the player has a weapon in hand
                    if (GetWeapon() != null)
                    {
                        //if there's no BattleReferee in the level
                        if (GetCurrentLevel().GetReferee() != null)
                        {
                            //if it's the player's turn
                            if (GetCurrentLevel().GetReferee().GetIsPlayerTurn())
                            {
                                //if the monster's heal is still there
                                if (GetCurrentLevel().GetMonsters().get(i).GetHealth() > 0)
                                {
                                    GetWeapon().get(WeapSlot).ApplyDamage(GetCurrentLevel().GetReferee().GetMonster());
                                    //end player's turn
                                    GetCurrentLevel().GetReferee().Turn(GetCurrentLevel().GetMonsters().get(i));
                                }
                                else
                                {
                                    //store monster's Vector2D location temporarily
                                    Vector2D Loc = GetCurrentLevel().GetMonsters().get(i).GetLocation();
                                    System.out.println("DEAD MONSTER");
                                    //set monster's health to 0
                                    GetCurrentLevel().GetReferee().GetMonster().SetHealth(0);
                                    //End the match with the referee
                                    GetCurrentLevel().GetReferee().EndMatch();
                                    //remove the monster in the ArrayList
                                    GetCurrentLevel().GetMonsters().remove(i);
                                    //Make the space in the level an empty entity space where the monster used to be
                                    GetCurrentLevel().GetLevel()[Loc.GetX()][Loc.GetY()] = new Entity();
                                }
                            }
                        }
                    }
                }
            }
        }
        //check if there's a monster in front of the player
        else if (GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()] instanceof BossPawn)
        {
                    //if the player has a weapon in hand
                    if (GetWeapon() != null)
                    {
                        //if there's no BattleReferee in the level
                        if (GetCurrentLevel().GetReferee() != null)
                        {
                            //if it's the player's turn
                            if (GetCurrentLevel().GetReferee().GetIsPlayerTurn())
                            {
                                //if the monster's heal is still there
                                if (GetCurrentLevel().GetBossP().GetHealth() > 0)
                                {
                                    GetWeapon().get(WeapSlot).ApplyDamage(GetCurrentLevel().GetReferee().GetMonster());
                                    //end player's turn
                                    GetCurrentLevel().GetReferee().Turn(GetCurrentLevel().GetBossP());
                                }
                                else
                                {
                                    //store monster's Vector2D location temporarily
                                    Vector2D Loc = GetCurrentLevel().GetBossP().GetLocation();
                                    System.out.println("DEAD MONSTER");
                                    //set monster's health to 0
                                    GetCurrentLevel().GetReferee().GetMonster().SetHealth(0);
                                    //End the match with the referee
                                    GetCurrentLevel().GetReferee().EndMatch();
                                    //remove the monster in the ArrayList
                                    GetCurrentLevel().KillBoss();
                                    //Make the space in the level an empty entity space where the monster used to be
                                    GetCurrentLevel().GetLevel()[Loc.GetX()][Loc.GetY()] = new Entity();
                                }
                            }
                        }
                    }
        }
    }
}

/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     Weapon class is an Object inherited from Item that holds
 *     the properties of weapon functionality, damage, etc. Use
 *     to extend into different kind of weapons
 * </p>
 */
public class Weapon extends Item
{
    Pawn MyPawn;
    /**
     * MeleeDamage
     * MeleeDamageType object to give the weapon Melee Damage
     */
    MeleeDamageType MeleeDamage;

    /**
     * RangeDamage
     * RangeDamageType object to give the weapon Range Damage
     */
    RangeDamageType RangeDamage;

    /**
     * MaxDamage
     * integer value to cap the maximum damage of the weapon
     */
    private int MaxDamage;

    /**
     * HitChance
     * integer value to give the chance of the attack hitting or missing
     */
    private int HitChance;


    /**
     * bCanCriticalHit
     * private
     * Boolean that decides whether this weapon can make a
     * critical hit on Pawns
     */
    private boolean bCanCriticalHit;

    /**
     * Fire
     * Method that triggers the fire of the weapon
     */
    public void Fire(){}

    /**
     * CriticalHitChance
     * Method that calculates the random chance of making a
     * Critical hit on the Pawn
     */
    public void CriticalHitChance()
    {
        if(GetCanCriticalHit())
        {
            //LOGIC GOES HERE FOR CRITICAL HIT CALULATIONS
        }
    }

    /**
     * CanCriticalHit
     * Method that sets if the weapon will have any
     * chance to crit hit
     * @param Crit true or false assignment of bCanCriticalHit
     */
    public void CanCriticalHit(boolean Crit)
    {
        bCanCriticalHit = Crit;
    }

    /**
     * GetCanCriticalHit
     * Method that gets the bCanCriticalHit boolean value
     * @return bCanCriticalHit
     */
    public boolean GetCanCriticalHit()
    {
        return bCanCriticalHit;
    }

    /**
     * SetOwner
     * Method that sets the Owner of the weapon
     * @param Owner new Pawn that owns this weapon
     */
    public void SetOwner(Pawn Owner)
    {
        if(Owner != null)
        {
            MyPawn = Owner;
        }
    }

}

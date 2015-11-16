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
    /**
     * <b>MyPawn</b>
     * Pawn object to hold the owner of this weapon
     */
    Pawn MyPawn;

    /**
     * <b>MeleeDamage</b>
     * MeleeDamageType object to give the weapon Melee Damage
     */
    MeleeDamageType MeleeDamage;

    /**
     * <b>RangeDamage</b>
     * RangeDamageType object to give the weapon Range Damage
     */
    RangeDamageType RangeDamage;

    /**
     * <b>MaxDamage</b>
     * integer value to cap the maximum damage of the weapon
     */
    private int MaxDamage;

    /**
     * <b>HitChance</b>
     * integer value to give the chance of the attack hitting or missing
     */
    private int HitChance;


    /**
     * <b>bCanCriticalHit</b>
     * private
     * Boolean that decides whether this weapon can make a
     * critical hit on Pawns
     */
    private boolean bCanCriticalHit;

    /**
     * virtual from Item to fire weapon
     * reason is so Pawn can hold Items in the
     * Inventory ArrayList and trigger Use
     * @see Item
     */
    public void Use()
    {
        super.Use();
        Fire();
    }

    /**
     * <b>Fire</b>
     * Method that triggers the fire of the weapon
     */
    protected void Fire(){}

    /**
     * <b>CriticalHitChance</b>
     * Method that calculates the random chance of making a
     * Critical hit on the Pawn
     */
    protected void CriticalHitChance()
    {
        if(GetCanCriticalHit())
        {
            //LOGIC GOES HERE FOR CRITICAL HIT CALULATIONS
        }
    }

    /**
     * <b>CanCriticalHit</b>
     * Method that sets if the weapon will have any
     * chance to crit hit
     * @param Crit true or false assignment of bCanCriticalHit
     */
    public void CanCriticalHit(boolean Crit)
    {
        bCanCriticalHit = Crit;
    }

    /**
     * <b>GetCanCriticalHit</b>
     * Method that gets the bCanCriticalHit boolean value
     * @return bCanCriticalHit
     */
    public boolean GetCanCriticalHit()
    {
        return bCanCriticalHit;
    }

    /**
     * <b>SetOwner</b>
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

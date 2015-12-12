import java.util.Random;

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
     * <b>MeleeDamage</b>
     * <p>private</p>
     * MeleeDamageType object to give the weapon Melee Damage
     */
    private MeleeDamageType MeleeDamage;

    /**
     * <b>RangeDamage</b>
     * <p>private</p>
     * RangeDamageType object to give the weapon Range Damage
     */
    private RangeDamageType RangeDamage;

    /**
     * <b>MaxDamage</b>
     * <p>private</p>
     * integer value to cap the maximum damage of the weapon
     */
    private int MaxDamage;

    /**
     * <b>HitChance</b>
     * <p>private</p>
     * integer value to give the chance of the attack hitting or missing
     */
    private int HitChance;


    /**
     * <b>bCanCriticalHit</b>
     * <p>private</p>
     * Boolean that decides whether this weapon can make a
     * critical hit on Pawns
     */
    private boolean bCanCriticalHit;

    /**
     * virtual from Item to fire weapon
     * reason is so Pawn can hold Items in the
     * Inventory ArrayList and trigger Use
     * @see Entity
     */
    @Override
    public void Use()
    {
        super.Use();
    }

    /**
     * <b>CriticalHitChance</b>
     * Method that calculates the random chance of making a
     * Critical hit on the Pawn
     */

    //TODO: call for CriticalHitChance during battle
    protected void CriticalHitChance()
    {
        if(GetCanCriticalHit())
        {
            //Create Random object, assign tempCrit between 1 and 20.
            //Then give HitChange the value in INT form.
            Random random = new Random();
            int tempCrit = random.nextInt(20) + 1;

            HitChance = tempCrit;
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
     * GetMeleeDamage
     * returns the MeleeDamage object
     * @return MeleeDamage
     */
    public MeleeDamageType GetMeleeDamage()
    {
        return MeleeDamage;
    }

    /**
     * SetMeleeDamage
     * Method that Sets the MeleeDamage object class variables
     * @param Damage Amount of Damage to be applied when used
     * @param MagicPen Amount of MagicPenetration when used
     * @param ArmorPen Amount of ArmorPenetration when used
     */
    public void SetMeleeDamage(int Damage, int MagicPen, int ArmorPen)
    {
        MeleeDamage = new MeleeDamageType(Damage,MagicPen,ArmorPen);
    }

    /**
     * SetRangeDamage
     * Method that Sets the RangeDamage object variables
     * @param Range The distance the damage can be applied
     * @param Damage Amount of Damage when used
     * @param ArmorPen Amount of ArmorPenetration when used
     */
    public void SetRangeDamage(int Range,int Damage, int ArmorPen)
    {
        RangeDamage = new RangeDamageType(Range,Damage,ArmorPen);
    }

    /**
     * GetRangeDamage
     * returns the RangeDamage object
     * @return RangeDamage
     */
    public RangeDamageType GetRangeDamage()
    {
        return RangeDamage;
    }


    /**
     * <b>ApplyDamage</b>
     * Applies damage to pawn getting hit by weapon
     * @param DamagedPawn Pawn that is taking the Damage
     */
    public void ApplyDamage(Pawn DamagedPawn)
    {
        DamagedPawn.TakeDamage(GetMeleeDamage().GetDamageAmount(),GetOwner().GetController(),GetMeleeDamage());
    }

}

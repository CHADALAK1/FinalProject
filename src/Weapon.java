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
     * <b>GetCanCriticalHit</b>
     * Method that gets the bCanCriticalHit boolean value
     * @param min minimum range for crit
     * @param max maximum range for crit
     * @param crit the number the crit will initialize when random lands on it
     * @return bHasCrit
     */
    public boolean GetCanCriticalHit(int min, int max, int crit)
    {
        boolean bHasCrit;
        Random rand = new Random();
        int HitChance = rand.nextInt((max - min) + 1) + min;
        if(HitChance == crit)
        {
            bHasCrit = true;
        }
        else
        {
            bHasCrit = false;
        }
        return bHasCrit;
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
    public void SetMeleeDamage(int Damage, int MagicPen, int ArmorPen, boolean Rand)
    {
        MeleeDamage = new MeleeDamageType(Damage,MagicPen,ArmorPen,Rand);
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
        if(!MissChance(1,3,3))
        {
            //if this weapon has a crit chance
            if (GetCanCriticalHit(1, 10, 7))
            {
                DamagedPawn.TakeDamage(GetMeleeDamage().GetDamageAmount() * 2, GetOwner().GetController(), GetMeleeDamage());
                System.out.println(GetOwner().toString() + " HAS CRITTED");
            }
            //if no crit
            else
            {
                DamagedPawn.TakeDamage(GetMeleeDamage().GetDamageAmount(), GetOwner().GetController(), GetMeleeDamage());
            }
        }
        else
        {
            System.out.println(GetOwner().toString() + " MISSED...");
        }
    }

    public boolean MissChance(int min, int max, int miss)
    {
        boolean bHitChance;
        Random rand = new Random();
        int RandRange = rand.nextInt((max - min) + 1) + min;
        if(GetMeleeDamage().GetRandomChance())
        {
            if (RandRange == miss)
            {
                bHitChance = true;
            }
            else
            {
                bHitChance = false;
            }
        }
        else
        {
            bHitChance = false;
        }
        return bHitChance;
    }

}

/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     DamageType class is an object to debate on how the damage will take
 *     place depending on the armor and Magic Resist(depending if we implement).
 *     Reasoning behind this instead of using a base int damage amount is to make
 *     a variety for challenging ways to apply damage to the player or NPC's
 *     advantage or disadvantage.
 * </p>
 * <p>
 *     FOR EXAMPLE: if the player has armor on and the NPC hits the player with
 *     Melee. The player is going to receive less damage from the hit on the
 *     Melee attack because the armor helps resist the base damage from the
 *     Melee attack.
 * </p>
 */
public class DamageType
{
    /**
     * <b>int DamageAmount</b>
     * <p>private</p>
     * integer value of the amount of damage to be applied
     */
    private int DamageAmount;

    /**
     * <b>int ArmorPenetration</b>
     * <p>private</p>
     * amount of penetration to ignore Armor if applicable
     */
    private int ArmorPenetration;

    /**
     * <b>int MagicPenetration</b>
     * <p>private</p>
     * amount of penetration to ignore MagicResistance if applicable
     */
    private int MagicPenetration;

    /**
     * <b>boolean bRandomChance</b>
     * <p>private</p>
     * boolean value to check if this damage type has random chances of hitting or not
     */
    private boolean bRandomChance;

    /**
     * <b>int Range</b>
     * <p>private</p>
     * integer variable that holds the distance the damage can be fired
     */
    private int Range;

    /**
     * <b>SetDamageAmount</b>
     * Method that sets the DamageAmount value
     * @param Amount integer value parameter to set DamageAmount
     */
    public void SetDamageAmount(int Amount)
    {
        DamageAmount = Amount;
    }

    /**
     * <b>SetArmorPenetration</b>
     * Method that sets the ArmorPenetration value
     * @param Amount integer value parameter to set ArmorPenetration
     */
    public void SetArmorPenetration(int Amount)
    {
        ArmorPenetration = Amount;
    }

    /**
     * <b>SetMagicPenetration</b>
     * Method that sets the MagicPenetration value
     * @param Amount  integer value parameter to set MagicPenetration
     */
    public void SetMagicPenetration(int Amount)
    {
        MagicPenetration = Amount;
    }

    /**
     * <b>SetRange</b>
     * Method that sets the Range value
     * @param Amount integer value parameter to set Range
     */
    public void SetRange(int Amount)
    {
        Range = Amount;
    }

    /**
     * <b>SetRandomChance</b>
     * Method that sets whether this damage type has random chance or not
     * @param Chance to turn on or off random chance
     */
    public void SetRandomChance(boolean Chance)
    {
        bRandomChance = Chance;
    }

    /**
     * <b>GetDamageAmount</b>
     * gets the DamageAmount value
     * @return DamageAmount
     */
    public int GetDamageAmount()
    {
        return DamageAmount;
    }

    /**
     * <b>GetArmorPen</b>
     * gets the ArmorPenetration value
     * @return ArmorPenetration
     */
    public int GetArmorPen()
    {
        return ArmorPenetration;
    }

    /**
     * <b>GetMagicPen</b>
     * gets the MagicPenetration value
     * @return MagicPenetration
     */
    public int GetMagicPen()
    {
        return MagicPenetration;
    }

    /**
     * <b>GetRange</b>
     * gets the Range value
     * @return Range
     */
    public int GetRange()
    {
        return Range;
    }

    /**
     * <b>GetRandomChance</b>
     * returns the boolean bRandomChance
     * @return bRandomChance
     */
    public boolean GetRandomChance()
    {
        return bRandomChance;
    }
}

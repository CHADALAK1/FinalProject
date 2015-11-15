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
     * DamageAmount
     * integer value of the amount of damage to be applied
     */
    private int DamageAmount;

    /**
     * ArmorPenetration
     * amount of penetration to ignore Armor if applicable
     */
    private int ArmorPenetration;

    /**
     * MagicPenetration
     * amount of penetration to ignore MagicResistance if applicable
     */
    private int MagicPenetration;

    /**
     * SetDamageAmount
     * Method that sets the DamageAmount value
     * @param Amount integer value parameter to set DamageAmount
     */
    public void SetDamageAmount(int Amount)
    {
        DamageAmount = Amount;
    }

    /**
     * SetArmorPenetration
     * Method that sets the ArmorPenetration value
     * @param Amount integer value parameter to set ArmorPenetration
     */
    public void SetArmorPenetration(int Amount)
    {
        ArmorPenetration = Amount;
    }

    /**
     * SetMagicPenetration
     * Method taht sets the MagicPenetration value
     * @param Amount  integer value parameter to set MagicPenetration
     */
    public void SetMagicPenetration(int Amount)
    {
        MagicPenetration = Amount;
    }

    /**
     * GetDamageAmount
     * gets the DamageAmount value
     * @return DamageAmount
     */
    public int GetDamageAmount()
    {
        return DamageAmount;
    }

    /**
     * GetArmorPen
     * gets the ArmorPenetration value
     * @return ArmorPenetration
     */
    public int GetArmorPen()
    {
        return ArmorPenetration;
    }

    /**
     * GetMagicPen
     * gets the MagicPenetration value
     * @return MagicPenetration
     */
    public int GetMagicPen()
    {
        return MagicPenetration;
    }
}

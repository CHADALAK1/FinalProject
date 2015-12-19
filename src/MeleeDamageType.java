/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     MeleeDamageType class is an object inherited by DamageType to only apply
 *     melee damage to the Pawn.
 * </p>
 */
public class MeleeDamageType extends DamageType
{
    /**
     * Constructor
     * @param Damage How much damage the melee damage will be
     * @param MagicPen How much magic penetration will be applied
     * @param ArmorPen How much armor penetration will be applied
     * @param RandomChance will there be a random chance variable
     */
    MeleeDamageType(int Damage, int MagicPen, int ArmorPen, boolean RandomChance)
    {
        SetDamageAmount(Damage);
        SetMagicPenetration(MagicPen);
        SetArmorPenetration(ArmorPen);
        SetRandomChance(RandomChance);
    }
}

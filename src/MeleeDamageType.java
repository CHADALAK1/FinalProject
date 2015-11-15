/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     MeleeDamageType class is an object inherited by DamageType to only apply
 *     melee damage to the Pawn.
 * </p>
 */
public class MeleeDamageType extends DamageType
{
    MeleeDamageType(int Damage, int MagicPen, int ArmorPen)
    {
        SetDamageAmount(Damage);
        SetMagicPenetration(MagicPen);
        SetArmorPenetration(ArmorPen);
    }
}

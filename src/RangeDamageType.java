/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     RangeDamageType class is an object inherited from DamageType that handles
 *     the Range damage to the Pawn
 * </p>
 */
public class RangeDamageType extends DamageType
{
    RangeDamageType(int Range, int Damage, int ArmorPen)
    {
        SetRange(Range);
        SetDamageAmount(Damage);
        SetArmorPenetration(ArmorPen);
    }
}

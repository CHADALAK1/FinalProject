/**
 * Created by Chad Reddick on 11/17/15.
 * <p>
 *     Sword class is an object inherited from Weapon. This class
 *     can do damage to Pawns via MeleeDamageType. Not a Ranged weapon
 *     @see Weapon
 *     @see MeleeDamageType
 * </p>
 */
public class Sword extends Weapon
{
    public Sword()
    {
        SetMeleeDamage(10,0,5,false);
        SetName("Sword");
    }
}

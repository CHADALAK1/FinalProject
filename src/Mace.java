/**
 * Created by Chad Reddick on 12/17/15.
 *
 * <p>
 *     Mace is a class inherited from Weapon that has a Mace
 *     property type. Like a ball with spikes on a chain
 * </p>
 */
public class Mace extends Weapon
{
    public Mace()
    {
        SetMeleeDamage(15,0,5,true);
        SetName("Mace");
    }
}

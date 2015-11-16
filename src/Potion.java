/**
 * Created by Chad Reddick on 11/16/15.
 * <p>
 *     Potion class is an object inherited from Item. Class contains
 *     information on how to fill health and mana(mana WIP) when consumed
 * </p>
 */
public class Potion extends Item
{
    public void Use()
    {
        super.Use();
        GetOwner().AddHealth(10);
    }
}

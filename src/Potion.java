/**
 * Created by Chad Reddick on 11/16/15.
 * <p>
 *     Potion class is an object inherited from Item. Class contains
 *     information on how to fill health and mana(mana WIP) when consumed
 * </p>
 */
public class Potion extends Item
{
    public Potion()
    {
        SetCollision(true);
    }

    public void Use()
    {
        super.Use();
        GetOwner().AddHealth(10);
        for (int i = 0; i < GetOwner().GetInventory().size(); i++)
        {
            if (GetOwner().GetInventory().get(i) == this)
            {
                GetOwner().GetInventory().remove(i);
            }
        }
        System.out.println("Added 10 Health");
    }

    public void Pickup()
    {
        super.Pickup();
        System.out.println("PICKED UP A HEALTH POTION");
    }
}

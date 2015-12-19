/**
 * Created by Chad Reddick on 11/16/15.
 * <p>
 *     Potion class is an object inherited from Item. Class contains
 *     information on how to fill health and mana(mana WIP) when consumed
 * </p>
 */
public class Potion extends Item
{

    /**
     * Constructor
     * @param NewLevel Level this object is in
     * @param Loc Where the Potions location is
     */
    public Potion(Level NewLevel, Vector2D Loc)
    {
        SetCollision(true);
        SetCurrentLevel(NewLevel);
        SetLocation(Loc.GetX(),Loc.GetY());
    }

    @Override
    public void Use()
    {
        super.Use();
        GetOwner().AddHealth(50);
        for (int i = 0; i < GetOwner().GetInventory().size(); i++)
        {
            if (GetOwner().GetInventory().get(i) == this)
            {
                GetOwner().GetInventory().remove(i);
            }
        }
        System.out.println("Added 50 Health");
    }

    @Override
    public void Pickup()
    {
        super.Pickup();
        Use();
        System.out.println("PICKED UP A HEALTH POTION");
    }
}

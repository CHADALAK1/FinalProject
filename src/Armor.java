/**
 * Created by chadreddick on 12/6/15.
 */
public class Armor extends Item
{
    /**
     * Constructor
     * @param NewLevel Level this objects in
     * @param Loc Location the object is(reference when initialized in Level Object)
     */
    public Armor(Level NewLevel, Vector2D Loc)
    {
        SetCollision(true);
        SetCurrentLevel(NewLevel);
        SetLocation(Loc.GetX(),Loc.GetY());
        SetName("Armor");
    }

    @Override
    public void Use()
    {
        super.Use();
        GetOwner().AddArmor(25);
        for (int i = 0; i < GetOwner().GetInventory().size(); i++)
        {
            if (GetOwner().GetInventory().get(i) == this)
            {
                GetOwner().GetInventory().remove(i);
            }
        }
        System.out.println("Added 25 Armor");
    }

    @Override
    public void Pickup()
    {
        super.Pickup();
        Use();
    }
}

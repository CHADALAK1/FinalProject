/**
 * Created by chadreddick on 12/6/15.
 */
public class Armor extends Item
{
    /**public Armor()
    {
        SetCollision(false);
    }**/

    @Override
    public void Use()
    {
        super.Use();
        GetOwner().AddArmor(10);
        for (int i = 0; i < GetOwner().GetInventory().size(); i++)
        {
            if (GetOwner().GetInventory().get(i) == this)
            {
                GetOwner().GetInventory().remove(i);
            }
        }
        System.out.println("Added 10 Armor");
    }
}

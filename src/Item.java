/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     Item Class is an object that is the for The PlayerPawn class' inventory.
 *     Has the option to be used, dropped, and destroyed for the sake of
 *     being a base class for food, weapons, loot, etc.
 * </p>
 */
public class Item extends Entity
{
    /**
     * <b>MyPawn</b>
     * <p>private</p>
     * Pawn object to hold the owner of this weapon
     */
    private Pawn MyPawn;

    /**
     * <b>Pickup</b>
     * Method that picks up the Item
     * <p>Sets the Owner</p>
     * <p>Adds to Owner's Inventory</p>
     * <p>Removes from Level</p>
     */
    public void Pickup()
    {
        super.Pickup();
        SetOwner(GetCurrentLevel().GetPlayer());
        GetOwner().GetInventory().add(this);
        GetCurrentLevel().GetLevel()[GetLocation().GetX()][GetLocation().GetY()] = new Entity();
        System.out.println("You Picked up a " + GetName());
    }

    /**
     * <b>SetOwner</b>
     * Method that sets the Owner of the weapon
     * @param Owner new Pawn that owns this weapon
     */
    public void SetOwner(Pawn Owner)
    {
        if(Owner != null)
        {
            MyPawn = Owner;
        }
    }

    /**
     * <b><GetOwner/b>
     * Get method that returns MyPawn
     * @return MyPawn
     */
    public Pawn GetOwner()
    {
        return MyPawn;
    }
}

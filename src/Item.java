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
     * <b>Name</b>
     * private
     * String to give the Item a name
     */
    private String Name;

    /**
     * <b>Pickup</b>
     * Method that picks up the Item
     */
    public void Pickup(){}

    /**
     * <b>Use</b>
     * Method that uses the Item. Can override
     * this method to have weapon fire as well
     */
    public void Use(){}

    /**
     * <b>Drop</b>
     * Method that Drops the Item
     */
    public void Drop(){}
}

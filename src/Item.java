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
     * Name
     * private
     * String to give the Item a name
     */
    private String Name;

    /**
     * Pickup
     * Method that picks up the Item
     */
    public void Pickup(){}

    /**
     * Drop
     * Method that Drops the Item
     */
    public void Drop(){}
}

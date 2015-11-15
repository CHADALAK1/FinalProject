/**
 * Created by chadreddick on 11/15/15.
 */
public class Pawn
{
    /*
    int Health
    * private
    * Holds the Health value for the Pawn
    * Use the GetHealth() method to get the Health value
     */
    private int Health;

    /*
    int Armor
    * private
    * Holds the Armor value for the Pawn
    * Use the GetArmor() method to get the Armor value
     */
    private int Armor;

    /*
    boolean bIsDead
    * private
    * holds the boolean value to check if Pawn is dead
    * Use the IsDead() method to get the bIsDead boolean value
     */
    private boolean bIsDead;

    /*
    Move method
    * allows the pawn to move in directions according to the Level grid
     */
    public void Move(){}

    /*
    Interact Method
    * Allows the Pawn to interact with the world.
    */
    public void Interact(){}


    /*
    GetHealth
    * returns the integer value of Health
    */
    public int GetHealth()
    {
        return Health;
    }

    /*
    GetArmor
    * returns the integer value of Armor
    */
    public int GetArmor()
    {
        return Armor;
    }

    /*
    IsDead
    * returns the boolean value of bIsDead
    * essentially checks if the pawn is dead based on the Pawn's Health
    */
    public boolean IsDead()
    {
        if(Health <= 0)
        {
            bIsDead = true;
        }
        else
        {
            bIsDead = false;
        }
        return bIsDead;
    }
}

/**
 * Created by Chad Reddick on 11/15/15.
 * <p>
 *     Pawn Class is an object that the Controller Possesses. Think of this Object
 *     like a soul and a vessel. A <b>soul(Controller)</b> can only control something unless
 *     there is a <b>vessel(Pawn)</b> to possess. Each one cannot work without one another.
 * </p>
 */

public class Pawn extends Entity
{
    /**
    <b>int Health</b>
    * <p>private</p>
    * Holds the Health value for the Pawn
    * Use the GetHealth() method to get the Health value
     */
    private int Health;

    /**
    <b>int Armor</b>
    * <p>private</p>
    * Holds the Armor value for the Pawn
    * Use the GetArmor() method to get the Armor value
     */
    private int Armor;

    /**
     * <b>MagicResistance</b>
     * <p>private</p>
     * integer variable to debate how much MR(Magic Resistance) the Pawn has
     */
    private int MagicResistance;

    /**
    <b>boolean bIsDead</b>
    * <p>private</p>
    * holds the boolean value to check if Pawn is dead
    * Use the IsDead() method to get the bIsDead boolean value
     */
    private boolean bIsDead;

    /**
     * <b>ForwardVector</b>
     * <p>private</p>
     * Vector2D object that holds the vector location
     * where the Pawn is facing
     */
    private Vector2D ForwardVector;

    /**
     * <b>Direction</b>
     * <p>private</p>
     * Rotator enum holding where the player is facing
     */
    private Rotator Rotation;

    /**
    <b>Move</b>
    * Method that Allows the pawn to move in directions according to the Level grid
     * @param x Vector2D X coordinate
     * @param y Vector2D Y coordinate
     */
    public void Move(int x, int y)
    {
        //set new location of the Pawn
        SetLocation(x,y);

        //Store local variables for the Current forward vector x and y
        int CurrentX = GetForwardVector().GetX();
        int CurrentY = GetForwardVector().GetY();

        //DIRECTION CHECKS
        if(GetRotation() == Rotator.NORTH)
        {
            //TODO: Add Bounds check with current Level and room
            ForwardVector = new Vector2D(CurrentX,CurrentY-1);
        }
        if(GetRotation() == Rotator.SOUTH)
        {
            //TODO: Add Bounds check with current Level and room
            ForwardVector = new Vector2D(CurrentX,CurrentY+1);
        }
        if(GetRotation() == Rotator.EAST)
        {
            //TODO: Add Bounds check with current Level and room
            ForwardVector = new Vector2D(CurrentX+1,CurrentY);
        }
        if(GetRotation() == Rotator.WEST)
        {
            //TODO: Add Bounds check with current Level and room
            ForwardVector = new Vector2D(CurrentX-1,CurrentY-1);
        }
    }

    /**
     * Rotate
     * Method that sets teh Rotation Enum so the
     * Pawn can rotate
     * @param Dir Rotator Enum to change the direction
     */
    public void Rotate(Rotator Dir)
    {
        Rotation = Dir;
    }

    /**
    <b>Interact</b>
    * Method that Allows the Pawn to interact with the world.
    */
    public void Interact(){}


    /**
    <b>GetHealth</b>
    * @return the integer value of Health
    */
    public int GetHealth()
    {
        return Health;
    }

    /**
    <b>SetHealth</b>
    * Method that Sets the health of the Pawn
    * @param NewHealth  integer value parameter for the new health amount
    */
    public void SetHealth(int NewHealth)
    {
        if(NewHealth <= 100 && NewHealth > 0)
        {
            Health = NewHealth;
        }
        else
        {
            Health = 100;
        }
    }

    /**
    <b>AddHealth</b>
    * Method that Adds Health to the Pawn
    * @param AddedHealth  integer value parameter of how much health to add
    */
    public void AddHealth(int AddedHealth)
    {
        if((Health + AddedHealth) < 100)
        {
            Health += AddedHealth;
        }
        else
        {
            Health = 100;
        }
    }

    /**
     <b>SetArmor</b>
     * Method that Sets the new value for Armor
     * @param NewArmor  integer value for a new Armor amount
     */
    public void SetArmor(int NewArmor)
    {
        if(Armor <= 100 && Armor >= 0)
        {
            Armor = NewArmor;
        }
    }

    /**
     <b>AddArmor</b>
     * Method that Adds to the integer value of Armor
     * @param AddedArmor  integer value to add more to Armor
    */
    public void AddArmor(int AddedArmor)
    {
        if((Armor + AddedArmor) < 100)
        {
            Armor += AddedArmor;
        }
        else
        {
            Armor = 100;
        }
    }

    /**
     * <b>GetMagicResistance</b>
     * Method that gets the MagicResistance value
     * @return MagicResistance
     */
    public int GetMagicResistance()
    {
        return MagicResistance;
    }

    /**
     * <b>SetMagicResistance</b>
     * Method that sets the new MagicResistance value
     * @param NewMR  integer value parameter that sets the new MR value
     */
    public void SetMagicResistance(int NewMR)
    {
        MagicResistance = NewMR;
    }

    /**
     * <b>AddMagicResistance</b>
     * Method that adds to the MagicResistance value
     * @param AddedMR  integer value parameter that adds to MagicResistance
     */
    public void AddMagicResistance(int AddedMR)
    {
        MagicResistance += AddedMR;
    }


    /**
     * <b>DecreaseMagicResistance</b>
     * Method that decrements the MagicResistance value
     * @param DecrementedMR  integer value parameter to decrease the MagicResistance
     */
    public void DecreaseMagicResistance(int DecrementedMR)
    {
        if(MagicResistance > 0)
        {
            MagicResistance -= DecrementedMR;
        }
        else
        {
            MagicResistance = 0;
        }
    }

    /**
    <b>TakeDamage</b>
    * Method that is in charge of the damage application from another Pawn
    * @param Damage  integer value parameter for how much damage has been done
    * @param Instigator  Controller object parameter for "Who" applied the damage
     *@param TypeOfDamage  DamageType object parameter for how will the damage will be distributed
     *@see Controller  for info about controller fundamentals
     *@see DamageType  for DamageType concept
    */
    public void TakeDamage(int Damage, Controller Instigator, DamageType TypeOfDamage)
    {
        if(Health > 0)
        {
            if(Instigator != null)
            {

            }
            Health -= Damage;
        }
    }

    /**
    <b>GetArmor</b>
    * @return the integer value of Armor
    */
    public int GetArmor()
    {
        return Armor;
    }

    /**
     * Rotator
     * Method that returns the Rotation Enum
     * @return Rotation
     */
    public Rotator GetRotation()
    {
        return Rotation;
    }

    /**
     * GetForwardVector
     * Method that gets the ForwardVector Vector2D
     * @return ForwardVector
     */
    public Vector2D GetForwardVector()
    {
        return ForwardVector;
    }

    /**
    <b>IsDead</b>
    * essentially checks if the pawn is dead based on the Pawn's Health
    * @return the boolean value of bIsDead
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

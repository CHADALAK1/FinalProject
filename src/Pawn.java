import java.util.ArrayList;

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
    private boolean bIsDead = false;

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
     * <b>Inventory</b>
     * <p>private</p>
     * An ArrayList that holds Items the Pawn is currently holding
     */
    private ArrayList<Item> Inventory = new ArrayList<Item>();

    /**
     * <b>Hands</b>
     * <p>private</p>
     * A Weapon object that holds what Weapon the Pawn is holding
     */
    private ArrayList<Weapon> Hand = new ArrayList<Weapon>();

    /**
     * <b>PawnController</b>
     * <p>private</p>
     * A Controller object that holds the Controller Possessing this pawn(if any)
     */
    private Controller PawnController;

    /**
    <b>MoveUp</b>
    * Method that Allows the pawn to move <b>UP</b> in the level grid
     */
    public void MoveUp()
    {
        int CurrXLocation = GetCurrentLevel().GetPlayerLocation().GetX();
        int CurrYLocation = GetCurrentLevel().GetPlayerLocation().GetY();
        if (GetRotation() == Rotator.NORTH)
        {
            if (GetForwardVector().GetY() > 0 ||
                    !GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()].GetHasCollision())
            {
                //set new location of the Pawn
                GetCurrentLevel().SetPlayerLocation(new Vector2D(CurrXLocation, CurrYLocation - 1));

                SetForwardVector(new Vector2D(GetForwardVector().GetX(), GetForwardVector().GetY() - 1));
            }
        }
        else
        {
            Rotation = Rotator.NORTH;
            SetForwardVector(new Vector2D(CurrXLocation,CurrYLocation - 1));
        }

        //DEBUG
        System.out.println("X: " + GetLocation().GetX() + "and Y: " + GetLocation().GetY());
    }

    /**
     <b>MoveDown</b>
     * Method that Allows the pawn to move <b>DOWN</b> in the level grid
     */
    public void MoveDown()
    {
        int CurrXLocation = GetCurrentLevel().GetPlayerLocation().GetX();
        int CurrYLocation = GetCurrentLevel().GetPlayerLocation().GetY();
        if (GetRotation() == Rotator.SOUTH)
        {
            if(GetForwardVector().GetY() < GetCurrentLevel().GetMaxBoundaries().GetY() ||
                    !GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()].GetHasCollision())
            {
                GetCurrentLevel().SetPlayerLocation(new Vector2D(CurrXLocation, CurrYLocation + 1));
                SetForwardVector(new Vector2D(GetForwardVector().GetX(), GetForwardVector().GetY() + 1));
            }
        }
        else
        {
            Rotation = Rotator.SOUTH;
            SetForwardVector(new Vector2D(CurrXLocation, CurrYLocation + 1));
        }

        //DEBUG
        System.out.println("X: " + GetLocation().GetX() + "and Y: " + GetLocation().GetY());
    }

    /**
     <b>MoveRight</b>
     * Method that Allows the pawn to move <b>RIGHT | East</b> in the level grid
     */
    public void MoveRight()
    {
        int CurrXLocation = GetCurrentLevel().GetPlayerLocation().GetX();
        int CurrYLocation = GetCurrentLevel().GetPlayerLocation().GetY();
        if (GetRotation() == Rotator.EAST)
        {
            if(GetForwardVector().GetX() < GetCurrentLevel().GetMaxBoundaries().GetX() ||
                    !GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()].GetHasCollision())
            {
                GetCurrentLevel().SetPlayerLocation(new Vector2D(CurrXLocation + 1, CurrYLocation));
                SetForwardVector(new Vector2D(GetForwardVector().GetX() + 1, GetForwardVector().GetY())) ;
            }
        }
        else
        {
            Rotation = Rotator.EAST;
            SetForwardVector(new Vector2D(CurrXLocation + 1, CurrYLocation));
        }

        //DEBUG
        System.out.println("X: " + GetLocation().GetX() + "and Y: " + GetLocation().GetY());
    }

    /**
     <b>MoveLeft</b>
     * Method that Allows the pawn to move <b>LEFT | West</b> in the level grid
     */
    public void MoveLeft()
    {
        int CurrXLocation = GetCurrentLevel().GetPlayerLocation().GetX();
        int CurrYLocation = GetCurrentLevel().GetPlayerLocation().GetY();
        if(GetRotation() == Rotator.WEST)
        {
            if(GetForwardVector().GetX() > 0 ||
                    !GetCurrentLevel().GetLevel()[GetForwardVector().GetX()][GetForwardVector().GetY()].GetHasCollision())
            {
                GetCurrentLevel().SetPlayerLocation(new Vector2D(CurrXLocation - 1, CurrYLocation));
                SetForwardVector(new Vector2D(GetForwardVector().GetX() - 1, GetForwardVector().GetY()));
            }
            else
            {
                System.out.println("CANNOT MOVE FOOL!");
            }
        }
        else
        {
            Rotation = Rotator.WEST;
            SetForwardVector(new Vector2D(CurrXLocation - 1, CurrYLocation));
        }

        //DEBUG
        System.out.println("X: " + GetLocation().GetX() + "and Y: " + GetLocation().GetY());
    }

    /**
     * Rotate
     * Method that sets the Rotation Enum so the
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

    public void InteractBattle(int WeapSlot){}

    /**
     * <b>GetController</b>
     * returns the PawnController object
     * @return PawnController
     */
    public Controller GetController()
    {
        return PawnController;
    }

    /**
     * <b>SetController</b>
     * Sets the Controller Possessing this Pawn
     * @param Possesser The Controller Possessing the Pawn
     */
    public void SetController(Controller Possesser)
    {
        PawnController = Possesser;
    }


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
        //if we know who's attacking this pawn
        if(Instigator != null)
        {
            System.out.println(GetController().toString() + " Health is now " + GetHealth());
            //if pawn still has armor
            if (GetArmor() > 0)
            {
                //if the damage being applied still is greater than 0
                if((GetArmor() - Damage) > 0)
                {
                    //deplete armor(with math to the ArmorPenetration)
                    Armor -= (Damage + TypeOfDamage.GetArmorPen());
                }
                //if less than 0
                else
                {
                    //no more armor left
                    Armor = 0;
                }
            }
            //if pawn still has Health
            else if(GetHealth() > 0)
            {
                //if the damage being applied still is greater than 0
                if((GetHealth() - Damage) > 0)
                {
                    //deplete Health
                    Health -= Damage;
                }
                //if less than 0
                else
                {
                    //no more health left
                    Health = 0;
                }

            }
            else
            {
                //ensure this pawn is dead
                SetIsDead(true);
            }
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
     * <b>SetForwardVector</b>
     * Sets the Vector2D Location in front of the Pawn
     * @param NewVector2D Vector2D to become the new ForwardVector
     */
    public void SetForwardVector(Vector2D NewVector2D)
    {
        ForwardVector = NewVector2D;
    }

    /**
     * <b>GetInventory</b>
     * returns the ArrayList of Items called Inventory
     * @return Inventory
     */
    public ArrayList<Item> GetInventory()
    {
        return Inventory;
    }

    /**
     * <b>GetWeapon</b>
     * returns the Hand object which holds what weapon is there or not
     * @return Hand
     */
    public ArrayList<Weapon> GetWeapon()
    {
        return Hand;
    }

    /**
     * <b>SetWeapon</b>
     * Puts the Weapon into the Player's Hand(Can Also Remove from hand
     * @param NewWeapon Weapon to put into Pawn's hand
     */
    public void SetWeapon(Weapon NewWeapon)
    {
        Hand.add(NewWeapon);
        NewWeapon.SetOwner(this);
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

    /**
     * <b>SetIsDead</b>
     * Sets this pawn Dead or Alive
     * @param IsAlive sets the boolean bIsDead true or false
     */
    public void SetIsDead(boolean IsAlive)
    {
        bIsDead = IsAlive;
    }

}

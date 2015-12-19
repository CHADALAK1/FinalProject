/**
 * Created by Chad Reddick on 11/16/15.
 * <p>
 *     Key class is an object inherited from Item. This
 *     class is used to open barricades or doors needed to
 *     open.
 * </p>
 */
public class Key extends Item
{
    /**
     * Constructor
     * @param NewLevel Level this key is in
     * @param KeyName Name of the Key
     */
    public Key(Level NewLevel,Vector2D Loc, String KeyName)
    {
        SetLocation(Loc.GetX(), Loc.GetY());
        SetCurrentLevel(NewLevel);
        SetName(KeyName);
    }

    @Override
    public void Use()
    {
        super.Use();
    }

}

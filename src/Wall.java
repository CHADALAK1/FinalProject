/**
 * Created by Chad Reddick on 11/23/15.
 * <p>
 *     Wall class is an object inherited from Entity that only holds
 *     block collision information. Essentially tells the pawn they cannot
 *     go past this barrier
 *     @see Entity for more info on Collision
 *     @see Level for initialization in the <b>SetBounds()</b> Method
 * </p>
 */
public class Wall extends Entity
{
    public Wall()
    {
        SetCollision(true);
    }
}

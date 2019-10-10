/**
 *File Name: Square
 *@version 1.1
 *Created On: 02-03-2019
 *@since 02-03-2019
 *@author Chester Descallar 978050
 *Copyright: No Copyright
 *Purpose: This class is the square shape that can be drawn to the screen (subclass of ClosedShape)
 *Version History - version 1.0 - downloaded code, version 1.1 - edited code
 */

import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;


/**
 *
 * Square is a square shape that can be drawn to the screen, either
 * filled with colour or opaque.
 */

public class Square extends ClosedShape
{

    private int side;  //The sides of the square
    private boolean reverse = true; //Determines whether to grow the shape or shrink it
    private int maxSide, initialSide; //The maximum and initial shape that the square can grow or shrink into

    /**
     * Creates a square.
     * @param insertionTime When the square will be inserted
     * @param pulse Whether the circle pulses or not
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side  The sides of the square (in pixels)
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     */
    public Square(int insertionTime,  boolean pulse, int x, int y, int vx, int vy, int side,
                  Color colour, boolean isFilled)
    {
        super(insertionTime, pulse, x, y, vx, vy, colour, isFilled);
        this.side = side;
        this.maxSide = side + 100;
        this.initialSide = side;
    }

    /**
     * Method to convert the square to string
     * @return Returns result which contains the string of all values
     */

    public String toString ()
    {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * Sets the side of the square
     * @param side
     */

    public void setSide(int side)
    {
        this.side = side;
    }

    /**
     * Gets the side of the square
     * @return
     */

    public int getSide()
    {
        return side;
    }

    /**
     * Gets the width (which is the side to override the method in the superclass ClosedShape)
     * @return The side of the square
     */
    @Override
    public int getWidth()
    {
        return side;
    }

    /**
     * Gets the height (which is the side to override the method in the superclass ClosedShape)
     * @return The side of the square
     */
    @Override
    public int getHeight()
    {
        return side;
    }

    /**
     * Draws the square
     * @param g The graphics object associated with the drawing component.
     */

    public void draw (GraphicsContext g)
    {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled)
        {
            g.fillRect( x, y, side, side );
        }
        else
            {
            g.strokeRect( x, y, side, side );
        }
    }

    /**
     * Pulses the shape
     */
    public void pulseShape()
    {
        //Checks if the input is true or false -> if it is true, make the shape pulse
        if (this.isPulse)
        {
            //Makes the shape grow
            if (reverse)
            {
                //Checks if the current diameter of the shape is equal to the max diameter, if isn't keep growing
                //until it is
                if ((side != maxSide))
                {
                    side++;
                    if(side == maxSide)
                    {
                        reverse = false;
                    }
                }
            }
            //Makes the shape shrink
            if (!reverse)
            {
                //Checks if the current diameter of the shape is equal to the initial diameter, if isn't keep shrinking
                //until it is
                if (side != initialSide)
                {
                    side--;
                    if (side == initialSide)
                    {
                        reverse = true;
                    }
                }
            }

        }
    }

}

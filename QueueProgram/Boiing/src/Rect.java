/**
 *File Name: Rect
 *@version 1.1
 *Created On: 02-03-2019
 *@since 02-03-2019
 *@author Chester Descallar 978050
 *Copyright: No Copyright
 *Purpose: This class is the rectangle shape that can be drawn to the screen (subclass of ClosedShape)
 *Version History - version 1.0 - downloaded code, version 1.1 - edited code
 */
import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Rect is a rectangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 */

public class Rect extends ClosedShape
{

    private int width, height;//The height and width of the rectangle
    private boolean reverse = true; //Determines whether to grow the shape or shrink it
    private int maxWidth, maxHeight; //The maximum height and width that the image can grow or shrink into
    private int initialWidth, initialHeight; //The initial height and width that the image can grow or shrink into

    /**
     * Creates a rectangle.
     * @param insertionTime When the rectangle will be inserted
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle (in pixels)
     * @param height The height of the rectangle (in pixels)
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     */
    public Rect(int insertionTime, boolean pulse, int x, int y, int vx, int vy, int width, int height,
                Color colour, boolean isFilled)
    {
        super(insertionTime,pulse, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
        this.maxHeight = height + 100;
        this.maxWidth = width + 100;
        this.initialHeight = height;
        this.initialWidth = width;
    }
/**
 * Method to convert the rectangle to string
 * @return Returns result which contains the string of all values
 */


    public String toString ()
    {
        String result = "This is a rectangle\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }


    /**
     * Sets the width of the rectangle
     * @param width Resets the width.
     */
    public void setWidth (int width)
    {
        this.width = width;
    }

    /**
     * Sets the height of the rectangle
     * @param height Resets the height.
     */
    public void setHeight (int height)
    {
        this.height = height;
    }

    /**
     *  Gets the width of the rectangle (overrides the method in the superclass ClosedShape)
     * @return The width of the rectangle.
     */
    @Override
    public int getWidth()
    {
        return width;
    }

    /**
     * Gets the height of the rectangle (overrides the method in the superclass ClosedShape)
     * @return The height of the rectangle.
     */
    @Override
    public int getHeight()
    {
        return height;
    }

    /**
     * Draws the rectangle
     * @param g The graphics object associated with the drawing component.
     */

    public void draw (GraphicsContext g)
    {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled)
        {
            g.fillRect( x, y, width, height );
        }
        else
            {
            g.strokeRect( x, y, width, height );
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
                if ((height != maxHeight) && (width != maxWidth))
                {
                    height++;
                    width++;
                    if((height == maxHeight) && (width == maxWidth))
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
                if ((height != initialHeight) && (width != initialWidth))
                {
                    height--;
                    width--;
                    if ((height == initialHeight) && (width == initialWidth))
                    {
                        reverse = true;
                    }
                }
            }

        }
    }

}

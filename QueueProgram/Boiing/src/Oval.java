/**
 *File Name: Oval
 *@version 1.1
 *Created On: 02-03-2019
 *@since 02-03-2019
 *@author Chester Descallar 978050
 *Copyright: No Copyright
 *Purpose: This class is the oval shape that can be drawn to the screen (subclass of ClosedShape)
 *Version History - version 1.0 - downloaded code, version 1.1 - edited code
 */

/**
 * Oval.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Oval is an oval shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * oval's bounding rectangle
 */
public class Oval extends ClosedShape
{

    private int width, height;  //The width and height of the oval (major and minor axis)
    private boolean reverse = true; //Determines whether to grow the shape or shrink it
    private int maxWidth, maxHeight; //The maximum height and width that the text can grow or shrink into
    private int initialWidth, initialHeight; //The initial height and width that the text can grow or shrink into

    /**
     * Creates an oval.
     * @param insertionTime When the oval will be inserted
     * @param pulse Whether the oval pulses or not
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the oval (in pixels).
     * @param height The height of the oval (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the oval is filled with colour, false if opaque.
     */
    public Oval (int insertionTime, boolean pulse, int x, int y, int vx, int vy,
                 int width, int height, Color colour, boolean isFilled)
    {
        super (insertionTime, pulse, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
        this.maxHeight = height + 100;
        this.maxWidth = width + 100;
        this.initialHeight = height;
        this.initialWidth = width;
    }

    /**
     * Method to convert an oval to a string.
     */
    public String toString ()
    {
        String result = "This is an oval\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * @param width Resets the width.
     */
    public void setWidth (int width)
    {
        this.width = width;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight (int height)
    {
        this.height = height;
    }

    /**
     * @return The width of the oval.
     */
    @Override
    public int getWidth()
    {
        return width;
    }

    /**
     * @return The height of the oval.
     */
    @Override
    public int getHeight()
    {
        return height;
    }

    /**
     * Draw the oval.
     * @param g The graphics object of the drawable component.
     */

    public void draw (GraphicsContext g)
    {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillOval( x, y, width, height );
        }
        else {
            g.strokeOval( x, y, width, height );
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

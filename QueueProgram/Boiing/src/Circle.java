/**
 *File Name: Circle
 *@version 1.1
 *Created On: 02-03-2019
 *@since 02-03-2019
 *@author Chester Descallar 978050
 *Copyright: No Copyright
 *Purpose: This class is the circle shape that can be drawn to the screen (subclass of ClosedShape)
 *Version History - version 1.0 - downloaded code, version 1.1 - edited code
 */


/**
 * Circle.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of
 * CSC-115 (Daniel Archambault and Liam O’Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Circle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the circle's bounding rectangle.
 */

public class Circle extends ClosedShape
{

    private int diameter; //The diameter of the circle
    private boolean reverse = true; //Determines whether to grow the shape or shrink it
    private int maxDiameter,initialDiameter;  //The maximum and initial shape that the circle can grow or shrink into


    /**
     * Creates a circle.
     * @param insertionTime  When the circle will be inserted
     * @param pulse  Whether the circle pulses or not
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param diameter The diameter of the circle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     */
    public Circle (int insertionTime, boolean pulse, int x, int y, int vx, int vy,
                   int diameter, Color colour, boolean isFilled)
    {
        super (insertionTime, pulse, x, y, vx, vy, colour, isFilled);
        this.diameter = diameter;
        this.maxDiameter = diameter + 100;
        this.initialDiameter = diameter;

    }

    /**
     * Method to convert a circle to a string.
     */
    public String toString ()
    {
        String result = "This is a circle\n";
        result += super.toString ();
        result += "Its diameter is " + this.diameter + "\n";
        return result;
    }

    /**
     * @param diameter the diameter.
     */
    public void setDiameter (int diameter)
    {
        this.diameter = diameter;
    }

    /**
     * @return The diameter of the circle.
     */
    public int getDiameter()
    {
        return diameter;
    }

    /**
     * @return The width of the circle
     */
    @Override
    public int getWidth()
    {
        return diameter;
    }

    /**
     * @return The height of the circle
     */
    @Override
    public int getHeight()
    {
        return diameter;
    }

    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the scene component.
     */

    public void draw (GraphicsContext g)
    {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled)
        {
            g.fillOval( x, y, diameter, diameter );
        }
        else
            {
            g.strokeOval( x, y, diameter, diameter );
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
                if ((diameter != maxDiameter))
                {
                    diameter++;
                    if(diameter == maxDiameter)
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
                if (diameter != initialDiameter)
                {
                    diameter--;
                    if (diameter == initialDiameter)
                    {
                        reverse = true;
                    }
                }
            }

        }
    }
}

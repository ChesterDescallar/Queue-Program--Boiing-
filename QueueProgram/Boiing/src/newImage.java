/**
 *File Name: newImage
 *@version 1.1
 *Created On: 02-03-2019
 *@since 02-03-2019
 *@author Chester Descallar 978050
 *Copyright: No Copyright
 *Purpose: This class is the image shape that can be drawn to the screen (subclass of ClosedShape)
 *Version History - version 1.0 - downloaded code, version 1.1 - edited code
 */

import java.util.*;

import com.sun.corba.se.spi.orbutil.closure.Closure;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import sun.awt.windows.WingDings;
/**
 * newImage is an image that can be drawn to the screen
 */
public class newImage extends ClosedShape
{

    private Image image; //The image that will be displayed to the screen
    private int width, height; // The height and width that the image will be displayed in
    private boolean reverse = true; //Determines whether to grow the shape or shrink it
    private int maxWidth, maxHeight; //The maximum height and width that the image can grow or shrink into
    private int initialWidth, initialHeight; //The initial height and width that the image can grow or shrink into

    /**
     * Creates an image
     * @param insertionTime When the image will be inserted
     * @param pulse Whether the image pulses or not
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param image The image that will be displayed to the screen
     * @param width The width of the image (in pixels)
     * @param height The height of the image (in pixels)
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     */

    public newImage(int insertionTime, boolean pulse, int x, int y, int vx, int vy,
                    Image image, int width, int height, Color colour, boolean isFilled)
    {
        super(insertionTime,pulse, x, y,vx,vy,colour, isFilled);
        this.image = image;
        this.width = width;
        this.height =height;
        this.maxHeight = height + 75;
        this.maxWidth = width + 75;
        this.initialHeight = height;
        this.initialWidth = width;
    }

    /**
     * Converts the Image to string
     * @return Returns result which contains the string of all values
     */
    public String toString ()
    {
        String result = "This is an a string\n";
        result += super.toString ();
        result += "It is an image of " + this.image + "\n";
        return result;
    }

    /**
     * Gets the image
     * @return The image
     */
    public Image getImage()
    {
        return image;
    }


    /**
     * Gets the width of the image (overrides the method in the superclass ClosedShape)
     * @return The width of the image
     */
    @Override
    public int getWidth()
    {
        return width;
    }

    /**
     * Gets the height of the image (overrides the method in the superclass ClosedShape)
     * @return The height of the image
     */
    @Override
    public int getHeight()
    {
        return height;
    }

    /**
     * Draws the image
     * @param g The graphics object associated with the drawing component.
     */
    public void draw (GraphicsContext g)
    {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled)
        {
            g.drawImage( image, x, y, width, height);
        }
        else
            {
            g.drawImage( image, x, y, width, height);
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

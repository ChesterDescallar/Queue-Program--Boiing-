/**
 *File Name: ReadShapeFile
 *@version 1.1
 *Created On: 02-03-2019
 *@since 02-03-2019
 *@author Chester Descallar 978050
 *Copyright: No Copyright
 *Purpose: This class reads a shape file.
 *Version History - version 1.0 - downloaded code, version 1.1 - edited code
 */

/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javafx.*;

public class ReadShapeFile
{

    // TODO: You will likely need to write four methods here. One method to
    // construct each shape
    // given the Scanner passed as a parameter. I would suggest static
    // methods in this case.

    /**
     * Creates the circle
     * @param in is the file that is being inputted
     * @return the circle
     */
    private static Circle makeCircle(Scanner in)
    {

        boolean pulse = in.nextBoolean();
        int px = in.nextInt();
        int py = in.nextInt();
        int vx = in.nextInt();
        int vy = in.nextInt();
        boolean filled = in.nextBoolean();
        int diameter = in.nextInt();
        int r = in.nextInt();
        int g = in.nextInt();
        int b = in.nextInt();
        int insertionTime = in.nextInt();
        Color newColour = Color.rgb(r,g,b);


        Circle newCircle = new Circle(insertionTime,pulse,px,py,vx,vy,diameter, newColour,filled);

        return newCircle;
    }

    /**
     * Creates the oval
     * @param in is the file that is being inputted
     * @return the oval
     */

    private static Oval makeOval(Scanner in)
    {

        boolean pulse = in.nextBoolean();
        int px = in.nextInt();
        int py = in.nextInt();
        int vx = in.nextInt();
        int vy = in.nextInt();
        boolean filled = in.nextBoolean();
        int width = in.nextInt();
        int height = in.nextInt();
        int r = in.nextInt();
        int g = in.nextInt();
        int b = in.nextInt();
        int insertionTime = in.nextInt();
        Color newColour = Color.rgb(r,g,b);

        Oval newOval = new Oval(insertionTime,pulse,px,py,vx,vy,width,height,newColour,filled);

        return newOval;
    }


    /**
     * Creates the square
     * @param in is the file that is being inputted
     * @return the square
     */
    private static Square makeSquare(Scanner in)
    {

        boolean pulse = in.nextBoolean();
        int px = in.nextInt();
        int py = in.nextInt();
        int vx = in.nextInt();
        int vy = in.nextInt();
        boolean filled = in.nextBoolean();
        int side = in.nextInt();
        int r = in.nextInt();
        int g = in.nextInt();
        int b = in.nextInt();
        int insertionTime = in.nextInt();

        Color newColour = Color.rgb(r,g,b);

        Square newSquare = new Square(insertionTime,pulse,px,py,vx,vy,side,newColour,filled);



        return newSquare;

    }

    /**
     * Creates the rectangle
     * @param in is the file that is being inputted
     * @return the rectangle
     */

    private static Rect makeRect(Scanner in)
    {

        boolean pulse = in.nextBoolean();
        int px = in.nextInt();
        int py = in.nextInt();
        int vx = in.nextInt();
        int vy = in.nextInt();
        boolean filled = in.nextBoolean();
        int width = in.nextInt();
        int height = in.nextInt();
        int r = in.nextInt();
        int g = in.nextInt();
        int b = in.nextInt();
        int insertionTime = in.nextInt();

        Color newColour = Color.rgb(r,g,b);


        Rect newRect = new Rect(insertionTime,pulse,px,py,vx,vy,width,height,newColour,filled);

        return newRect;


    }


    /**
     * Creates the text
     * @param in is the file that is being inputted
     * @return the text
     */
    private static newText makeText(Scanner in)
    {

        boolean pulse = in.nextBoolean();
        String text = in.next();
        int maxWidth = in.nextInt();
        int maxHeight = in.nextInt();
        int px = in.nextInt();
        int py = in.nextInt();
        int vx = in.nextInt();
        int vy = in.nextInt();
        boolean filled = in.nextBoolean();
        int r = in.nextInt();
        int g = in.nextInt();
        int b = in.nextInt();
        int insertionTime = in.nextInt();

        Color newColour = Color.rgb(r,g,b);


        newText newText = new newText(insertionTime,pulse,px,py,vx,vy,text,maxWidth, maxHeight, newColour,filled);

        return newText;


    }

    /**
     * Creates the image
     * @param in is the file that is being inputted
     * @return the image
     */
    private static newImage makeImage(Scanner in)
    {

        boolean pulse = in.nextBoolean();
        String imageText = in.next();
        Image image1 = new Image(imageText);
        int maxWidth = in.nextInt();
        int maxHeight = in.nextInt();
        int px = in.nextInt();
        int py = in.nextInt();
        int vx = in.nextInt();
        int vy = in.nextInt();
        boolean filled = in.nextBoolean();
        int r = in.nextInt();
        int g = in.nextInt();
        int b = in.nextInt();
        int insertionTime = in.nextInt();

        Color newColour = Color.rgb(r,g,b);


        newImage newImage = new newImage(insertionTime,pulse,px,py,vx,vy,image1,maxWidth, maxHeight, newColour,filled);

        return newImage;


    }




    /**
     * Reads the data file used by the program and returns the constructed queue
     *
     * @param in
     *            the scanner of the file
     * @return the queue represented by the data file
     */
    private static Queue<ClosedShape> readDataFile(Scanner in)
    {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();


        //read in the shape files and place them on the Queue
        while (in.hasNextLine())
        {
            String shapeLine = in.nextLine();
            Scanner newShape = new Scanner(shapeLine);
            String compare = newShape.next();
            if (compare.equalsIgnoreCase("circle"))
            {
                shapeQueue.enqueue(makeCircle(newShape));
            }
            else if(compare.equalsIgnoreCase("oval"))
            {
                shapeQueue.enqueue(makeOval(newShape));
            }
            else if(compare.equalsIgnoreCase("square"))
            {
                shapeQueue.enqueue(makeSquare(newShape));
            }
            else if(compare.equalsIgnoreCase("rect"))
            {
                shapeQueue.enqueue(makeRect(newShape));
            }
            else if(compare.equalsIgnoreCase("text"))
            {
                shapeQueue.enqueue(makeText(newShape));
            }
            else if(compare.equalsIgnoreCase("image"))
            {
                shapeQueue.enqueue(makeImage(newShape));
            }
            else
            {
                System.out.println("Shape not found.\n");
            }
            newShape.close();
        }


        shapeQueue.print();

        //Right now, returning an empty Queue.  You need to change this.
        return shapeQueue;
    }




    /**
     * Method to read the file and return a queue of shapes from this file. The
     * program should handle the file not found exception here and shut down the
     * program gracefully.
     *
     * @param filename
     *            the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue<ClosedShape> readDataFile(String filename)
    {
        File inputFile = new File(filename);// HINT: You might want to open a file here.
        Scanner in = null; //null is not sensible. Please change

        try
        {
          in = new Scanner(inputFile);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot find " + filename);
            System.exit(0);
        }


        return ReadShapeFile.readDataFile(in);



    }
}

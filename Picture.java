import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  /**
   * Method to set pixel's red values to 255
   */
  public void maxRed()
{
  Pixel[][] pixels = this.getPixels2D();
  for (Pixel[] rowArray : pixels)
  {
    for (Pixel pixelObj : rowArray)
    {
      pixelObj.setRed(255);
    }
  }
}


  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }

  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setBlue(255-pixelObj.getBlue());
      }
    }
  }

  /**
   * Method that turns the image to greyscale (grey)
   */
  public void greyscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int average = (pixelObj.getBlue()+pixelObj.getGreen()+pixelObj.getRed())/3;
        pixelObj.setRed(average);
        pixelObj.setGreen(average);
        pixelObj.setBlue(average);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }

  /**
   * method to mirror arms of a snowman
   */
  public void mirrorArms()
  {
    int mirrorPoint = 296;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 150; row < 220; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 200; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  /**
   * Method to copy the right side of the image to the left
   */
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  /**
   * Method to flip the image from left to right
   */
  public void flipLeftToRight()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Color rightPixelColor;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixelColor = rightPixel.getColor();
        rightPixel.setColor(leftPixel.getColor());
        leftPixel.setColor(rightPixelColor);
      }
    }
  }

  /**
   * Method to flip the image up to down
   */
  public void flipUpToDown()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Color bottomPixelColor;
    int length = pixels.length;
    for (int row = 0; row < length/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[length-row-1][col];
        bottomPixelColor = bottomPixel.getColor();
        bottomPixel.setColor(topPixel.getColor());
        topPixel.setColor(bottomPixelColor);
      }
    }
  }

  /**
   * Method to copy the image from top to bottom.
   */
  public void mirrorHorizontalTopToBottom()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int length = pixels.length;
    for (int row = 0; row < length/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[length-row-1][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  /**
   * Method to copy the image from bottom to top.
   */
  public void mirrorHorizontalBottomToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int length = pixels.length;
    for (int row = 0; row < length/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[length-row-1][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    }
  }

  /**
   * @param color1 Color for range 1
   * @param color2 Color for range 2
   * @param color3 Color for range 3
   * @param color4 Color for range 4
   * @param image  Source image
   *
   * Finds biggest and smallest values. Divides the range of values into 4. Loops through image, changing pixels accordingly.
   *
   *
   *
   */
  public void shepardFairey(Picture image,Color color1, Color color2, Color color3, Color color4){
    int smallest;
    int biggest;
    int width = image.getWidth();
    int height = image.getHeight();
    Pixel pixel2 = image.getPixel(0, 0);
    smallest = pixel2.getBlue();
    biggest = pixel2.getBlue();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel pixel1 = image.getPixel(x, y);
        if(pixel1.getBlue() > biggest){
          biggest = pixel1.getBlue();

        }
        else if(pixel1.getBlue() < smallest){
          smallest = pixel1.getBlue();

        }
      }
    }

    //divide into 4 ranges
    int range = biggest-smallest;
    range /= 4; //how long each range is
    int range1 = range;
    int range2 = range*2;//ending value
    int range3 = range*3;

    //interate through the pixels, changing colors

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel pixel = image.getPixel(x, y);
        if(pixel.getBlue() <= range1){
          pixel.setBlue(color1.getBlue());
          pixel.setRed(color1.getRed());
          pixel.setGreen(color1.getGreen());
        }
        else if(pixel.getBlue() <= range2){
          pixel.setBlue(color2.getBlue());
          pixel.setRed(color2.getRed());
          pixel.setGreen(color2.getGreen());
        }
        else if(pixel.getBlue() <= range3){
          pixel.setBlue(color3.getBlue());
          pixel.setRed(color3.getRed());
          pixel.setGreen(color3.getGreen());
        }
        else{
          pixel.setBlue(color4.getBlue());
          pixel.setRed(color4.getRed());
          pixel.setGreen(color4.getGreen());
        }
      }

    }

  }

  /*
  // copies the region defined by rows 10-100 and columns 20-200 of picture1 into picture2
  // such that the upper-left corner of the copied picture starts at row 30 and column 40
  //(and, therefore, extends to row 120 and column 220).
    picture2.cropAndCopy( picture1, 0, 1253, 0, 1883, 0, 1883);
   */
  public void cropAndCopy( Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, int endSourceCol,
                    int startDestRow, int startDestCol ){
    Pixel[][] destination = this.getPixels2D();
    Pixel[][] source = sourcePicture.getPixels2D();
    int coldif = startDestCol - startSourceCol;
    int rowdif = startDestRow - startSourceRow;
    for(int col = startSourceCol; col <= endSourceCol; col ++) {// copying like reading a book, left to right then down
      for (int row = startSourceRow; row <= endSourceRow; row++) {
          Color sourceColor = source[row][col].getColor();
          destination[row+rowdif][col+coldif].setColor(sourceColor);

      }
    }

  }

} // this } is the end of class Picture, put all new methods before this

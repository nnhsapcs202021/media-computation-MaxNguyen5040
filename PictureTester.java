import java.awt.*;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();


  }

  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();


  }


  public static void testMirrorHorizontalTopToBottom()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalTopToBottom();
    caterpillar.explore();


  }

  public static void testMirrorHorizontalBottomToTop()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBottomToTop();
    caterpillar.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  public static void testMirrorArms()
  {
    Picture arms = new Picture("snowman.jpg");
    arms.explore();
    arms.mirrorArms();
    arms.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//    testZeroBlue();
//    testKeepOnlyBlue();
    testNegate();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
//    testMirrorVertical();
//    testMirrorVerticalRightToLeft();
//    testMirrorHorizontalTopToBottom();
//    testMirrorHorizontalBottomToTop();
//    testMirrorTemple();
//    testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
//    public void shepardFairey(Pixel[][] image, Color color1, Color color2, Color color3, Color color4){
//    //smallest and biggest values
//    int smallest;
//    int biggest;
//    int width = image.length;
//    int height = image[0].length;
//    Pixel pixel = image[0][0];
//    smallest = pixel.getBlue();
//    biggest = pixel.getBlue();
//
//    for (int y = 0; y < height; y++) {
//      for (int x = 0; x < width; x++) {
//        Pixel pixel1 = image[x][y];
//        if(pixel1.getBlue() > biggest){
//          biggest = pixel1.getBlue();
//
//        }
//        else if(pixel1.getBlue() < smallest){
//          smallest = pixel1.getBlue();
//
//        }
//      }
//    }
//
//    //divide into 4 ranges
//    int range = biggest-smallest;
//    range /= 4; //how long each range is
//    int range1 = range;
//    int range2 = range*2;//ending value
//    int range3 = range*3;
//
//
//    //interate through the pixels, changing colors
//
//    for (int y = 0; y < height; y++) {
//      for (int x = 0; x < width; x++) {
//        Pixel pixel2 = image[x][y];
//        if(pixel.getBlue() <= range1){
//          pixel.setBlue(color1.getBlue());
//          pixel.setRed(color1.getRed());
//          pixel.setGreen(color1.getGreen());
//        }
//        else if(pixel.getBlue() <= range2){
//          pixel.setBlue(color2.getBlue());
//          pixel.setRed(color2.getRed());
//          pixel.setGreen(color2.getGreen());
//        }
//        else if(pixel.getBlue() <= range3){
//          pixel.setBlue(color3.getBlue());
//          pixel.setRed(color3.getRed());
//          pixel.setGreen(color3.getGreen());
//        }
//        else{
//          pixel.setBlue(color4.getBlue());
//          pixel.setRed(color4.getRed());
//          pixel.setGreen(color4.getGreen());
//        }
//      }
//
//
//    }
//
//  }
  }
}
import java.awt.*;

/**
 * A class to create a collage.
 */
public class Collage {
    public static void main(String[] args) {

        //2 Blank Images
        Picture image = new Picture(2510,3770);
        Picture collage = new Picture(2510,3770);

        //Source image
        Picture staircase = new Picture("Staircase.jpg");

        //just the top left fourth
        Picture stair1 = new Picture(1254,1884);
        Picture stair2= new Picture(1254,1884);
        Picture stair3 = new Picture(1254,1884);
        Picture stair4 = new Picture(1254,1884);

        //Shepard Fairey
        Color color4 = new Color( 255, 185, 53);
        Color color2 = new Color(255, 160, 53);
        Color color3 = new Color(255, 138, 53);
        Color color1 = new Color(255, 107, 53);

        //getting the source image
        stair1.cropAndCopy(staircase, 0, 1253, 0, 1883,0,0);
        stair2.cropAndCopy(staircase, 0, 1253, 0, 1883,0,0);
        stair3.cropAndCopy(staircase, 0, 1253, 0, 1883,0,0);
        stair4.cropAndCopy(staircase, 0, 1253, 0, 1883,0,0);

        //Compiling all images
        image.cropAndCopy(stair1,0,1253,0,1883,0,0);

        //top right
        stair2.flipLeftToRight();
        image.cropAndCopy(stair2,0,1253,0,1883,0,1884);

        //bottom left
        stair3.flipUpToDown();
        image.cropAndCopy(stair3,0,1253,0,1883,1254,0);

        //bottom right
        stair4.flipUpToDown();
        stair4.flipLeftToRight();
        image.cropAndCopy(stair4,0,1253,0,1883,1254,1884);
        image.explore();


        //Adding to collage
        collage.cropAndCopy(stair1,0,1253,0,1883,0,0);

        //top right
        stair2.greyscale();
        stair2.shepardFairey(stair2,color1,color2,color3,color4);
        collage.cropAndCopy(stair2,0,1253,0,1883,0,1884);

        //bottom left
        stair3.negate();
        collage.cropAndCopy(stair3,0,1253,0,1883,1254,0);

        //bottom right
        stair4.greyscale();
        collage.cropAndCopy(stair4,0,1253,0,1883,1254,1884);
        collage.explore();

        //write to a jpg
        collage.write("/Users/maxnguyen/IdeaProjects/media-computation-MaxNguyen5040/images/FinalCollage.jpg");
    }
}

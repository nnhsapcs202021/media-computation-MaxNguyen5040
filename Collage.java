/**
 * A class to create a collage.
 */
public class Collage {
    public static void main(String[] args) {
        Picture collage = new Picture(2507,3768);
        Picture staircase = new Picture("Staircase.jpg");
        Picture stair = new Picture(1254,1884);
        //getting the source image
        stair.cropAndCopy(staircase, 0, 1253, 0, 1883, 0, 0 );


        //adding to the collage

        //source image
        collage.cropAndCopy(stair,0,1253,0,1883,0,0);
        collage.explore();

        //mirrored and max green (top right)
        stair.mirrorVertical();
        collage.cropAndCopy(stair,0,1253,0,1883,0,1884);
        collage.explore();
        //need a "flip method"




    }
}

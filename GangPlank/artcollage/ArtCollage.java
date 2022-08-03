
/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage Flo2.jpeg
 *
 *  @author:
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
   
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) {
        collageDimension = 4;
        tileDimension = 100;
        original = new Picture(filename);
        collage = new Picture((tileDimension*collageDimension),(tileDimension*collageDimension));
 
        for (int ccol = 0; ccol < collage.width(); ccol++) {
            for (int crow = 0; crow < collage.height(); crow++) {
                int ocol = ccol * original.width() / collage.width(); 
                int orow = crow * original.height() / collage.height();
                Color color = original.get(ocol, orow);
                collage.set(ccol, crow, color); 
            }
	    // WRITE YOUR CODE HERE
        }   
    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) {
        collageDimension = cd;
        tileDimension = td;
        original = new Picture(filename);
        collage = new Picture((tileDimension*collageDimension),(tileDimension*collageDimension));

        for (int ccol = 0; ccol < collage.width(); ccol++) {
            for (int crow = 0; crow < collage.height(); crow++) {
                int ocol = ccol * original.width() / collage.width();
                int orow = crow * original.height() / collage.height();
                Color color = original.get(ocol, orow);
                collage.set(ccol, crow, color);
            }
        }
    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {
        return collageDimension;

	    // WRITE YOUR CODE HERE
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {
        return tileDimension;

	    // WRITE YOUR CODE HERE
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {
        return original;

	    // WRITE YOUR CODE HERE
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {
        return collage;

	    // WRITE YOUR CODE HERE
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() {
        original.show();
	    // WRITE YOUR CODE HERE
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() {
        collage.show();
	    // WRITE YOUR CODE HERE
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {
        Picture temp = new Picture(filename);
        Picture pic = new Picture(tileDimension, tileDimension);

        for (int c = 0; c < pic.width(); c++) {
            for (int r = 0; r < pic.height(); r++) {
                int ocol = c * temp.width() / pic.width();
                int orow = r * temp.height() / pic.height();
                Color color = temp.get(ocol, orow);
                pic.set(c, r, color);
            }
        }

        for (int c = 0; c < collage.width()/tileDimension; c++) {
            for (int r = 0; r < collage.height()/tileDimension; r++) {
                if (c == collageCol && r == collageRow) {
                    for (int i = 0; i < tileDimension; i++) {
                        for (int j = 0; j < tileDimension; j++) {
                            Color color = pic.get(i, j);
                            collage.set(i + tileDimension * collageCol, j + tileDimension * collageRow, color);
                        }
                    }
                }
            }
        }

	    // WRITE YOUR CODE HERE
    }
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () {

        // WRITE YOUR CODE HERE
        
        Picture pic = new Picture(tileDimension, tileDimension);

        for (int c = 0; c < pic.width(); c++) {
            for (int r = 0; r < pic.height(); r++) {
                int ocol = c * original.width() / pic.width();
                int orow = r * original.height() / pic.height();
                Color color = original.get(ocol, orow);
                pic.set(c, r, color);
            }
        }

        for (int c = 0; c < collage.height()/tileDimension; c++) {
            for (int r = 0; r < collage.height()/tileDimension; r++) {
                for (int i = 0; i < tileDimension; i++) {
                    for (int j = 0; j < tileDimension; j++) {
                        Color color = pic.get(i, j);
                        collage.set(i + tileDimension * c, j + tileDimension * r, color);
                    }
                }
            }
        }
    }

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see CS111 Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {

        // WRITE YOUR CODE HERE
        for (int c = 0; c < collage.width()/tileDimension; c++) {
            for (int r = 0; r < collage.height()/tileDimension; r++) {
                if (c == collageCol && r == collageRow) {
                    for (int i = 0; i < tileDimension; i++) {
                        for (int j = 0; j < tileDimension; j++) {
                            Color color = collage.get(i + tileDimension * c, j + tileDimension * r);
                            if (component.equals("red")) {
                                int red = color.getRed();
                                collage.set(i + tileDimension * c, j + tileDimension * r, new Color(red, 0, 0));
                            }  else if (component.equals("green")) {
                                int g = color.getGreen();
                                collage.set(i + tileDimension * c, j + tileDimension * r, new Color(0, g, 0));
                            } else if (component.equals("blue")) {
                                int b = color.getBlue();
                                collage.set(i + tileDimension * c, j + tileDimension * r, new Color(0, 0, b));
                            }
                        }
                    }
                }
            }
        }
    }

    /*
     * Grayscale tile at (collageCol, collageRow)
     * (see CS111 Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

 
    public void greyscaleTile (int collageCol, int collageRow) {
        for (int c = 0; c < collage.width()/tileDimension; c++) {
            for (int r = 0; r < collage.height()/tileDimension; r++) {
                if (c == collageCol && r == collageRow) {
                    for (int i = 0; i < tileDimension; i++) {
                        for (int j = 0; j < tileDimension; j++) {
                            Color color = collage.get(i + tileDimension * c, j + tileDimension * r);
                            Color gray = Luminance.toGray(color);
                            collage.set(i + tileDimension * c, j + tileDimension * r, gray);
                        }
                    }
                }
            }
        }
    }


    /*
     *
     *  Test client: use the examples given on the assignment description to test your ArtCollage
     */
    public static void main (String[] args) {

        ArtCollage art = new ArtCollage(args[0]); 
        art.showCollagePicture();
    }
}

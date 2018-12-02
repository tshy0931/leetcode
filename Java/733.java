/*
Recursive:
Utilize the higher 16 bits to track whether a pixel has been colored.
color adjacent pixels having the same color as source pixel, and recursively process their adjacent pixels.
After the coloring is done, iterate over the image and unset the higher bits.

Iterative:
Use stack or queue to store pixels to be colored.
each time dequeue a pixel, color and enqueue its adjacent pixels if they have the same color as source pixel.

*/
class Solution {
    
    private static final int FLAG = 1 << 17;
    private static final int MASK = (1 << 16) - 1;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int h = image.length, w = image[0].length;
        int oldColor = image[sr][sc];
        color(image, sr, sc, oldColor, newColor);
        for(int i=0; i<h; ++i){
            for(int j=0; j<w; ++j){
                image[i][j] &= MASK;
            }
        }
        return image;
    }
    
    private void color(int[][] image, int i, int j, int oldColor, int newColor) {
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j] > 65535) return; // out of bound or already colored
        if(image[i][j] == oldColor) {
            image[i][j] = newColor;
            image[i][j] |= FLAG; // utilize the higher 16 bits to indicate the pixel has been processed
            color(image, i-1, j, oldColor, newColor);
            color(image, i+1, j, oldColor, newColor);
            color(image, i, j-1, oldColor, newColor);
            color(image, i, j+1, oldColor, newColor);
        }
    }
}

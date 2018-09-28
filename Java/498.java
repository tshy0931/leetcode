/*
Use a boolean value to indicate are we going towards upperleft or lowerright, and calculate what's the next location to go.
take care of all the border cases where we are at
a) corners
b) top/bottom row
c) first/last column
*/
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];        
        boolean isUp = true;
        int h = matrix.length, w = matrix[0].length;
        int i=0, j=0, count = h * w;
        int[] res = new int[count];
        
        for(int k=0; k<count; k++){
            res[k] = matrix[i][j];
            
            if(isUp){
                if(i==0 && j==w-1){
                    isUp = false;
                    i=1;
                } else if(i==0){
                    isUp = false;
                    j++;
                } else if(j==w-1){
                    isUp = false;
                    i++;
                } else {
                    i--;
                    j++;
                }
            }else{
                if(j==0 && i==h-1){
                    isUp = true;
                    j=1;
                } else if(j==0){
                    isUp = true;
                    i++;
                } else if(i==h-1){
                    isUp = true;
                    j++;
                } else {
                    i++;
                    j--;
                }
            }  
        }
        
        return res;
    }
}

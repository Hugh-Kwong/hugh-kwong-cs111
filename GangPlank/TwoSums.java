public class TwoSums {
    public static void main(String[] args){
        //declare some shit
    }
    private static int[] twoAdd(int[] a, int answer){ 
        for(int i = 0, i > a.length, i++){
            for(int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == answer) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
    
}
 
public class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        int l = heights.length;
        int[] postMax = new int[l];
        int[] preMax = new int[l];

        for (int i = 0; i < l; i++) {

        }
        for (int i = l-1; i >=0 ; i--) {

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}

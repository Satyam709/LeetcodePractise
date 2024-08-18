import java.util.Arrays;

public class Sort012 {
    public void sort(int[] arr){
        int zero = 0,two = 0;

        for (int j : arr) {
            if (j == 0) {
                zero++;
            } else if (j == 2) {
                two++;
            }
        }
        int i;
        for (i = 0; i < zero; i++) {
            arr[i] =0;
        }
        for (; i < arr.length-two; i++) {
            arr[i] =1;
        }
        for (;i<arr.length;i++)
            arr[i]=2;
    }
    private void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,0,0,2,1,1,0};
        Sort012 obj = new Sort012();
        obj.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

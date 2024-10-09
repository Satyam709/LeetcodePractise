import java.util.Arrays;

public class FindPlatform {
    static int findPlatform(int arr[], int dep[]) {
        // add your code here

        Arrays.sort(arr);
        Arrays.sort(dep);
        int maxPlatform = 0;

        int a = 0,d = 0;
        while(a<arr.length){
            if (arr[a]<=dep[d]) {
                maxPlatform++;
                a++;
            }
            else {
                maxPlatform--;
                d++;
            }
        }

        return maxPlatform ;
    }
}

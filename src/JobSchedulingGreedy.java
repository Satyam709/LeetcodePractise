import java.util.Arrays;
import java.util.Comparator;

public class JobSchedulingGreedy {
    int[] JobScheduling(Job arr[], int n)
    {
        int count  = 0;
        int profit = 0;
        Arrays.sort(arr, Comparator.comparingInt(i -> i.deadline));
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            Job j = arr[i];

            while (i<arr.length && arr[i+1].deadline == j.deadline){
                i++;
            }

            if (n>j.deadline){
                n-=j.deadline;
                count++;
                profit+=j.profit;
            }
            if(n<=0)break;
        }

        return new int[]{count,profit};
        // Your code here
    }
    static class Job{
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    public static void main(String[] args) {

    }

}

public class Daily_20_04_2025 {
    public static int numRabbits(int[] answers) {
        int[] freq = new int[1005];

        for(int i : answers){
            freq[i+1]++;
        }

        int count=0;
        for (int i = 0; i <1005 ; i++) {
            int add = (int)Math.ceil(freq[i]/(double)i) * i;
            System.out.println("adding for "+i+" freq = "+freq[i]+ " = "+add);
            count+=add;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] answers = {1,1,2};
        System.out.println(numRabbits(answers));
    }
}

public class ParitySwapp {
    static void maxNumber(String str) {
        char[] ch = str.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n; ) {
            int crntVal = ch[i] - '0' ;
            int r = i+1;
            int[] freq = new int[10];
            freq[crntVal]++;
            while (r<n && ((ch[r]-'0') %2 == crntVal%2)){
                freq[ch[r]-'0']++;
                r++;
            }
            for(int j = 9 ;j>=0;j--){
                for (int k = 0; k < freq[j]; k++) {
                    System.out.print(j);
                }
            }
            i = r;
        }
    }

    public static void main(String[] args) {
        // Function call
        maxNumber("468136");
        System.out.println();
        maxNumber("1");
        System.out.println();
        maxNumber("0");
        System.out.println();
        maxNumber("7596801");
        System.out.println();
        maxNumber("577968013");
        System.out.println();
        maxNumber("7596854301");
        System.out.println();
        maxNumber("725596854301");

    }
}

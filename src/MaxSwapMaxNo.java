import java.util.Arrays;

public class MaxSwapMaxNo {

    public static int maximumSwap(int n) {
        char[] num = String.valueOf(n).toCharArray();

        int size = num.length;
        int[] aux = new int[size];
        //System.out.println("num = "+n);
        //System.out.println("size = "+size);
        int i = size;
        int m = n;
        aux[--i] = i;
        m/=10;

        while (m>0){
            i--;
            //System.out.println("i = "+i);
            aux[i] = aux[i+1];
            if (num[i+1] - '0' > num[aux[i]]-'0'){
                //System.out.println("helo  = "+(num[i] - '0'));
                aux[i] = i+1;
                //System.out.println(aux[i]+" current i is "+i);
            }
            m/=10;
        }
        System.out.println(Arrays.toString(aux));

        int d = 0;
        boolean isSwapped =false;
        for (int j = 0; j < size; j++) {
            if (!isSwapped && j<size-1 && num[j]<num[aux[j]]){
                char tmp = num[j];
                num[j] = num[aux[j]];
                num[aux[j]] = tmp;
                isSwapped = true;
            }
            d = d*10+ num[j] -'0';
        }

        return d;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9937));
    }
}

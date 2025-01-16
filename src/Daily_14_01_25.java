public class Daily_14_01_25 {
    public static int minimizeXor(int num1, int num2) {
        int c = 0;
        int bits1 =  (int)(Math.log(num1)/Math.log(2)) +1;

        int setBits = 0;
        while (num2 > 0) {
            setBits += num2 & 1;
            num2 = num2 >> 1;
        }
        //System.out.println("bits1 = " + bits1);
        //System.out.println("setbits = " + setBits);

        if (setBits>= bits1)return (1<<setBits)-1;
        int last = 0;
        String bin = Integer.toBinaryString(num1);
        //System.out.println("bianry = "+bin);
        //System.out.println(bits1 == bin.length());
        int result = 0;
        for (int i = 0; i < bin.length() && setBits>0; i++) {
            if (bin.charAt(i) == '1')
            {
                result =result + (1<<(bin.length()-1-i));
                setBits--;
                ////System.out.println("setbits dec = " + setBits);

            }
            ////System.out.println("result = "+result);
        }

        for (int i = bin.length()-1; i >=0  && setBits>0; i-- ) {
            int t = 1<<(bin.length()-1 - i);
            if ((result&t) == 0){
                result += t;
                setBits--;
            }
        }
        //System.out.println(Integer.toBinaryString(result));
        return result;
    }

    public static void main(String[] args) {
        int n1 = 65, n2 = 84;
        //System.out.println(minimizeXor(n1,n2));
    }
}

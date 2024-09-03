public class Sep_3 {
    // easy
    public int getLucky(String s, int k) {
        int result = -1 ;
        StringBuilder str = new StringBuilder();
        for (char i : s.toCharArray()){
            int j = i-'a'+1;
            str.append(j);
        }
        System.out.println(str);

        for (int i = 0; i < k; i++) {
            str = sumDigits(str);
        }
        return Integer.parseInt(str.toString());
    }
    private StringBuilder sumDigits(StringBuilder str){
        StringBuilder out = new StringBuilder();
        int sum =0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        out.append(sum);
        return out;
    }

    public static void main(String[] args) {
        Sep_3 obj = new Sep_3();
        System.out.println(obj.getLucky("zbax",2));
    }
}

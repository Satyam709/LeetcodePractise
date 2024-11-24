public class KcharLeftRight {
    public static int takeCharacters(String s, int k) {

        if(k==0)return 0;
        if(s.length()<3*k)return -1;

        int[] count = new int[3];
        int front = 0, rear = s.length() - 1;
        int min = 0;
        int frontcost = 1, rearcost = 1;
        boolean isDone = false;
        while (front <= rear && !isDone) {
            char cfront = s.charAt(front);
            char crear = s.charAt(rear);
            System.out.println("frontcost = " + frontcost);
            System.out.println("rearcost = " + rearcost);
            if (frontcost <= rearcost) {
                min += frontcost;
                System.out.println("took front -> " + cfront);
                count[cfront - 'a']++;

                // update front

                int front_before = ++front;
                while (front <= rear && !(count[s.charAt(front) - 'a'] < k)) front++;
                frontcost = front - front_before + 1;

                int rear_before = rear;
                while (front <= rear && !(count[s.charAt(rear) - 'a'] < k)) rear--;
                if (rear != rear_before)
                    rearcost = rear_before - rear + 1;


            } else {
                System.out.println("took rear -> " + crear);
                min += rearcost;
                count[crear - 'a']++;

                int rear_before = --rear;
                while (front <= rear && !(count[s.charAt(rear) - 'a'] < k)) rear--;

                rearcost = rear_before - rear + 1;

                int front_before = front;
                while (front <= rear && !(count[s.charAt(front) - 'a'] < k)) front++;

                if (front != front_before)
                    frontcost = front - front_before + 1;

            }
            System.out.println("crnt front = " + front);
            System.out.println("crnt rear = " + rear);
            System.out.println(min);

            isDone = !(count[0] < k || count[1] < k || count[2] < k);
        }
        return isDone ? min : -1;
    }

    public static void main(String[] args) {
        String s = "cbbac";
        int k = 1;
        System.out.println("out1 = " + takeCharacters(s, k));
    }
}

public class UghlyNo {

    private static class Node{
        long d;
        Node next;
    }


    private Node head = null;
    private  Node tail = null;

    private void add(int data){
        Node newNode = new Node();
        newNode.d = data;
        if (head == null)
        {
            head = newNode;
        }
        else
            tail.next = newNode;
        tail = newNode;
    }

    private void add(Node tail,long data){

        if (tail == null)return;

        Node tmp = tail.next;
        Node newNode = new Node();
        newNode.d = data;
        tail.next = newNode;
        newNode.next =tmp;
    }

    private void print(){
        Node h = head;
        while (h!=null){
            System.out.print(h.d+" ");
            h = h.next;
        }
        System.out.println();
    }


    public int nthUglyNumber(int n) {

        if (n==1)return 1;

        add(1);
        add(2);
        add(3);
        add(5);

        Node t = head.next;
        int count = 2;

        while (count!=n){

            Node h = t;

            while(h.next!=null && h.next.d < 2*t.d){
                h =h.next;
            }

            if (h.next == null || h.next.d != 2*t.d){
                add(h,2*t.d);
            }

            while(h.next!=null && h.next.d < 3*t.d){
                h =h.next;
            }

            if (h.next == null || h.next.d != 3*t.d){
                add(h,3*t.d);
            }

            while(h.next!=null && h.next.d < 5*t.d){
                h =h.next;
            }

            if (h.next == null || h.next.d != 5*t.d){
                add(h,5*t.d);
            }
            t = t.next;
            count++;

        }
        return (int) t.d;
    }

    public static void main(String[] args) {
        int s = 1690;
        UghlyNo obj = new UghlyNo();
        System.out.println(obj.nthUglyNumber(s));
    }
}

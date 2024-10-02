import java.util.HashMap;

public class AllOne {

    static class Node {
        int count = 0;
        String val;
        Node nxt, prev;
    }

    private final HashMap<String, Node> map;

    private Node head, tail;

    public AllOne() {
        head = null;
        tail = null;
        map = new HashMap<>();
    }

    public void inc(String key) {
        Node tmp = map.get(key);
        if (tmp == null) {
            tmp = insertAtFirst(key);
            map.put(key, tmp);
        } else {
            tmp.count++;
            handleInc(tmp);
        }
    }

    private Node insertAtFirst(String val) {
        Node newNode = new Node();

        newNode.count = 1;
        newNode.val = val;
        newNode.nxt = head;

        if (head == null) {
            tail = newNode;
        } else
            head.prev = newNode;

        head = newNode;

        return newNode;
    }

    public void dec(String key) {
        Node tmp = map.get(key);
        if (tmp != null) {
            tmp.count--;
            if (tmp.count < 0) {
                map.remove(key);
                delete(tmp);
            }
            else handleDec(tmp);
        }
    }

    private void delete(Node p) {
        Node tmp1prev = p.prev;
        Node tmp1nxt = p.nxt;

        if (tmp1prev != null)
            tmp1prev.nxt = tmp1nxt;

        if (tmp1nxt != null)
            tmp1nxt.prev = tmp1prev;

    }

    private void handleInc(Node node) {
        while (node != tail && node.count > node.nxt.count) {

            // swap node ,node.next
            swap(node,node.nxt);
        }
    }

    private void handleDec(Node node) {
        while (node != head && node.count < node.prev.count) {
            // swap node ,node.next
            swap(node,node.prev);
        }
    }


    private void swap(Node p, Node q) {

        Node tmp1prev = p.prev;
        Node tmp1nxt = p.nxt;

        Node tmp2nxt = q.nxt;
        Node tmp2prev = q.prev;

        if (tmp1prev != null)
            tmp1prev.nxt = q;

        if (tmp1nxt != null)
            tmp1nxt.prev = q;

        if (tmp2nxt != null)
            tmp2nxt.prev = p;

        if (tmp2prev != null)
            tmp2prev.nxt = p;

    }


    public String getMaxKey() {
        if (head == null)return null;
        return head.val;
    }
    public String getMinKey() {
        if (tail == null)return null;
        return tail.val;
    }
}

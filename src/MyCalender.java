class MyCalendar {
    private final int[] start;
    private final int[] end;

    private int count_events;

    MyCalendar() {
        count_events = 0;
        int size = 2000;
        start = new int[size];
        end = new int[size];
    }

    public boolean book(int start, int end) {
        boolean isPossible = isNewEveValid(start, end);
        if (isPossible) {

            this.start[count_events] = start;
            this.end[count_events] = end;

            count_events++;
        }
        return isPossible;
    }

    private int[] getLastEvent(int start) {

        int max = -2, maxi = -1;
        int sec = Integer.MAX_VALUE, seci = -1;

        for (int i = 0; i < count_events; i++) {
            if (this.start[i] <= start) {
                if (this.start[i] > max) {
                    max = this.start[i];
                    maxi = i;
                }
            } else {
                if (this.start[i] < sec) {
                    sec = this.start[i];
                    seci = i;
                }
            }
        }
        return new int[]{maxi, seci};
    }

    private boolean isNewEveValid(int start, int end) {

        int[] out = getLastEvent(start);

        int last = out[0];
        int nxt = out[1];

        if (last != -1 && this.end[last] > start)
            return false;
        return nxt == -1 || this.start[nxt] >= end;
    }

    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(15, 25));
        System.out.println(obj.book(20, 30));
    }
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxAvgPassRatio {
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassRecord> pq = new PriorityQueue<>(new Compare());

        for(int[] cl : classes)
            pq.add(new ClassRecord(cl));

        ClassRecord cl;
        while(extraStudents-- > 0)
            pq.add(pq.remove().addOneStudent());

        double sum = 0;
        while(!pq.isEmpty()){
            cl = pq.remove();
            sum += (double)cl.pass / cl.total;
        }

        return sum / classes.length;
    }

    public static void main(String[] args) {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;

        System.out.println(maxAverageRatio(classes,extraStudents));
    }
}
class ClassRecord{
    int pass;
    int total;
    double inc;

    public ClassRecord(int[] array){
        pass = array[0];
        total = array[1];
        inc = getIncrement();
    }

    public ClassRecord addOneStudent(){
        pass++;
        total++;
        inc = getIncrement();
        return this;
    }

    private double getIncrement(){
        return (pass + 1.0) / (total + 1) - (double)pass / total;
    }
}

class Compare implements Comparator<ClassRecord>{
    public int compare(ClassRecord a, ClassRecord b){
        return Double.compare(b.inc, a.inc);
    }
}
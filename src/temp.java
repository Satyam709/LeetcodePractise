import java.lang.reflect.Field;
import java.util.ArrayList;

public class temp {


    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>(15);

        // Using reflection to get the underlying array capacity
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] array = (Object[]) field.get(list);

        System.out.println("Underlying array size (capacity): " + array.length);
        System.out.println("Actual size of ArrayList: " + list.size());
    }


}

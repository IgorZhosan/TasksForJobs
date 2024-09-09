import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = {1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1};
        System.out.println(countElementsArr(arr));

    }

    public static int countElementsArr(Integer[] arr) {

        List<Integer> list = Arrays.asList(arr.clone());
        List<Integer> list_copy = new ArrayList<>(list);

        int local0 = 0;
        int global0 = 0;

        int local1 = 0;
        int global1 = 0;

        int index = 0;
        int indexForRemove = 0;

        for (Integer i : list_copy) {
            if (i == 1) {
                local1++;
                if (local0 <= global0) {
                    global0 = local0;
                }
                local0 = 0;
            } else {
                local0++;
                if (local1 > global1) {
                    global1 = local1;
                }
                local1 = 0;
                indexForRemove = index;
            }
            index++;
        }

        list_copy.remove(indexForRemove);

        int local_max = 0;
        int global_max = 0;

        for (Integer i : list_copy) {
            if (i == 1) {
                local_max++;
                if (local_max > global_max) {
                    global_max = local_max;
                }
            } else {
                local_max = 0;
            }
        }


        return global_max;
    }
}


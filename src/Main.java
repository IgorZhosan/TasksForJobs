import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = {1, 1, 0, 1};
        System.out.println(countElementsArr(arr));

    }

    public static int countElementsArr(Integer[] arr) {

        int totalOnes = 0;

        for (int i : arr) {
            if (i == 1)
            totalOnes++;
        }
        if (totalOnes == arr.length) {
            return totalOnes;
        }

        int currentOnes = 0;
        int maxOnes = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                currentOnes++;
            } else if (arr[i] == 0) {
                int leftOnes = currentOnes;
                int rightOnes = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == 1) {
                        rightOnes++;
                    } else {
                        break;
                    }
                }
                maxOnes = Math.max(maxOnes, leftOnes + rightOnes);
                currentOnes = 0;
            }
        }
        return maxOnes;
    }
}


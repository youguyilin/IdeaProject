package algorithm.uti;

/**
 * PackageName: algorithm.uti
 * ClassName: Standardstd
 * Author: CYP2017
 * Date: 2018/11/9 11:14
 * Description:
 */
public class Standardstd {
    public static void printArry(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("");
    }

    public static void swap(int[] arr, int left, int right) {
        int t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;
    }

    public static void swapValue(int a, int b) {
        int t = a;
        a = b;
        b = t;
    }
}

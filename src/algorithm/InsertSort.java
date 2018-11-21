package algorithm;

import algorithm.uti.Standardstd;

/**
 * PackageName: algorithm.uti
 * ClassName: InsertSort
 * Author: CYP2017
 * Date: 2018/11/9 14:12
 * Description:
 */
public class InsertSort {
    /**
     * 插入排序的思想，将指针指向某个元素，将某个元素 赋值给临时变量temp，从该元素的左侧开始，从右往左，如果有比该元素大的元素则换位置，并将指针右移，循环操作
     * 时间复杂度为O（N^N）
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {38,65,97,76,13,27,49};
        insertSort(arr);
        Standardstd.printArry(arr);
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int leftIndex = i - 1;
            while (leftIndex >= 0 && arr[leftIndex] > temp){
                arr[i] = arr[leftIndex];
                leftIndex--;
            }
            arr[i] = temp;
        }
    }


}

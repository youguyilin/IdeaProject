package algorithm;

import algorithm.uti.Standardstd;

/**
 * PackageName: algorithm
 * ClassName: QuiklySort
 * Author: CYP2017
 * Date: 2018/11/9 10:40
 * Description:
 */
public class QuiklySort {

    /**
     * 快速排序是对冒泡排序的一种改进，基本思想是选取一个记录作为轴值，经过一趟排序将整段序列分为两个部分，其中一部分都小于轴值
     * 另一部分都大于轴值，然后可以是有递归实现，
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {4, 1, 7, 6, 9, 2, 8, 0, 3, 5};
        quickSort(arr, 0, 9);
        Standardstd.printArry(arr);
    }

    public static void quickSort(int[] arry, int left, int right) {
        if (arry == null || arry.length <= 1) return;
        if (left >= right) {
            return;
        }
        int index = partSort(arry, left, right);
        if (index < 0) return;
        quickSort(arry, left, index - 1);
        quickSort(arry, index + 1, right);
    }

    /**
     * 一次排序有3种实现
     *
     * @param arry
     * @param left
     * @return
     */
    private static int partSort(int[] arry, int left, int right) {
        return leftRightIndicator(arry, left, right);
    }

    /**
     * 左右指针法
     * <p>
     * 设置两个变量left = 0;right = N - 1;
     * 从left一直向后走，直到找到一个大于key的值，right从后至前，直至找到一个小于key的值，然后交换这两个数。
     * 重复第三步，一直往后找，直到left和right相遇，这时将key放置left的位置即可
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int leftRightIndicator(int[] arr, int left, int right) {
        int key = arr[right];
        while (left < right) {
            while (left < right && arr[left] <= key) {
                ++left;
            }
            while (left < right && arr[right] >= key) {
                --right;
            }
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
        }
        int k = arr[arr.length - 1];
        arr[arr.length - 1] = arr[left];
        arr[left] = k;
        return left;
    }

    /**
     * 挖坑法，
     * 选取一个关键字(key)作为枢轴，一般取整组记录的第一个数/最后一个，这里采用选取序列最后一个数为枢轴，也是初始的坑位。
     * 设置两个变量left = 0;right = N - 1;
     * 从left一直向后走，直到找到一个大于key的值，然后将该数放入坑中，坑位变成了array[left]。
     * right一直向前走，直到找到一个小于key的值，然后将该数放入坑中，坑位变成了array[right]。
     * 重复3和4的步骤，直到left和right相遇，然后将key放入最后一个坑位。
     * 当left >= right时，将key放入最后一个坑，就完成了一次排序。
     * 注意，left走的时候right是不动的，反之亦然。因为left先走，所有最后一个坑肯定在array[right]。
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int leftRightPits(int[] arr, int left, int right) {
        int key = arr[right];
        while (left < right) {
            while (left < right && arr[left] <= key) left++;
            arr[right] = arr[left];
            while (left < right && arr[right] >= key) right--;
            arr[left] = arr[right];
        }
        arr[right] = key;
        return right;
    }

    /**
     * 前后指针法
     * 定义变量cur指向序列的开头，定义变量pre指向cur的前一个位置。
     * arr[cur] < key,cur,pre同时向前走，如果arr[cur] > key,cur向前走，pre留在原地
     * 当arr[cur]<key再次出现时，交换arr[cur]与arr[pre];
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int preCureIndicator(int[] arr, int left, int right) {

        if (left < right) {
            int key = arr[right];
            int cur = left;
            int pre = cur - 1;
            while (cur < right) {
                while (arr[cur] < key && ++pre != cur) {
                    Standardstd.swap(arr, cur, pre);
                }
                ++cur;
            }
            Standardstd.swap(arr, ++pre, right);
            return pre;
        }
        return -1;
    }

    /**
     * 快速排序的优化，首先 快速排序的思想是找一个轴值，，一遍都小于它，一遍都大于它，然后递归继续划分，
     * 那么轴值的选取就很关键，
     * <p>
     * 三数取中法：上面的代码思想都是直接拿序列的最后一个值作为轴值，如果最后一个值刚好是整段序列的最大，或者是最小值，那么这次划分就没有意义
     * 所以当序列是正序或者逆序时，每次的轴值没有起到划分的作用，快速排序的效率会急速退化。
     * 所以在选择轴值是，在徐磊的第一，中间和最后三个值里面选一个值出来作为轴。保证每次划分接近均等。
     */
    public static int getMidIndex(int[] arr, int left, int right) {
        if (arr == null || arr.length <= 1) return 0;
        int mid = left + (right - left) >> 1;
        if (arr[left] <= arr[right]) {
            if (arr[mid] < arr[left]) {
                return left;
            } else if (arr[mid] > arr[left] && arr[mid] < arr[right]) {
                return mid;
            } else {
                return right;
            }
        } else {
            if (arr[mid] < arr[right]) {
                return right;
            } else if (arr[mid] > arr[right] && arr[mid] < arr[left]) {
                return mid;
            } else {
                return left;
            }
        }
    }

}

package com.yaoyun.sort;

/**
 * @author yaoyun created on 4月 29, 2020
 * @version 1.0 堆排序 https://blog.csdn.net/u010452388/article/details/81283998 在数组中对于已知索引为i的数, 父节点索引为(i-1)/2, 左孩子为2*i+1, 右孩子为2*i+2
 */
public class MinHeapSort {

    public static int[] heapSort(int[] nums) {
        int n = nums.length;

        // 建立最小堆, 由于所有椰子节点的无子节点所以已经满足最小堆的定义,所以从第一个非叶子节点的元素开始
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapFixDown(nums, i, n);
        }

        for (int i = n; i > 0; i--) {
            minHeapDeleteNumber(nums, i);
        }

        return nums;
    }

    /**
     * 调整数组元素顺序使其成为一个二叉堆结构
     *
     * @param arr 目标数组
     * @param i 待调整节点
     * @param n 节点总数
     */
    private static void minHeapFixDown(int[] arr, int i, int n) {
        int j = 2 * i + 1;

       /*
        原始做法便于理解
         while (j < n) {
             // 找到较小的子节点
             if (j + 1 < n && arr[j + 1] < arr[j]) {
                 j++;
             }
             // 如果较小的子节点已经比父节点大说明以该节点为根的子树已经有序
             if (arr[j] >= arr[i]) {
                 break;
             }
             // 如果较小的子节点比父节点还小则交换两者位置
             Utils.swap(arr, i, j);
             i = j;
             j = 2 * i + 1;
         }
       */

        int temp = arr[i];
        while (j<n) {

            // 找到较小的子节点
            if (j + 1 < n && arr[j + 1] < arr[j]) {
                j++;
            }

            // 如果较小的子节点已经比父节点大说明以该节点为根的子树已经有序
            if (arr[j] >= arr[i]) {
                break;
            }

            // 只用子节点替换父节点而不用交换, 因为父节点可能还会继续下移, 可以少几次赋值操作
            arr[i] = arr[j];
            i = j;
            j = 2 * i + 1;
        }
        arr[i] = temp;
    }

    private static void minHeapDeleteNumber(int[] arr, int n) {
        // 把待删除节点(目前堆中最小)节点换到数组最后, 然后重新排一下根节点
        Utils.swap(arr, 0, n - 1);
        minHeapFixDown(arr, 0, n - 1);
    }
}

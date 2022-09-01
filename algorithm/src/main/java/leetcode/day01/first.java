package leetcode.day01;

public class first {

    public static void main(String[] args) {

        int[] arr = {6,6,4,4,2,1};
        int[] brr = singleNumbers(arr);
        soutArr(brr);
        swap(arr,0,5);
        soutArr(arr);


    }

    /**
     *  选择排序
     * @param nums
     * @return
     */
    public static int[] selectSort(int[] nums) {
        if (nums.length<2){
            return nums;
        }
        for (int i=nums.length-1;i>0;i--){
            int min=nums[i];
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    swap(nums,i,j);
                }
            }
        }
        return nums;
    }


    /**
     *  冒泡排序
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        if (nums.length<2){
            return nums;
        }
        for (int i=nums.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
        return nums;
    }


    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     *
     * 使用异或运算
     *
     * 示例 1：
     *
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     *
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        // 求出a^b
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum=sum ^nums[i];
        }
        int mid = sum & (~sum +1);
        int a =0;
        for (int i=0;i<nums.length;i++){
            if ((mid&nums[i])==0){
                a=a ^ nums[i];
            }
        }
        int b = a^sum;
        int[] res={a,b};
        return res;
    }

























        /**
         * 根据异或运算将数组中的两个数交换位置
         * @param arr
         * @param a
         * @param b
         */
    public static void swap(int[] arr, int a, int b){
        arr[a]=arr[a]^arr[b];//a=a^b  b=b
        arr[b]=arr[a]^arr[b];//b=a^b^b=a  a=a^b
        arr[a]=arr[a]^arr[b];//b=a  a=a^b^a=b
    }

    public static void soutArr(int[] arr){
        System.out.print("[");
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.print("]");
    }
}

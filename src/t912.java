import java.util.Arrays;

public class t912 {
    public static void main(String[] args) {
        Solution912 solution = new Solution912();

        System.out.println(Arrays.toString(solution.sortArray(new int[]{
                5, 2, 3, 1, 56, 23, 45, 345, 867, 234, 78, 234, 89, 234, 7, 87, 32, 4, -234, 234, -8, 954, 23
        })));

    }
}

class Solution912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length);
        return nums;
    }

    private void quickSort(int[] nums, int from, int to) {//to is unreachable
        if (from >= to - 1) {
            return;
        }


        int random = (int) (from + Math.random() * (to - from));
        swap(random, to - 1, nums);
        int index = to - 1;
        int value = nums[index];

        int pos = from;
        for (int i = from; i < to; i++) {
            if (nums[i] < value) {
                swap(pos++, i, nums);
            }
        }
        swap(pos, index, nums);
        quickSort(nums, pos + 1, to);
        quickSort(nums, from, pos);

    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
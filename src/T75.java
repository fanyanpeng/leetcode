import java.util.Arrays;

public class T75 {
    public static void main(String[] args){
        Solution75 solution=new Solution75();
        int [] ints = new int[]{2,0,2,1,1,0};
        solution.sortColors(ints);
        System.out.println(Arrays.toString(ints));

    }
}

class Solution75 {

    public void sortColors(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int i=0;
        //左右指针，分别存放0，1下一个的位置。
        //此处取等于，i需要检测到每一个位置，此处可能为0，需要替换。
        while (i<=r){
            //当前值小于1时：
            //因为所有的2已经被移动到了后面
            //与前面的数字进行移动时，只有可能遇到1
            //所以不会打破排序
            if(nums[i]<1){
                swap(i++,l++,nums);
            }
            //当前值大于1，需要移动到队尾巴
            //队尾是未曾访问的地方，返回的值可能是所有值，若返回值还是2，那i++，就会导致异常
            //我们的目的是将所有的2移动到队尾，因为这里可能会重复传回2，所以，i需要保持不变
            //下一个循环可以再次与末尾替换
            else if(nums[i]>1){
                swap(i,r--,nums);
            }
            //若当前值不为0、2，不做操作。
            //核心思想：
            // 把0移动到队首
            //把2移动到队尾
            else {
                i++;
            }
        }
    }
    void swap(int i,int j,int[] nums){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

}
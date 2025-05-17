package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @Created 17/05/2025
 * @Project data-structures-algorithms
 * @author jezreljumwa
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int firstVal = nums[i];
            int diff = target - firstVal;
            int index2 = list.indexOf(diff);
            if (i != index2 && index2 != -1) {
                result[0] = i;
                result[1] = index2;
                break;
            } else {
                list.add(nums[i]);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        twoSum solution = new twoSum();
        System.out.println(solution.twoSum(nums, 9));
    }
}

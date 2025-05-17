package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * @Created 17/05/2025
 * @Project data-structures-algorithms
 * @author jezreljumwa
 */
public class containsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);

        }

        if (set.size() < nums.length) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        containsDuplicates solution = new containsDuplicates();
        System.out.println(solution.containsDuplicate(nums));
    }
}

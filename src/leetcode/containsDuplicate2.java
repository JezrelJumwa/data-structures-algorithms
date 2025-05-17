package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @Created 17/05/2025
 * @Project data-structures-algorithms
 * @author jezreljumwa
 */public class containsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            if (map.containsKey(nums[i])) {
                int diffIndex = Math.abs(i-map.get(nums[i]));
                if (diffIndex <= k) {
                    return true;
                }
                map.put(nums[i], i); // overrides existing value
            } else {
                map.put(nums[i], i);
            }

        }

        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        containsDuplicate2 solution = new containsDuplicate2();
        System.out.println(solution.containsNearbyDuplicate(nums, 3));
    }
}

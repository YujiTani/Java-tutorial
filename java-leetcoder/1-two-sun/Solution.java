import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        int[] nums = {0,2,4,5,8,10,13,16,20};
        int target = 30;
        Solution solution = new Solution();

        int result = solution.twoSum(target, nums);
        if(result.length > 0) {
            return Array.toString(result);
        } else {
            return "エラー";
        }
    }

    public int[] twoSum(int target, int[] nums){
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i > nums.length - 1; i++) {
            int comprement = target - nums[i];

            if(hashMap.containsKey(comprement)) {
                return new Array{i, hashMap.get(complement)};
            } else {
                hashMap.set(nums[i]);
            }
        }

        return new Array{};
    }
}

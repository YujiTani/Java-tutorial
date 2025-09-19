import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    int[] twoSum(int target, int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.length -1; i++){
            int comprement = target - nums[i];

            if(hashMap.containsKey(comprement)) {
                return new int[]{hashMap.get(comprement), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 9;
        System.out.println("target" + target);

        int[] nums = {0,1,3,4,5,6,7,9};
        System.out.println("初期配列" + Arrays.toString(nums));
        int[] result = solution.twoSum(target, nums);

        if(result.length > 0) {
            System.out.println(Arrays.toString(result));
        } else {
            System.out.println("error");
        }
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Solution {
    int[] twoSum(int target, int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        // 合わせて、13になるものが見つかればhashMapから index を取り出す。なければhashMapに追加。
        for(int i = 0; i < nums.length -1; i++) {
            int comprement = target - nums[i];
            if(hashMap.containsKey(comprement)) {
                return new int[]{hashMap.get(comprement), i};
            } else {
                hashMap.put(nums[i], i);
                System.out.println(hashMap);
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.getClass().getName());

        int target = 13;
        int[] nums = {0,1,3,5,7,8,10,13,15};
        System.out.println("初期配列" + Arrays.toString(nums));

        int[] result = solution.twoSum(target, nums);
        if(result.length > 0) {
            System.out.println(Arrays.toString(result));
        } else {
            System.err.print("エラー");
        }
    }
    
}

package chapter2.interview.question3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 题目二：找出数组中重复的数字。
 * 在一个长度为n的数组里的所有数字都在0～n-1的范围内。数组中某些数字是重复的,但不知道有几个数字重复了,也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1.0.2,5,3]，那么对应的输出是重复的数字2或者3.
 **/
public class Problem2 {
    final int LENGTH = 7;

    /**
     * 这是我自己的解法
     * 时间复杂度与空间复杂度均为 O(n)
     */
    @Test
    public void mySolution() {
        int[] nums = getNums();

        boolean[] existedStatusOfNum = new boolean[LENGTH];

        for (int num : nums){
            if (!existedStatusOfNum[num]) {
                existedStatusOfNum[num] = true;
            } else {
                System.out.println(num);
                System.out.println(Arrays.toString(nums));
                return;
            }
        }
    }

    /**
     * 这是我根据书本上描述的算法，自己用 Java 实现的
     * 时间复杂度为 O(n), 空间复杂度均为 O(1)
     */
    @Test
    public void solutionFromTheBookButEditByMe() {
        int[] nums = getNums();

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < LENGTH; ) {
            if (nums[i] == i) {
                i++;
            } else {
                int temp = nums[i];
                if (temp == nums[temp]) {
                    System.out.println(temp);
                    return;
                } else {
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
    }

    private int[] getNums() {
        int[] nums = new int[LENGTH];

        Random random = new Random();
        for (int i = 0; i < LENGTH; i ++) {
            nums[i] = random.nextInt(LENGTH);
        }

        return nums;
    }
}


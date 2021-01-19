package chapter2;

import java.util.Arrays;
import java.util.Random;

/**
 * description 2th Edition
 *             P39
 *
 * @author Leet
 * @date 2021-01-19 17:04
 **/
public class Question3 {

    public static final int LENGTH = 6;

    public static void main(String[] args) {
//        dealWithTheQuestionByMyself();
        theAnswerOfTheQuestion();
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public static void dealWithTheQuestionByMyself() {
        int[] nums = createNums();
        int[] existingJudge = new int[LENGTH];

        for (int num : nums) {
             existingJudge[num] = existingJudge[num] + 1;
        }

        for (int i = 0; i < LENGTH; i++) {
            if (existingJudge[i] > 1) {
                System.out.print(nums[i] + " ");
            }
        }

        System.out.println();
        System.out.println(Arrays.toString(nums));
    }

    // 时间复杂度：O(n) 空间复杂度：O(1)
    // 看过答案
    public static void theAnswerOfTheQuestion() {
        int[] nums = createNums();

        for (int i = 0; i < LENGTH; ) {
            if (nums[i] == i) {
                i ++;
                continue;
            }

            int m = nums[i];

            if (m == nums[m]) {
                System.out.println(m);
                i ++;
                continue;
            }

            nums[i] = nums[m];
            nums[m] = m;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static int[] createNums() {
        int[] nums = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            nums[i] = new Random().nextInt(LENGTH);
        }
        return nums;
    }
}

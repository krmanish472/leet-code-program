package LeetCode.Medium;

/*
* Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
* The guards have gone and will come back in h hours.
* Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and
* eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead
* and will not eat any more bananas during this hour.

* Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

* Return the minimum integer k such that she can eat all the bananas within h hours.

* Example 1:
    Input: piles = [3,6,7,11], h = 8
    Output: 4

* Example 2:
    Input: piles = [30,11,23,4,20], h = 5
    Output: 30

* Example 3:
    Input: piles = [30,11,23,4,20], h = 6
    Output: 23
* */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int speed = minEatingSpeed(piles, h);
        System.out.println(speed);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while (minSpeed < maxSpeed) {
            int mid = (minSpeed + maxSpeed) / 2;
            if (canEatInTime(piles, h, mid)) {
                maxSpeed = mid; // used mid and not mid-1 as mid can also be the value
            } else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }

    private static boolean canEatInTime(int[] piles, int h, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / speed);
        }
        return hours <= h;
    }
}

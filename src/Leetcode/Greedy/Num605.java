package Leetcode.Greedy;

public class Num605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int cnt = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                cnt++;
            }
            if (cnt >= n)
                return true;
            i++;

        }
        return false;

    }
}

// Question 1103 Distribute Candies to People

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int num = 1, index = 0;
        while (candies > 0) {
            if (index == num_people)
                index = 0;
            candies -= num;
            res[index] += num;
            num++;
            index++;
        }
        res[index - 1] += candies;
        return res;
    }
}
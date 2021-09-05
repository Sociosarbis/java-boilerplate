package rand10;


abstract class Solution {
    public int rand10() {
        int ret = 0;
        do {
            ret = (rand7() - 1) * 7 + rand7();
        } while (ret > 40);
        return (ret - 1) / 4 + 1;
    }

    abstract public int rand7();
}
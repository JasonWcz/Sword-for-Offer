package SwordForOffer.Chapter6;

/**
 *
 * @author wcz_j
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 *
 * 1.本题需要掌握“异或”操作:两个相同的数异或为1，反之则为0
 *   因此将数组中所有数字异或最后剩下的一定是只出现一次的数
 *  （出现两次的会两两抵消）
 * 2.本题有要找两个数字，因此最好将两个数字分在两个子数组里
 *   通过第一轮全部一起异或，再找到异或结果中的第一个数位为1的位置
 *   因为没有抵消，必能将两个只出现一次的数分开
 * 3.最后对两个子数组进行全部异或分别能得到两个结果
 */
public class Solution_56_1 {
    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int exclusiveOR = 0;
        for (int i = 0; i < array.length; ++i) {
            exclusiveOR ^= array[i];
        }
        int indexOf1 = FindFirstBitOf1(exclusiveOR);
        num1[0] = num2[0] = 0;
        for (int i = 0; i < array.length; ++i) {
            /**对数组分两类并分别异或*/
            if (IsBit1(array[i], indexOf1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 找到右边第一个二进制位中为1的位置
     * @param number
     * @return
     */
    public int FindFirstBitOf1(int number) {
        int index = 0;
        while ((number & 1) == 0 && index < 32) {
            number = number >> 1;
            ++index;
        }
        return index;
    }

    /**
     * 判断num在index位置上是否为1
     * @param num
     * @param index
     * @return
     */
    public boolean IsBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }
}


package algorithm;

/**
 * PackageName: algorithm
 * ClassName: ReplaceBlank
 * Author: CYP2017
 * Date: 2018/11/8 15:15
 * Description:
 */
public class ReplaceBlank {

    public static void main(String[] args) {
        System.out.println(replaceBlank(new StringBuffer("we are soft engineer!")));
        String originalString = new String("WE ARE HAPPY!");
        System.out.println(originalString);
        char[] chars = new char[50];
        char[] str = originalString.toCharArray();
        for (int i = 0; i < str.length; i++) {
            chars[i] = str[i];
        }
        System.out.println(replceBlankSpace(chars, str.length));
    }


    /**
     * 遇到空格替换成20%，长度为n的字符串，遇到一个空格，就需要向后移动n个字符，
     * 时间复杂度O（n2）,空间复杂度O（n）
     */
    public static String replaceBlank(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res.append("20%");
            } else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    /**
     * 双指针，从后往前遍历替换：
     * p1:指向字符串末尾
     * p2:指向替换之后的字符串的末尾（需要提前遍历一遍str,数一下一共有多少个空格）
     * 然后p1和p2一起向前跑，当p1遇到空格，则将‘ ’变成‘%20’,然后继续向前跑
     *
     * @param str  需要替换的字符串
     * @param size str 中 原始字符串的长度
     */
    public static String replceBlankSpace(char[] str, int size) {
        if (str == null || size < 1) {
            return null;
        }
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (str[i] == ' ') {
                cnt++;
            }
        }
        int p1 = size - 1;
        int p2 = p1 + cnt * 2;
        if (p2 > str.length) {
            throw new RuntimeException("Invalid args :str 有点小，不够装！");
        }
        while (p1 > 0) {
            if (str[p1] == ' ') {
                str[p2--] = '0';
                str[p2--] = '2';
                str[p2--] = '%';
            } else {
                str[p2--] = str[p1];
            }
            p1--;
        }

        return new String(str);
    }

}

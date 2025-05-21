package org.remove.consecutive.characters.removeconsecutivecharacters.utils;

public class StringUtils {

    /**
     * 删除3个以上连续相同的字符，直到没有3个以上连续相同的字符为止
     *
     * @param s
     * @return
     */
    public static String removeConsecutive(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean found = true;

        while (found) {
            found = false;
            int i = 0;
            while (i < sb.length() - 2) {
                char current = sb.charAt(i);
                int j = i + 1;
                // 找到所有连续相同的字符
                while (j < sb.length() && sb.charAt(j) == current) {
                    j++;
                }
                // 如果连续相同的字符数大于等于3，则删除
                if (j - i >= 3) {
                    sb.delete(i, j);
                    found = true;
                    i = Math.max(0, i - 2); // 回退以检查删除后是否形成新的重复
                } else {
                    i = j; // 移动到下一个不同的字符
                }
            }
        }

        return sb.toString();
    }

    /**
     * 查找3个以上连续相同的字符，如果相同的字符为a，则删除相同字符，如果不是a，则替换为该字符的前一个字符，直到没有3个以上连续相同的字符为止
     *
     * @param s
     * @return
     */
    public static String replaceConsecutive(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean found = true;

        while (found) {
            found = false;
            int i = 0;
            while (i < sb.length() - 2) {
                char current = sb.charAt(i);
                int j = i + 1;
                // 找到所有连续相同的字符
                while (j < sb.length() && sb.charAt(j) == current) {
                    j++;
                }
                // 如果连续相同的字符数大于等于3
                if (j - i >= 3) {
                    if (current == 'a') {
                        sb.delete(i, j); // 删除所有连续的a
                        found = true;
                        i = Math.max(0, i - 2); // 回退以检查删除后是否形成新的重复
                    } else {
                        char replacement = (char) (current - 1);
                        sb.replace(i, j, String.valueOf(replacement));
                        found = true;
                        i = Math.max(0, i - 2); // 回退以检查替换后是否形成新的重复
                    }
                } else {
                    i = j; // 移动到下一个不同的字符
                }
            }
        }

        return sb.toString();
    }

}

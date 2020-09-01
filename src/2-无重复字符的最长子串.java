/****
 *题目：无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 * 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 键盘字符ASCII范围0-127包含多种字符
 **/

/*************** 优秀的解法 （本注释标记的是当s=abcafskdbb的时候）****************/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int max = 0;
        int start = 0; // 第一个字符位置
        System.out.println(s);
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            // System.out.println(start+"_"+index +"_" + res);
            // start 记录的是两字符相同时取第一个字符的下一个位置
            start = Math.max(start, last[index] + 1); // 0,0,0,1,1
            // res 是最长串的子串的长度 比较res 和当前长度（i-start+1）
            max   = Math.max(max, i - start + 1); // 1,2,3,3,4
            // last[index] 记录当前字符位置
            last[index] = i;// a:0,b:1,c:2,a:3
        }

        return max;
    }
}
/*****************我的解法（暴力法。。。）*******************/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map maps = new HashMap();
        int max = 0,q=0;
        char[] cs = s.toCharArray();
        for(int i=0,length=cs.length;i<length;i++) {
            maps.put(cs[i],cs[i]);
            q = 1;
            for(int j=i+1;j<length;j++) {
                if(maps.get(cs[j]) == null) {
                    maps.put(cs[j],cs[j]);
                    ++q;
                } else {
                    if(max < q) max = q;
                    maps.clear();
                    break;
                }

            }
            if(max < q) max = q;
        }
        if(max < q) max = q;
        return max;
    }
}
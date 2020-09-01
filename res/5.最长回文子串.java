/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
// aacdefcaa abcda aaabaaaa abbc babad bb tattarrattat babaddtattarrattatddetartrateedredividerb
// civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth
// @lc code=start
class Solution2 {
    public static void main(String[] args) {
        // String s = "abacdcaba";
        String s = "iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz";
        // this.longestPalindrome(s);
        String ret = new Solution2().longestPalindrome(s);
        System.out.println(ret);
    }

    /*************** 别人的优秀解法***************** */
    public String perfectLongestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 把回文看成中间的部分全是同一字符，左右部分相对称
            // 找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        // 查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        // 定位中间部分的最后一个字符
        int ans = high;
        // 从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        // 记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    /*********** 我的垃圾解法************** */
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        StringBuilder st = new StringBuilder();
        StringBuilder st2;
        String es = new String();
        int max = 0, q = 0, w = 0, len = 0, length = 0, w2 = 0;
        boolean sub = false;
        for (int i = 0, l = cs.length; i < l; i++) {
            q = i;
            w2 = w = l - 1;
            len = 0;
            while (q <= w && w != i) {
                if (cs[q] == cs[w]) {
                    st.append(cs[w]);
                    ++len;
                    if (max < len || (max == len && sub == true)) {
                        if (q == w - 1 || q == w) {
                            max = len;
                            es = st.toString();
                            if (q == w) {
                                if (es.length() > 1)
                                    sub = true;
                            } else {
                                sub = false;
                            }
                        }
                    }
                    q++;
                    w--;
                } else {
                    length = st.length();
                    if (length > 0)
                        st.delete(0, length);
                    w2--;
                    w = w2;
                    q = i;
                    len = 0;
                }
            }
            st.delete(0, st.length());
        }
        if (es.length() == 0 && cs.length > 0) {
            es = String.valueOf(cs[0]);
        } else {
            st2 = new StringBuilder(es).reverse();
            if (sub) {
                String nes = st2.toString();
                es = es + nes.substring(1);
            } else
                es = es + st2.toString();

        }
        return es;

    }
}
// @lc code=end

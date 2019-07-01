package com.dreamhigh.leetcode.StringFun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringFunction {
    /**
     * 无重复字符的最长子串
     * 暴力法
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                Set<Character> set = new HashSet<>();
                boolean flag = true;
                for (int k = i; k < j; k++) {
                    Character ch = s.charAt(k);
                    if (set.contains(ch))
                        flag = false;
                    set.add(ch);
                }
                if (flag)
                    res = Math.max(res, j - i);
            }
        }
        return res;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring02(String s) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int end=0,start=0;end<s.length();end++){
            if (map.containsKey(s.charAt(end))){
                start = Math.max(map.get(s.charAt(end)),start);;
            }
            res=Math.max(res,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return res;
    }
}

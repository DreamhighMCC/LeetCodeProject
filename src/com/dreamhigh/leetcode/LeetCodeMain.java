package com.dreamhigh.leetcode;

import com.dreamhigh.leetcode.List.ListAdd;
import com.dreamhigh.leetcode.List.ListNode;

import java.util.*;

public class LeetCodeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            List<String> chlist=new ArrayList<>();
            List<Integer> countList = new ArrayList<>();
            for(int i = 0; i < str.length(); i++){
                String s = str.charAt(i) + "";
                if (chlist.contains(s)){
                    countList.set(chlist.indexOf(s),countList.get(chlist.indexOf(s))+1);
                }else {
                    chlist.add(s);
                    countList.add(1);
                }
            }
            for(int i=0;i<countList.size();i++){
                for(int j=0;j<countList.size()-i-1;j++){
                    if(countList.get(j+1)>countList.get(j)){
                        int tmpn = countList.get(j+1);
                        countList.set(j+1,countList.get(j));
                        countList.set(j,tmpn);
                        String tmpS = chlist.get(j+1);
                        chlist.set(j+1,chlist.get(j));
                        chlist.set(j,tmpS);
                    }
                }
            }
            for (int i=0;i<chlist.size();i++){
                System.out.println(chlist.get(i)+"="+countList.get(i));
            }
//            Map<String, Integer> map = new HashMap<>();
//            for (int i = 0; i < str.length(); i++) {
//                String s = str.charAt(i) + "";
//                if (map.containsKey(s)) {
//                    int value = map.get(s);
//                    map.put(s, value + 1);
//                } else {
//                    map.put(s, 1);
//                }
//            }
//            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
//            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//                        @Override
//                        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                            // return o1.getValue() - o2.getValue();//从小到大排序
//                            return o2.getValue() - o1.getValue();//从大到小排序
//                        }
//                    }
//            );
//            for (Map.Entry<String, Integer> m : list) {
//                System.out.println(m.getKey() + "---" + m.getValue());
//            }
            //split(s);
        }
    }

    public static void split(String s) {
        while (s.length() >= 8) {
            System.out.println(s.substring(0, 8));
            s = s.substring(8);
        }
        if (s.length() < 8 && s.length() > 0) {
            s = s + "00000000";
            System.out.println(s.substring(0, 8));
        }
    }
//    public static void main(String[] args){
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(8);
//        ListNode l2 = new ListNode(0);
//        ListAdd listAdd = new ListAdd();
//        listAdd.addTwoNumbers(l1,l2);
//    }
}

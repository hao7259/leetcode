package others;

import java.util.*;

public class test {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        int max=0;
        int mkey=0;
        for(int key:map.keySet()) {
            if(map.get(key)>max) {
                max=map.get(key);
                mkey = key;
            }
        }
        return mkey;
    }
}


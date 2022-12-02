
import MyMap.MyMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyMap<Integer, Integer> map = new MyMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));
        System.out.println(map.remove(2));
        for (Integer i: map.keyList()) {
            System.out.println(i);
        }


    }
}

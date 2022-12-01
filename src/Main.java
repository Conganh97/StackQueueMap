
import MyMap.MyMap;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyMap<Integer,Integer> map = new MyMap<Integer,Integer>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,3);
        map.put(5,3);
        map.put(6,3);
        map.put(7,3);
        map.put(8,3);
        map.put(9,3);
        map.put(10,3);
        map.put(11,3);
        map.put(12,3);
        map.put(13,3);



        System.out.println("Node key:");

        System.out.println(map.nodeList().get(0).getHash());
        System.out.println(map.nodeList().get(1).getHash());
        System.out.println(map.nodeList().get(2).getHash());
        System.out.println(map.nodeList().get(3).getHash());
        System.out.println(map.nodeList().get(4).getHash());
        System.out.println(map.nodeList().get(5).getHash());
        System.out.println(map.nodeList().get(6).getHash());


    }
}
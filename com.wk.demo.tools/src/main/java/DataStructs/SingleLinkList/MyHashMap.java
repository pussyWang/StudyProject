package DataStructs.SingleLinkList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * PackageName DataStructs.SingleLinkList
 * Created by wangkang on 2017/12/18.
 */
public class MyHashMap {
    private static void testHashMap(){
        Map<Integer,String> hashmap = new HashMap<Integer, String>();
        hashmap.put(1,"1");
        hashmap.put(5,"5");
        hashmap.put(2,"2");
        hashmap.put(4,"4");
        System.out.println("hashmap:");
        for (Map.Entry<Integer,String> entry : hashmap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    private static void testLinkedHashMap(){
        Map<Integer,String> hashmap = new LinkedHashMap<Integer, String>();
        hashmap.put(1,"1");
        hashmap.put(5,"5");
        hashmap.put(2,"2");
        hashmap.put(4,"4");
        System.out.println("linkedhashmap:");
        for (Map.Entry<Integer,String> entry : hashmap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    private static void testTreeHashMap(){
        Map<Integer,String> hashmap = new TreeMap<Integer, String>();
        hashmap.put(1,"1");
        hashmap.put(5,"5");
        hashmap.put(2,"2");
        hashmap.put(4,"4");
        System.out.println("treehashmap:");
        for (Map.Entry<Integer,String> entry : hashmap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        Map<String,String> treemap = new TreeMap<String, String>();
        treemap.put("a","adsa");
        treemap.put("f","adsa");
        treemap.put("s","adsa");
        treemap.put("b","adsa");
        treemap.put("e","adsa");
        System.out.println("treemap test key is string");
        for (Map.Entry<String,String> entry : treemap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        testHashMap();
        testLinkedHashMap();
        testTreeHashMap();
        System.exit(0);
    }
}

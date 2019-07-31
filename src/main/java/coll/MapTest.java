package coll;

import bo.TestBO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> map= Maps.newHashMap();
        if (map.get("1")==null){
            map.put("1",1);
        }
        System.out.println(map);

        map.putIfAbsent("2",1);
        System.out.println(map);

        map.putIfAbsent("2",2);
        System.out.println(map);

        map.put("2",map.get("2")+1);
        System.out.println(map);

        map.merge("2", 1, (a, b)->a+b);
        System.out.println(map);

        List<TestBO> testBOS= Lists.newArrayList();
        TestBO testBO=new TestBO();
        testBO.setId(1);
        testBO.setNum(10);
        testBOS.add(testBO);
        testBOS.forEach(a->{

        });
    }
}

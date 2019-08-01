package lambda;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import other.Compare;
import other.TT;
import other.TTA;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class MyTest {

    public void test1() {
        class Coll {
            void test1(List<Integer> list) {
                List<Integer> oldList = Lists.newArrayList(list);
                list.add(4);
                System.out.println(list);
                list.clear();
                list.addAll(oldList);
            }

            void test2(Map<String, Integer> map) {
                Map<String, Integer> oldMap = Maps.newHashMap(map);
                map.put("3", 3);
                System.out.println(map);
                map.clear();
                map.putAll(oldMap);
            }
        }
        Coll coll = new Coll();
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        coll.test1(list);
        System.out.println(list);

        Map<String, Integer> map = Maps.newHashMap();
        map.put("1", 1);
        map.put("2", 2);
        System.out.println(map);
        coll.test2(map);
        System.out.println(map);
    }

    public void test2() {
        class Bean {
            private Integer id;
            private BigDecimal n;

            Bean(Integer id, BigDecimal n) {
                this.id = id;
                this.n = n;
            }

            BigDecimal getN() {
                return n;
            }

            public void setN(BigDecimal n) {
                this.n = n;
            }

            Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "Bean{" + "id=" + id + ", n=" + n + '}';
            }
        }
        Bean n1 = new Bean(1, new BigDecimal("1"));
        Bean n2 = new Bean(2, new BigDecimal("4"));
        Bean n3 = new Bean(3, new BigDecimal("4"));
        List<Bean> list = Lists.newArrayList(n1, n2, n3);
        Bean no = list.stream().max(Comparator.comparing(Bean::getN)).get();
        System.out.println(no);

        System.out.println(list.toString());
        Map<Integer, BigDecimal> map=list.stream().collect(Collectors.toMap(Bean::getId, Bean::getN, BigDecimal::add));
        System.out.println(map);
        System.out.println(list.stream().filter(a->a.id==2).collect(Collectors.toList()).toString());
    }

    public void test5() {
        Map<String, Double> stockBind = Maps.newHashMap();
        stockBind.put("1", 0d);
        stockBind.put("2", 0d);
        stockBind.put("0", null);
        System.out.println(stockBind);
        Map<String, Double> map1 = Maps.filterValues(stockBind, a -> a != null && a != 0);
        Map<String, Double> map2 = Maps.filterEntries(stockBind, a -> a.getValue() != null);
        Map<String, Double> map3 = Maps.filterKeys(stockBind, StringUtils::isNotBlank);
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
        if (map1.isEmpty()) {
            System.out.println("空");
        }
        System.out.println(Lists.reverse(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
    }

    public void test7() {
        Map<String, Integer> map = Maps.newHashMap();
        System.out.println(map);
        map.merge("1", -5, (a, b) -> a + b);
        System.out.println(map);
        map.merge("1", 11, (a, b) -> a + b);
        System.out.println(map);

        int[] n = {2, 2, 1};
        int m = n[2];
        for (int a : n) {
            m = a ^ m;
            System.out.println(m);
        }
        System.out.println(Arrays.stream(n).reduce((x, y) -> x ^ y).getAsInt());

    }

    public void test8() {
        char[] s = {'1', '2', '3', '4', '5'};
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(s);
    }

    public void test9() {
        Set<Integer> groupBOS = Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2);
        String n = StringUtils.join(groupBOS, ",");
        System.out.println(n);
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("key_1", 1);
        map.put("key_2", 3);
        map.put("key_3", 2);
        System.out.println(map);
    }

    public void test10() {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < 10000; i++) {
            map.put(i, i);
        }
        for (int i = 0; i < 10000; i++) {
            map.get(i);
        }
        for (int i = 0; i < 10000; i++) {
            map.remove(i);
        }
        System.out.println(map);
    }

    public void test11() {
        TreeMap<Integer, Integer> map = Maps.newTreeMap();
        for (int i = 0; i < 10000; i++) {
            map.put(i, i);
        }
        for (int i = 0; i < 10000; i++) {
            map.get(i);
        }
        for (int i = 0; i < 10000; i++) {
            map.remove(i);
        }
        System.out.println(map);
    }

    public void test12() {
        long n = System.currentTimeMillis();
        List<Integer> list = Lists.newLinkedList();
        for (int i = 0; i < 50000; i++) {
            list.add(0, i);
        }
        System.out.println(System.currentTimeMillis() - n);
    }

    public void test13() {
        long n = System.currentTimeMillis();
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 50000; i++) {
            list.add(0, i);
        }
        System.out.println(System.currentTimeMillis() - n);
    }

    public void test14() {
        List<Integer> d = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        Integer[] dd = {4, 4};
        d.toArray(dd);
        System.out.println(d);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(System.out::print);
        System.out.println();
        numbers.parallelStream().forEach(System.out::print);

    }

    public void test15() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });
        thread.start();


        Thread thread1 = new Thread(() -> System.out.println(2));
        thread1.start();
    }

    public void test16() {
        List<Integer> list = Lists.newArrayList(3, 7, 5, 8, 4, 1, 2);
        System.out.println(list);
        list.sort(Comparator.comparing(a -> a));
        System.out.println(list);
        TT tt = new TT((a, b) -> {
            return a - b;
        });
        System.out.println(tt.max(11, 9));
        System.out.println(tt.bigger(11, 9));

        Compare compare = new Compare() {
            @Override
            public int compareTo(int a, int b) {
                return a - b;
            }
        };

        TTA tta = new TTA(() -> System.out.println(1));

        TT t2 = new TT(new Compare() {
            @Override
            public int compareTo(int a, int b) {
                return a - b;
            }
        });

        Map<String, Integer> map = Maps.newHashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.replace("a", 1, 3);
        System.out.println(map);
    }

    public void test17() {
        Map<Date, Date> arriveDate = Maps.newHashMap();
        Optional startDate = arriveDate.keySet().stream().min(Date::compareTo);
        if (startDate.isPresent()) {
            Date minDate = (Date) startDate.get();
            System.out.println(minDate);
        }
    }

    public void test18() {
        LinkedList<Integer> list = Lists.newLinkedList();
        list.add(3);
        list.add(7);
        list.add(5, 6);
        System.out.println(list.getLast());
    }

}
package coll;

import bo.TestBO;
import com.google.common.collect.Lists;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    private int x=1;

    public List<TestBO> addData(){
        List<TestBO> list = Lists.newArrayList();
        for (int i=0;i<150000;i++){
            TestBO testBO=new TestBO();
            testBO.setId(i);
            testBO.setNum(i);
            list.add(testBO);
        }
        return list;
    }

    public void execIterator(List<TestBO> list){
        Date start=new Date();
        for (int n=0;n<x;n++){
            Iterator iter = list.iterator();
            while(iter.hasNext()){
                TestBO i=(TestBO)iter.next();
                i.setNum(i.getId());
            }
        }
        Date end=new Date();
        System.out.println("Iterator:"+(end.getTime()-start.getTime()));
    }

    public void execForEach(List<TestBO> list){
        Date start=new Date();
        for (int n=0;n<x;n++) {
            for (TestBO i : list) {
                i.setNum(i.getId());
            }
        }
        Date end=new Date();
        System.out.println("foreach:"+(end.getTime()-start.getTime()));
    }

    public void execLambda(List<TestBO> list){
        Date start=new Date();
        for (int n=0;n<x;n++) {
            list.forEach(i -> {
                i.setNum(i.getId());
            });
        }
        Date end=new Date();
        System.out.println("lambda:"+(end.getTime()-start.getTime()));
    }

    public static void main(String[] args) {
        ListTest test = new ListTest();
        List<TestBO> list = test.addData();
        test.execForEach(list);
        test.execIterator(list);
        test.execLambda(list);
    }
}

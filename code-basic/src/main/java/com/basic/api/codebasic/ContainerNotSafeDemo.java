package com.basic.api.codebasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerNotSafeDemo {
    public void test(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        List<Integer> list1 = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list2 = new CopyOnWriteArrayList<>();

    }
}

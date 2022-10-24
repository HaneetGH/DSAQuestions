package com.technorapper.dsaquestions.list;

import java.util.ArrayList;
import java.util.List;

public class ListRelated {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            integerList.add(i);
        integerList.add(0,88); // Add item at zero and lift other one step up
        integerList.set(0,99); // update value of 0 index

        System.out.println(integerList);
        test();
    }
    static void  test(){
        int i =0;
        int sum =0;
        while(i<100){
            sum=sum+1;
            sum=i+sum;
            i+=1;
        }

        System.out.println(sum);
    }
}

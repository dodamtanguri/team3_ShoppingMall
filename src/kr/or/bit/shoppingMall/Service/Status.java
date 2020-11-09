package kr.or.bit.shoppingMall.Service;

import java.util.ArrayList;

public class Status {
    private ArrayList exceptions;
    public Status() {
        exceptions = new ArrayList();
    }
//    public static boolean isSuccessful(){
//        return exceptions.size() ==0;
//    }
    public void addException(Exception ex) {
        exceptions.add(ex);
    }

//    public iterator getExceptions() {
//        return exceptions.iterator();
//    }

}

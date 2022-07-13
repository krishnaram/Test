package com.basic;

/*package whatever //do not write package name here */

import java.io.*;

public class ExtendMethod {
    public static void main (String[] args) {
        Hack3 hackObj= new Hack3();
        hackObj.print();
    }
}
class Hack{
    protected static String hacker = "hello hacker";
}
class Hack2 extends Hack{

}
class Hack3 extends Hack2{
    static void print(){
        Hack2.hacker = "hello";
        System.out.println(hacker);
    }
}
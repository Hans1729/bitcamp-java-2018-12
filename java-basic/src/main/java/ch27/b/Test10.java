// reflection API - 배열 항목의 타입 알아내기
package ch27.b;

import java.sql.Date;

public class Test10 {

  public static void main(String[] args) throws Exception {
    // 배열 타입이 아닌 경우 항목이 없기 때문에 getComponentType()의 리턴 값은 Null이다.
    System.out.println(byte.class.getComponentType());
    
    System.out.println(new byte[]{}.getClass().getName());
    System.out.println(new byte[]{}.getClass().getComponentType().getName());
    
    System.out.println(new int[]{}.getClass().getName());
    System.out.println(new short[]{}.getClass().getName());
    System.out.println(new long[]{}.getClass().getName());
    System.out.println(new float[]{}.getClass().getName());
    System.out.println(new double[]{}.getClass().getName());
    System.out.println(new boolean[]{}.getClass().getName());
    System.out.println(new char[]{}.getClass().getName());
    System.out.println(new String[]{}.getClass().getName());
    System.out.println(new Date[]{}.getClass().getName());
    
    
   
    }
  }








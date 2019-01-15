// 생성자 활용 - java.util.Date 클래스의 생성자
package ch10;

import java.util.Date;

public class Test15 {
  public static void main(String[] args) throws Exception {
    
    // Date() 기본 생성자
    Date d1 = new Date(); // 현재 시간을 저장한다.
    System.out.println(d1);
    
    // Date(long) : 1970-01-01 00:00:00 부터 지금까지 경과된 밀리초 
    Date d2 = new Date(100);
    System.out.println(d2);
    
    Date d3 = new Date(System.currentTimeMillis());
    System.out.println(d3);

    Date d4 = new Date(119, 0, 15);
    System.out.println(d4);
    
    // java.sql.Date
    java.sql.Date d5 = new java.sql.Date(System.currentTimeMillis());
    System.out.println(d5);
    
    // 간접적으로 객체를 생성하기
    java.sql.Date d6 = java.sql.Date.valueOf("2019-1-16");
    System.out.println(d6);
  }
}

















// 바이너리 데이터 입출력 - FileInputStream 클래스 사용법
package ch22.c;

import java.io.FileInputStream;

public class Test01_1 {
 // 배열 단위로 출력하기
  public static void main(String[] args) {
     // 배열 값 출력
    try {
      FileInputStream in = new FileInputStream("jls11.pdf");
      long start = System.currentTimeMillis();
      
    byte buf = new byte[1000];
    int count = 0;
     while((count = in.read(buf)) != -1) {
       if(++count % 1000 == 0)
         System.out.println(".");
     
       if(count % 20000 == 0) 
         System.out.println();
    }
     System.out.println();
  
  }catch(Exception e)
  {
      e.printStackTrace();
    }System.out.println("출력 완료!");


  }}

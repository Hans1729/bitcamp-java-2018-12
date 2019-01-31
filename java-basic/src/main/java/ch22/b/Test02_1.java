// 바이너리 데이터 입출력 - FileInputStream 클래스 사용법
package ch22.b;

import java.io.FileOutputStream;

public class Test02_1 {
 // 배열 단위로 출력하기
  public static void main(String[] args) {
     // 배열 값 출력
    try {
      FileOutputStream out = new FileOutputStream("data.bin");
      byte[] bytes = { 0x11, 0x22 , 0x33, 0x44, 0x55, 0x66};
      
      // write(byte[] : 배열 전체의 값을 출력한다) 
        // write(byte[] , 첫번째 ,마지막 값을 출력한다) 
      out.write(bytes); // 배열 전체를 출력한다.
       
      out.close();
      // 2) 데이터를 출력한다.
      // => write(int) : 1바이트를 출력한다.
  
  }catch(Exception e)
  {
      e.printStackTrace();
    }System.out.println("출력 완료!");


}}

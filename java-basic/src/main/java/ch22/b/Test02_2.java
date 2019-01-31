// 바이너리 데이터 입출력 - FileInputStream : 배열로 읽기
package ch22.b;

import java.io.FileOutputStream;

public class Test02_2 {

  public static void main(String[] args) {
     // 파일의 바이너리 데이터를 읽어 배열에 저장한다.
    try {
      FileOutputStream out = new FileOutputStream("data.bin");
      byte[] buf = new byte[1024];

      int count = in.read(buf)
      out.close();
      // 2) 데이터를 출력한다.
      // => write(int) : 1바이트를 출력한다.
      int b;
      
      while (true) {
        b = in.read();
        if (b == -1) // 파일의 끝에 도달하면 -1를 리턴한다 .
          break;
        System.out.print(Integer.toHexString(b) + " ");
        System.out.println();
  }catch(Exception e)
  {
      e.printStackTrace();
    }System.out.println("출력 완료!");


}}

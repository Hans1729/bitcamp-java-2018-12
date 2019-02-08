// 계산기 클라이언트 만들기
package ch23.c;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * 실행 예 - 클라이언트가 계산기 서버에 접속한 후
 * 
 * > 계산기 서버에 오신 걸 환영합니다! <== 서버의 응답 > 
 * 계산식을 입력하세요! <== 서버의 응답
 *  예) 23 + 7 <==서버의 응답
 * 
 * > 23 + 7 <== 사용자의 입력, '>' 문자는 클라이언트에서 출력한다. 
 * 결과는 30입니다. <== 서버의 응답 > 23 ^ 7 <== 사용자의 입력. '>' 문자는
 * 클라이언트에서 출력한다. ^ 연산자를 지원하지 않습니다. <== 서버의 응답 
 * > ok + yes <== 사용자의 입력 식의 형식이 잘못되었습니다. 
 *   <== 서버의 응답 >
 * quit <== 사용자의 입력. '>' 문자는 클라이언트에서 출력한다.
 *  안녕히 가세요! <== 서버의 응답
 */
public class CalculatorServer {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {
      
      System.out.println("계산기 서버에 오신 걸 환영합니다!");
      keyboard.nextLine();
      
      try (
        // 대기열에서 클라이언트를 한 개 꺼낸다.
        // - 대기열에 클라이언트 정보가 없다면 있을 때까지 기다린다. 리턴하지 않는다.
        //   즉 blocking 모드로 작동한다.
        Socket socket = serverSocket.accept();
        
        // 클라이언트와 데이터를 주고 받을 입출력 스트림 객체를 준비한다.
        // => 출력 스트림 객체를 준비하기
        OutputStream out = socket.getOutputStream();
        
        // => 입력 스트림 객체를 준비하기
        InputStream in = socket.getInputStream()) {
        
        System.out.println("계산식을 입력하세요! \n 예) 23+7");
        
        System.out.print("데이터를 읽기 전에 잠깐!");
        keyboard.nextLine(); // 사용자가 콘솔창에서 엔터를 칠 때까지 리턴하지 않는다.
        
        // => 클라이언트가 1바이트를 때까지 리턴하지 않는다.
        int request = in.read(); // blocking 모드로 작동한다.
        System.out.println(request);

        // 서버가 데이터를 보내지 않으면 클라이언트의 read()는 리턴하지 않는다.
        // 이를 확인하기 위해 잠시 실행을 멈춘다.
        System.out.print("데이터를 보내기 전에 잠깐!");
        keyboard.nextLine();
        
        // => 클라이언트에게 받은 문자열을 그대로 보낸다.
        //    물론 클라이언트가 보낸 데이터를 다 읽을 때까지 리턴하지 않는다.
        out.write(100 / 3);
        System.out.println("클라이언트에게 데이터를 보냈음.");
        
      }
      System.out.println("클라이언트와의 연결을 끊었음.");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }

}


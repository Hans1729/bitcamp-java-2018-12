// 8단계: 클라이언트 요청을 처리하는 클래스에 대해 리펙토링 수행
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class ServerTest {

  static ObjectOutputStream out;
  static ObjectInputStream in;
  
  public static void main(String[] args) {
    
    try (Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      
      System.out.println("서버와 연결되었음.");
      ServerTest.in = in;
      ServerTest.out = out;
      
     
     new MemberTest(out, in).test();
     System.out.println("---------------------------------------");
     
     new LessonTest(out, in).test();
     System.out.println("---------------------------------------");
     
     new BoardTest(out, in).test();
     System.out.println("---------------------------------------");
     
     
      quit();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음.");
  }
  
  static void add(Member member) throws Exception {
    out.writeUTF("/member/add"); 
    out.writeObject(member);
    out.flush();
    
    String status = in.readUTF();
    
    if (status.equals("OK"))
      System.out.println("데이터 추가 성공!");
    else
      System.out.println("데이터 추가 실패!");
  }
  
  static void list() throws Exception {
    out.writeUTF("/member/list"); 
    out.flush();
    
    String status = in.readUTF();
    
    if (!status.equals("OK")) {
      System.out.println("데이터 목록 가져오기 실패!");
      return;
    }
    
    @SuppressWarnings("unchecked")
    List<Member> members = (List<Member>) in.readObject();
    for (Member m : members) {
      System.out.println(m);
    }
  }
  
  static void detail(int no) throws Exception {
    out.writeUTF("/member/detail");
    out.writeInt(no);
    out.flush();
    
    String status = in.readUTF();
    
    if (!status.equals("OK")) {
      System.out.println("데이터 가져오기 실패!");
      return;
    }
    
    Member member = (Member) in.readObject();
    System.out.println(member);
  }
  
  static void update(Member member) throws Exception {
    out.writeUTF("/member/update");
    out.writeObject(member);
    out.flush();
    
    String status = in.readUTF();
    
    if (status.equals("OK"))
      System.out.println("데이터 변경 성공!");
    else
      System.out.println("데이터 변경 실패!");
  }
  
  static void delete(int no) throws Exception {
    out.writeUTF("/member/delete");
    out.writeInt(no);
    out.flush();
    
    String status = in.readUTF();
    
    if (status.equals("OK"))
      System.out.println("데이터 삭제 성공!");
    else
      System.out.println("데이터 삭제 실패!");
  }
  
  static void quit() throws Exception {
    out.writeUTF("quit"); out.flush();
    System.out.println(in.readUTF());
  }

}

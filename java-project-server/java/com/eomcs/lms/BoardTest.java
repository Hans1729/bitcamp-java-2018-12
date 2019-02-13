// 6단계: 서버 실행 테스트
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardTest {

   ObjectOutputStream out; //인스턴스
   ObjectInputStream in;
  public BoardTest(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }
  public void test() throws Exception {
    add(new Board(1, "내용내용"));
    add(new Board(2, "내용입니다"));
    
    detail(1);
    
    update(new Board(1, "내용내용22"));
    
    detail(1);
    
    delete(2);
    
    list();
    
    quit();
  }
  public static void main(String[] args) {
    
    try (Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      
      System.out.println("서버와 연결되었음.");

     
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음.");
  }
  
   private void add(Board board) throws Exception {
    out.writeUTF("/board/add"); 
    out.writeObject(board);
    out.flush();
    if(!in.readUTF().equals("ok"))
      return;
    
    String status = in.readUTF();
    
    if (status.equals("OK"))
      System.out.println("데이터 추가 성공!");
    else
      System.out.println("데이터 추가 실패!");
  }
  
   private void list() throws Exception {
    out.writeUTF("/board/list"); 
    out.flush();
    if(!in.readUTF().equals("ok"))
      return;
    
    String status = in.readUTF();
    
    if (!status.equals("OK")) {
      System.out.println("데이터 목록 가져오기 실패!");
      return;
    }
    
    @SuppressWarnings("unchecked")
    List<Board> boards = (List<Board>) in.readObject();
    for (Board b : boards) {
      System.out.println(b);
    }
  }
  
   private void detail(int no) throws Exception {
    out.writeUTF("/board/detail");
    if(!in.readUTF().equals("ok"))
      return;
    out.writeInt(no);
    out.flush();
    
    String status = in.readUTF();
    
    if (!status.equals("OK")) {
      System.out.println("데이터 가져오기 실패!");
      return;
    }
    
    Board board = (Board) in.readObject();
    System.out.println(board);
  }
  
   private  void update(Board board) throws Exception {
    out.writeUTF("/board/update");
    if(!in.readUTF().equals("ok"))
      return;
    out.writeObject(board);
    out.flush();
    
    String status = in.readUTF();
    
    if (status.equals("OK"))
      System.out.println("데이터 변경 성공!");
    else
      System.out.println("데이터 변경 실패!");
  }
  
   private void delete(int no) throws Exception {
    out.writeUTF("/board/delete");
    if(!in.readUTF().equals("ok"))
      return;
    out.writeInt(no);
    out.flush();
    
    String status = in.readUTF();
    
    if (status.equals("OK"))
      System.out.println("데이터 삭제 성공!");
    else
      System.out.println("데이터 삭제 실패!");
  }
  
   private void quit() throws Exception {
    out.writeUTF("quit"); out.flush();
    System.out.println(in.readUTF());
  }

}

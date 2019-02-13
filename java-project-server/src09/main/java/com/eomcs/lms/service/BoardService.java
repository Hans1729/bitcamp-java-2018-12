// 8단계: 클라이언트 요청을 처리하는 클래스에 대해 리펙토링 수행
package com.eomcs.lms.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.eomcs.lms.domain.Board;

// 클라이언트의 요청을 처리하는 클래스라는 의미로
// 클래스명을 *Service로 변경한다.
public class BoardService {

   ArrayList<Board> boards = new ArrayList<>();

   ObjectInputStream in;
   ObjectOutputStream out;
   
   public BoardService(ObjectInputStream in , ObjectOutputStream out) { // 인스턴스 필드 와 인스턴스 메서드로 변환
     this.in = in;
     this.out = out; 
   }

  public  void execute(String request) throws Exception{


    switch (request) {
      case "/board/add":
        add();
        break;
      case "/board/list":
        list();
        break;
      case "/board/detail":
        detail();
        break;
      case "/board/update":
        update();
        break;
      case "/board/delete":
        delete();
        break;
      default:
        out.writeUTF("이 명령을 처리할 수 없음!");
    }
    out.flush();
  }



  private void quit() throws Exception {
  out.writeUTF("종료함!");
  out.flush();
}

 private void add() throws Exception {
  out.writeUTF("OK");
  out.flush();

  boards.add((Board) in.readObject());
  out.writeUTF("OK");
}

 private void list() throws Exception {
  out.writeUTF("OK");
  out.flush();

  out.writeUTF("OK");
  out.writeObject(boards);
}

 private void detail() throws Exception {
  out.writeUTF("OK");
  out.flush();

  int no = in.readInt();

  for (Board m : boards) {
    if (m.getNo() == no) {
      out.writeUTF("OK");
      out.writeObject(m);
      return;
    }
  }

  out.writeUTF("FAIL");
}

 private void update() throws Exception {
  out.writeUTF("OK");
  out.flush();

  Board board = (Board) in.readObject();

  int index = 0;
  for (Board m : boards) {
    if (m.getNo() == board.getNo()) {
      boards.set(index, board);
      out.writeUTF("OK");
      return;
    }
    index++;
  }

  out.writeUTF("FAIL");
}

private void delete() throws Exception {
  out.writeUTF("OK");
  out.flush();

  int no = in.readInt();

  int index = 0;
  for (Board m : boards) {
    if (m.getNo() == no) {
      boards.remove(index);
      out.writeUTF("OK");
      return;
    }
    index++;
  }

  out.writeUTF("FAIL");
}

}



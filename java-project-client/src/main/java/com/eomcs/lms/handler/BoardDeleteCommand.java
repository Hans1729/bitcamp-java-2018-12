package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class BoardDeleteCommand implements Command {

  Scanner keyboard;

  public BoardDeleteCommand(Scanner keyboard) {
    this.keyboard = keyboard;

  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      out.writeUTF("/board/delete");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK"))
        throw new Exception("서버에서 게시글 삭제하기 실패");
  
      System.out.println("삭제하였습니다.");

    } catch (Exception e) {
      System.out.printf("게시글 삭제 정보 출력 오류! : %s\n", e.getMessage());
    }
  }



}

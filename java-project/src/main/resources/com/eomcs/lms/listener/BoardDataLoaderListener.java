package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class BoardDataLoaderListener implements ApplicationListener{

  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("시작전 ");
    
  }

  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("시작 후");
    
  }


  @SuppressWarnings("unchecked")
  private List<Board> loadBoardData() {
    try(ObjectInputStream in =
        new ObjectInputStream( 
            new BufferedInputStream(
                new FileInputStream("board3.data")))){
     return List = (ArrayList<Board>) in.readObject();

      
      
    } catch (Exception e) {
      System.out.println("게시글 데이터를 읽는 중 오류 발생: " + e.toString());
      return List = new ArrayList<>();
    }
  }


  private List<Board> void saveBoardData() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("board4.data")))) {
               
               out.writeObject(boardList);
     
    } catch (Exception e) {
      System.out.println("게시글 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }
}



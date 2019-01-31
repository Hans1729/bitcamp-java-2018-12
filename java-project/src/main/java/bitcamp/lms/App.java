package bitcamp.lms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import bitcamp.lms.domain.Board;
import bitcamp.lms.domain.Lesson;
import bitcamp.lms.domain.Member;
import bitcamp.lms.handler.BoardAddCommand;
import bitcamp.lms.handler.BoardDeleteCommand;
import bitcamp.lms.handler.BoardDetailCommand;
import bitcamp.lms.handler.BoardListCommand;
import bitcamp.lms.handler.BoardUpdateCommand;
import bitcamp.lms.handler.Command;
import bitcamp.lms.handler.LessonAddCommand;
import bitcamp.lms.handler.LessonDeleteCommand;
import bitcamp.lms.handler.LessonDetailCommand;
import bitcamp.lms.handler.LessonListCommand;
import bitcamp.lms.handler.LessonUpdateCommand;
import bitcamp.lms.handler.MemberAddCommand;
import bitcamp.lms.handler.MemberDeleteCommand;
import bitcamp.lms.handler.MemberDetailCommand;
import bitcamp.lms.handler.MemberListCommand;
import bitcamp.lms.handler.MemberUpdateCommand;
<<<<<<< HEAD

=======
>>>>>>> 8e750c930de10b9752559e6935da084bd2113386

public class App {

  static Scanner keyboard = new Scanner(System.in);

  // 사용자가 입력한 명령을 보관할 스택 준비
  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();
  static ArrayList<Lesson> lessonlist = new ArrayList<>();

  public static void main(String[] args) {

    loadLessonDate();

    HashMap<String, Command> CommandMap = new HashMap<>();
<<<<<<< HEAD
    ArrayList<Member> memberlist = new ArrayList<>();
    ArrayList<Board> boardlist = new ArrayList<>();


    CommandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonlist));
    CommandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonlist));
    CommandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonlist));
    CommandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonlist));
    CommandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonlist));

    CommandMap.put("/member/add", new MemberAddCommand(keyboard, memberlist));
    CommandMap.put("/member/list", new MemberListCommand(keyboard, memberlist));
    CommandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberlist));
    CommandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberlist));
    CommandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberlist));
=======
    
    ArrayList<Lesson> lessonlist = new ArrayList<>();
    
    
    
    
    ArrayList<Member> memberlist = new ArrayList<>();
    ArrayList<Board> boardlist = new ArrayList<>();
    
>>>>>>> 8e750c930de10b9752559e6935da084bd2113386

    
    CommandMap.put("/Lesson/add", new LessonAddCommand(keyboard, lessonlist));
    CommandMap.put("/Lesson/list", new LessonListCommand(keyboard, lessonlist));
    CommandMap.put("/Lesson/detail", new LessonDetailCommand(keyboard, lessonlist));
    CommandMap.put("/Lesson/update", new LessonUpdateCommand(keyboard, lessonlist));
    CommandMap.put("/Lesson/delete", new LessonDeleteCommand(keyboard, lessonlist));
    
    
    CommandMap.put("/board/add", new BoardAddCommand(keyboard, boardlist));
    CommandMap.put("/board/list", new BoardListCommand(keyboard, boardlist));
    CommandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardlist));
    CommandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardlist));
    CommandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardlist));
    
    CommandMap.put("/member/add", new MemberAddCommand(keyboard, memberlist));
    CommandMap.put("/member/list", new MemberListCommand(keyboard, memberlist));
    CommandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberlist));
    CommandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberlist));
    CommandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberlist));



    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);

      if (command.equals("quit")) {
        quit();
        break;
      } else if (command.equals("history")) {
        printCommandHistory(new Iterator<String>() {
          int index = commandHistory.size() - 1;

          @Override
          public boolean hasNext() {
            return index >= 0;
          }

          @Override
          public String next() {
            return commandHistory.get(index--);
          }
        });
      } else if (command.equals("history2")) {
        printCommandHistory(commandHistory2.iterator());
      } else {
        Command commandHandler = CommandMap.get(command);
        if (commandHandler == null)
          System.out.println("실행할 수 없는 명령입니다.");
        else
          commandHandler.execute();
      }
      System.out.println();
    }

    keyboard.close();
  }

  private static void printCommandHistory(Iterator<String> iterator) {
    try {
      int count = 0;
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
        if (++count % 5 == 0) {
          System.out.print(":");
          String input = keyboard.nextLine();
          if (input.equalsIgnoreCase("q"))
            break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }

  private static void quit() {
    saveLessonDate();
    System.out.println("안녕!");
  }

  private static void loadLessonDate() {
   try ( FileReader in = new FileReader("lesson.csv");
       Scanner in2 = new Scanner(in){
       
     while(true) {
       lessonlist.add(Lesson.valueOf(in2.nextLine()));
     
      
   lessonlist.add(lesson);
       }
     }
  }catch(FileNotFoundException e)
  {

    e.printStackTrace();
  }catch(
  IOException e)
  {
 
    e.printStackTrace();
  }catch(
  NoSuchElementException e)
  {
    System.out.println("수업 데이터 로딩 완료!");
  }
  }

  private static void saveLessonDate() {
    try (FileWriter out = new FileWriter("lesson.csv")) {
      for (Lesson lesson : lessonlist) {
        out.write(String.format("%s,%s,%s,%s,%s,%d,%d\n", lesson.getNo(), lesson.getTitle(),
            lesson.getContents(), lesson.getStartDate(), lesson.getEndDate(),
            lesson.getTotalHours(), lesson.getDayHours()));

      }

    } catch (IOException e) {

      e.printStackTrace();
    }
  }
}


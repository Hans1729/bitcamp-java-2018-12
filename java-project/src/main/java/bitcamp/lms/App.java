package bitcamp.lms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import bitcamp.lms.domain.Board;
import bitcamp.lms.handler.BoardAddCommand;
import bitcamp.lms.handler.BoardDeleteCommand;
import bitcamp.lms.handler.BoardDetailCommand;
import bitcamp.lms.handler.BoardHandler;
import bitcamp.lms.handler.BoardListCommand;
import bitcamp.lms.handler.BoardUpdateCommand;
import bitcamp.lms.handler.Command;
import bitcamp.lms.handler.LessonHandler;
import bitcamp.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  // 사용자가 입력한 명령을 보관할 스택 준비
  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();

  public static void main(String[] args) {
    HashMap<String, Command> CommandMap = new HashMap<>();
    
    LessonHandler lessonHandler = new LessonHandler(keyboard, new ArrayList<>());
    MemberHandler memberHandler = new MemberHandler(keyboard, new LinkedList<>());
    ArrayList<Board> boardlist = new ArrayList<>();
    BoardHandler boardHandler2 = new BoardHandler(keyboard, new LinkedList<>());

    CommandMap.put("/board/add", new BoardAddCommand(keyboard, boardlist));
    CommandMap.put("/board/list", new BoardListCommand(keyboard, boardlist));
    CommandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardlist));
    CommandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardlist));
    CommandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardlist));

    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);

      if (command.equals("quit")) {
        System.out.println("안녕!");
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
      }
       else if (command.equals("history2")) {
        printCommandHistory(commandHistory2.iterator());
      } else {
           Command commandHandler = CommandMap.get(command);
     if(commandHandler == null) 
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

  private static String prompt(){
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}


// 4단계: Command를 다루는 클래스에 대해 리펙토리 수행
// => Command를 미리 구현한 AbstractCommand 클래스 생성

package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardListCommand extends AbstractCommand {

  BoardDao boardDao;

  public BoardListCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(Response response) {

    List<Board> boards = boardDao.findAll();
    
    for (Board board : boards) {
      response.println(String.format("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount()));
    }
  }
}

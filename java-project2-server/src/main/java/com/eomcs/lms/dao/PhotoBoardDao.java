// 프록시 패턴 적용 - BoardDao에서 인터페이스를 추출한다.
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardDao {
  void insert(PhotoBoard photoBoard);
    List<PhotoBoard> findAll();
    PhotoBoard findByNo(int no);
//  int update(Board board);
//  int delete(int no);
}








package com.board2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.board2.vo.BoardPostVO;

@Mapper
public interface PostMapper {
	/**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(BoardPostVO params);

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    BoardPostVO findById(Long id);
    
    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(BoardPostVO params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<BoardPostVO> findAll();

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count();
}

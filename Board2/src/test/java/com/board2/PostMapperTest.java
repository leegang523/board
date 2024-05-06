package com.board2;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board2.mapper.PostMapper;
import com.board2.vo.BoardPostVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    //게시글 업데이트 테스트
    @Test
    void save() {
    	BoardPostVO params = new BoardPostVO();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        postMapper.save(params);

        List<BoardPostVO> posts = postMapper.findAll();
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
    }
    
    // 게시글 상세 조회 (Json문자열로 확인)
    @Test
    void findById() {
        BoardPostVO post = postMapper.findById(1L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    // 게시글 수정 테스트
    @Test
    void update() {
        // 1. 게시글 수정
        BoardPostVO params = new BoardPostVO();
        params.setId(1L);
        params.setTitle("1번 게시글 제목 수정합니다.");
        params.setContent("1번 게시글 내용 수정합니다.");
        params.setWriter("이경훈");
        params.setNoticeYn(true);
        postMapper.update(params);

        // 2. 게시글 상세정보 조회
        BoardPostVO post = postMapper.findById(1L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    // 게시글 삭제 테스트
    @Test
    void delete() {
        System.out.println("삭제 이전의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
        postMapper.deleteById(1L);
        System.out.println("삭제 이후의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
    }   
}
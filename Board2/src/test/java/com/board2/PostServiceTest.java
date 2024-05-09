package com.board2;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board2.service.PostService;
import com.board2.vo.BoardPostVO;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    PostService postService;

    @Test
    void save() {
        BoardPostVO params = new BoardPostVO();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        Long id = postService.savePost(params);
        System.out.println("생성된 게시글 ID : " + id);
    }
    
    @Test
    void update() {
    	BoardPostVO params = new BoardPostVO();
    	params.setId(3L);
    	params.setTitle("3번 게시글 제목 : 서비스 테스트 ");
        params.setContent("3번 게시글 내용 : 서비스 테스트 ");
        params.setWriter("이갱");
        params.setNoticeYn(true);
        Long id = postService.updatePost(params);
        System.out.println("수정된 게시글 ID : " + id);
        
        // 수정된 게시글 상세 조회
        BoardPostVO post = postService.findPostById(params.getId());
        Long postById = post.getId();
        String postByTitle = post.getTitle();
        String postByContent = post.getContent();
        String postWriter = post.getWriter();
        System.out.println( "작성자 : " + postWriter + " 게시글 ID : " + postById + " 게시글 제목 : " + postByTitle + " 게시글 내용 : " + postByContent );
    }
    
    @Test // 게시글 전체 조회
    void PostFindAll() {
    	List<BoardPostVO> postList = postService.findAllPost();
    	System.out.println(postList.toString());
    	
    }
}

package com.board2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board2.service.PostService;
import com.board2.vo.BoardPostVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/board2/write.do")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            BoardPostVO	post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "board2/write";
    }
    
    @PostMapping("/board2/save.do")
    public String savePost(final BoardPostVO params) {
        postService.savePost(params);
        return "redirect:/board2/list.do";
    }
}
package com.wayming.codeland.service.impl;

import com.wayming.codeland.pojo.eo.Comment;
import com.wayming.codeland.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author m969130721@163.com
 * @date 18-6-29 上午1:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;
    @Test
    public void listCommentByArticleId() {
        List<Comment> comments = commentService.listCommentByArticleId(2);
        System.out.println(comments);
    }
}
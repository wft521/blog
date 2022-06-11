package com.lrm.service;

import com.lrm.po.Comment;

import java.util.List;

/**
 * @author wu
 * @date 2022-01-19 22:22
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long id);

    Comment saveComment(Comment comment);


}

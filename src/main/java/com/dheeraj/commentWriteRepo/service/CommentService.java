package com.dheeraj.commentWriteRepo.service;

import com.dheeraj.commentWriteRepo.model.Comment;

public interface CommentService {

    public void insertComment(Comment comment);

    public void updateComment(Comment comment);
}

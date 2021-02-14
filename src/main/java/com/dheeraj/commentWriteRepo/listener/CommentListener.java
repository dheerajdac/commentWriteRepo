package com.dheeraj.commentWriteRepo.listener;

import com.dheeraj.commentWriteRepo.model.Comment;
import com.dheeraj.commentWriteRepo.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CommentListener {
    
    @Autowired
    CommentService commentService;

    @KafkaListener(topics = "comment_CUD")
    public void listen(Comment comment){
        if(comment.isEdited()){
            this.commentService.updateComment(comment);
        } else {
            this.commentService.insertComment(comment);
        }
    }
}

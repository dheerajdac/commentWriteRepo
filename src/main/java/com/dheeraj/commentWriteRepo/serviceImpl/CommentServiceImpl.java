package com.dheeraj.commentWriteRepo.serviceImpl;

import java.time.LocalDateTime;
import java.util.Calendar;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.dheeraj.commentWriteRepo.model.Comment;
import com.dheeraj.commentWriteRepo.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CassandraOperations op;

    @Override
    public void insertComment(Comment comment) {
        comment.setId(Uuids.timeBased().toString());
        comment.setCreatedOn(LocalDateTime.now());
        if(comment.getParentId() != null && !comment.getParentId().isEmpty()) {
            this.op.insert(comment);
        }
    }

    @Override
    public void updateComment(Comment comment) {
        comment.setLastModified(LocalDateTime.now());
        comment.setEdited(true);
        this.op.update(comment);
    }
    
}

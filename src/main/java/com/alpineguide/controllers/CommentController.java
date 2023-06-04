package com.alpineguide.controllers;

import com.alpineguide.entities.Comment;
import com.alpineguide.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getComments() {
        return commentService.getAllComments();
    }

    @PostMapping
    public void addNewComment(@RequestBody Comment comment) {
        commentService.createComment(comment);
    }

    @DeleteMapping(path = "{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
    }

    @PutMapping(path = "{commentId}")
    public void updateComment(
            @PathVariable("commentId") Long commentId,
            @RequestParam(required = false) String text) {
        Comment comment = commentService.getCommentById(commentId);
        comment.setContent(text);
        commentService.updateComment(comment);
    }
}

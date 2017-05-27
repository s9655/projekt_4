package com.example;

import com.example.model.Comment;
import com.example.persistence.CommentsRepository;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {

    @Autowired
    private CommentsRepository commentRepository;

    @RequestMapping("/comments")
    public List<Comment> findAll() {
        return Lists.newArrayList(this.commentRepository.findAll());
    }

    @RequestMapping(value = "/comments/add", method = RequestMethod.POST)
    public Comment addComment(@RequestBody final Comment body) {
        return this.commentRepository.save(body);
    }

    @RequestMapping(value = "/comments/remove", method = RequestMethod.POST)
    public void remove(@RequestParam("id") final Integer id) {
        this.commentRepository.delete(id);
    }
}

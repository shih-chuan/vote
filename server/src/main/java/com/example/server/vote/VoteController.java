package com.example.server.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votes")
public class VoteController {

  @Autowired
  private VoteService voteService;

  @PostMapping
  public ResponseEntity<Vote> postVote(@RequestBody VoteDto vote) {
    Vote createdVote = voteService.createVote(vote.getUserId(), vote.getOptionId());
    return ResponseEntity.status(HttpStatus.CREATED).body(createdVote);
  }

  @DeleteMapping
  public ResponseEntity<Void> deleteVote(@RequestBody VoteDto vote) {
    voteService.deleteVote(vote.getUserId(), vote.getOptionId());
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}

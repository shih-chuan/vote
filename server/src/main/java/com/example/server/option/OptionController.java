package com.example.server.option;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/options")
public class OptionController {

  @Autowired
  private OptionService optionService;

  @PostMapping
  public ResponseEntity<Option> postOption(@RequestBody Option option) {
    Option createdOption = optionService.createOption(option);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdOption);
  }

  @GetMapping
  public ResponseEntity<List<Option>> getAllOptions() {
    List<Option> options = optionService.getAllOptions();
    return ResponseEntity.ok(options);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> putOption(@PathVariable Integer id, @RequestBody Option option) {
    optionService.updateOption(id, option);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> selectOne(@PathVariable Integer id) {
    optionService.deleteOption(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}

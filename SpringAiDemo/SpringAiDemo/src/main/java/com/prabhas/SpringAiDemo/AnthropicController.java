package com.prabhas.SpringAiDemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ai.anthropic.AnthropicChatModel; // use the Anthropic chat model provided by Spring AI

@RestController
@RequestMapping("/api/anthropic")
@CrossOrigin("*")
public class AnthropicController {

    private ChatClient chatClient;

    public AnthropicController(AnthropicChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

  @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {

      String response = chatClient
              .prompt(message)
              .call()
              .content();

      return ResponseEntity.ok(response);
  }

}

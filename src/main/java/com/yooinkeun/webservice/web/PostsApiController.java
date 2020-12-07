package com.yooinkeun.webservice.web;

import com.yooinkeun.webservice.aspect.LogExecutionTime;
import com.yooinkeun.webservice.aspect.PreProcessRequestData;
import com.yooinkeun.webservice.service.posts.PostsService;
import com.yooinkeun.webservice.web.dto.PostsResponseDto;
import com.yooinkeun.webservice.web.dto.PostsSaveRequestDto;
import com.yooinkeun.webservice.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @LogExecutionTime
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @LogExecutionTime
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @LogExecutionTime
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @LogExecutionTime
    @DeleteMapping("/api/v1/posts/{id}")
    public long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}

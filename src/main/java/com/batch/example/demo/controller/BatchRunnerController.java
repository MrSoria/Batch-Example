package com.batch.example.demo.controller;

import com.batch.example.demo.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/batch")
@RequiredArgsConstructor
public class BatchRunnerController {
    
    private final BatchService batchService;
    
    @GetMapping("/execute")
    public String runBatchJob() {
        batchService.executeBatchJob();
        return "Batch job executed successfully.";
    }
}

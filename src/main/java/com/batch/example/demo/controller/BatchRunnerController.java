package com.batch.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/batch")
public class BatchRunnerController {
    @GetMapping("/execute")
    public String runBatchJob() {
        return "Batch job executed successfully.";
    }
}

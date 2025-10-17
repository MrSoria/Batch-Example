package com.batch.example.demo.service.impl;

import com.batch.example.demo.service.BatchService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
@Slf4j
public class BatchServiceImpl implements BatchService {
    private final JobLauncher jobLauncher;

    @Qualifier("batchJobBean")
    private final Job job;

    @Override
    public void executeBatchJob() {
        try {
            jobLauncher.run(job, null);
        } catch (Exception e) {
            log.error("Error executing batch job: {}", e.getMessage());
        }
    }
}

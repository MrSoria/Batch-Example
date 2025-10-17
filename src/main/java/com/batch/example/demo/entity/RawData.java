package com.batch.example.demo.entity;


import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "raw_data", schema = "batch_example")
@AllArgsConstructor
@NoArgsConstructor
public class RawData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "process_id")
    private Long processId;

    @Column(name = "type")
    private String type;

    @Column(name = "data", columnDefinition = "jsonb")
    private JsonNode data;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "status")
    private String status;
}

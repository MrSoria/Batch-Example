package com.batch.example.demo.repository;

import com.batch.example.demo.entity.RawData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RawDataRepository extends JpaRepository<RawData, Long> {
    List<RawData> findByType(String type);
    List<RawData> findByStatus(String status);
    List<RawData> findByTypeAndStatus(String type, String status);
}

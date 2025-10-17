package com.batch.example.demo.batch.writer;

import com.batch.example.demo.entity.RawData;
import com.batch.example.demo.repository.RawDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RawDataWriter implements ItemWriter<RawData> {

    private final RawDataRepository rawDataRepository;

    @Override
    public void write(Chunk<? extends RawData> chunk) throws Exception {
        rawDataRepository.saveAll(chunk.getItems());
    }
}

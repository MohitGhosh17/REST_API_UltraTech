
package org.cole.example.service;
import org.cole.example.model.Record;
import org.cole.example.repo.RecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RecordService {

    private final RecordRepository repo;

    public RecordService(RecordRepository repo) {
        this.repo = repo;
    }

    public Record createRecord(Record input) {
        LocalDateTime fixedTime = LocalDateTime.of(2025, 7, 16, 12, 0, 0);
        input.setCreatedAt(fixedTime);
        input.setModifiedAt(fixedTime);
        input.setModifiedBy("Einstein");
        return repo.save(input);
    }
}

package com.example.enoca5.core.baseRepository;

import com.example.enoca5.core.baseEntity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {
}

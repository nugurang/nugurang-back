package com.nugurang.repository;

import com.nugurang.entity.XrefThreadTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XrefThreadTagRepository extends JpaRepository<XrefThreadTagEntity, Long> {

}

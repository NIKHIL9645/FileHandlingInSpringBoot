package com.fileUpload.repository;

import com.fileUpload.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository  extends JpaRepository<Files, Long> {

    public Files findByName(String name);



}

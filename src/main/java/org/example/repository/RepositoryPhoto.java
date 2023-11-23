package org.example.repository;

import org.example.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryPhoto extends JpaRepository<Photo, Long> {
}

package com.example.demo.Repository;

import com.example.demo.Entity.eLibrary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface eLibraryRepository extends JpaRepository<eLibrary, Integer> {
    List<eLibrary> findAll();
}

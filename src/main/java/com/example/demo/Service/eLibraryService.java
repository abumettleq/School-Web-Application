package com.example.demo.Service;

import com.example.demo.Entity.eLibrary;
import com.example.demo.Repository.eLibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class eLibraryService {
    @Autowired
    private eLibraryRepository elibraryRepository;

    public List<eLibrary> getAllLibraryContents()
    {
        return elibraryRepository.findAll();
    }

}

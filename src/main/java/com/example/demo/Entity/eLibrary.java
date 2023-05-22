package com.example.demo.Entity;

import com.example.demo.Service.SubjectService;
import com.example.demo.Service.eLibraryService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Entity
@Table(name = "elibrary")
public class eLibrary {

    @Id
    @Column(name = "pdf_id")
    private int pdf_id;

    @Column(name = "title")
    private String title;

    @Column(name = "subject_id")
    private int subject_id;

    @Column(name = "about")
    private String about;

    @Column(name = "src_url")
    private String src_url;

    @Column(name = "preview_url")
    private String preview_url;

    @Column(name = "category")
    private String category;


    public String getTitle() {
        return title;
    }

    public int getPdf_id() {
        return pdf_id;
    }

    public String getAbout() {
        return about;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public String getSrc_url() {
        return src_url;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public String getCategory()
    {
        return category;
    }
}

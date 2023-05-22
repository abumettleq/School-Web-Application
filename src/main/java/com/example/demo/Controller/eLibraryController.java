package com.example.demo.Controller;


import com.example.demo.Entity.eLibrary;
import com.example.demo.Service.eLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("library")
public class eLibraryController {

    @Autowired
    eLibraryService elibraryService;

    @RequestMapping
    public String redirectToELibrary() {
        return "redirect:library/e-library";
    }

    @RequestMapping("/")
    public String emptyELibrary() {
        return "redirect:library/e-library";
    }

    @RequestMapping("e-library")
    public String elibrary(Model model)
    {
        List<eLibrary> libraryList = elibraryService.getAllLibraryContents();
        HashMap<String, List<eLibrary>> pdfMap = new HashMap<String, List<eLibrary>>();
        if (libraryList != null) {
            for (eLibrary pdf : libraryList) {
                String category = pdf.getCategory();
                if (!pdfMap.containsKey(category)) {
                    pdfMap.put(category, new ArrayList<eLibrary>());
                }
                pdfMap.get(category).add(pdf);
            }
        }

        model.addAttribute("resultsMap", pdfMap);
        return "e-library";
    }
}

package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Entity.eLibrary;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.Service.eLibraryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    eLibraryService elibraryService;

    @RequestMapping
        public String search(@RequestParam("input") String input, Model model)
    {
        List<eLibrary> libraryList = elibraryService.getAllLibraryContents();
        List<eLibrary> filteredList = new ArrayList<eLibrary>();

        if(libraryList != null)
        {
            for( eLibrary pdf : libraryList)
            {
                if(pdf.getTitle().toLowerCase().contains(input.toLowerCase()) || pdf.getAbout().toLowerCase().contains(input.toLowerCase()))
                {
                    filteredList.add(pdf);
                }
            }
        }

        model.addAttribute("filteredList", filteredList);
        model.addAttribute("input-to-search", input);
        return "library/search-page";
    }


}

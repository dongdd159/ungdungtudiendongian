package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
@Controller

public class TranslatorController {
    @GetMapping("/translates")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @PostMapping("/translates")
    public ModelAndView convert(@RequestParam String txtSearch){
        ModelAndView modelAndView;
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String result = dictionary.get(txtSearch);
        if(result != null){
            modelAndView = new ModelAndView("translate","vnese",result);
        } else {
            modelAndView = new ModelAndView("translate","vnese","not found");
        }
        return modelAndView;
    }
}

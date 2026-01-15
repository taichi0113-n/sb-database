package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.FoodDao;

@Controller
public class DBController {

   
	@Autowired
	private FoodDao foodDao;
 
    @GetMapping("/db/search")
    public ModelAndView showSearchForm(ModelAndView mav) {
        
        mav.setViewName("search"); // 例として "search.html" を指定
        return mav;
    }

    
    @GetMapping("/db/result")
    
    public ModelAndView search(@RequestParam("searchWord") String searchWord, ModelAndView mav) {
        
    	ArrayList<String> foodNameList = foodDao.selectFoodName(searchWord);
    	mav.addObject("foodNameList", foodNameList);
        mav.addObject("searchWord", searchWord);
        
        mav.addObject("word", searchWord);
        mav.setViewName("result"); 
        
        return mav;
    }
}
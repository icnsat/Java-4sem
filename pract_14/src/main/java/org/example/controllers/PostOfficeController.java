package org.example.controllers;

import org.example.entities.PostOffice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/postoffice")
public class PostOfficeController {
    public static Map<String, PostOffice> typeOfPostOffice = new HashMap<>();

    @RequestMapping("/create")
    @ResponseBody
    public PostOffice createDeparture(
            @RequestParam(name="name", required=false, defaultValue = "SomeType") String name,
            @RequestParam(name="cityname", required=false, defaultValue = "SomeDate") String cityName) {
        PostOffice postOffice = new PostOffice(name, cityName);
        typeOfPostOffice.put(name, postOffice);
        return postOffice;
    }

    //localhost:8080/postoffice/create?name=Max&cityname=London
    //localhost:8080/postoffice/create?name=Kate&cityname=Moscow


    @RequestMapping("/get-all")
    @ResponseBody
    public List<PostOffice> getAllPostOffices() {
        return new ArrayList<>(typeOfPostOffice.values());
    }

    //localhost:8080/postoffice/get-all


    @RequestMapping("/delete")
    @ResponseBody
    public List<PostOffice> deletePostOffice(
            @RequestParam(name="name", required=true) String name) {
        System.out.println();
        typeOfPostOffice.remove(name);
        return new ArrayList<>(typeOfPostOffice.values());
    }

    //localhost:8080/postoffice/delete?name=Max

}

package com.finance.account.controller;

import com.finance.account.model.User;
import com.finance.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
 @Autowired
    private UserService userService;

    @GetMapping("/add_user")
    public String getUserForm() {
        return "createUser";
    }

    @PostMapping("/edit_user")
    public String editUserForm(@RequestParam int id,Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "editUser" ;
    }


    @PostMapping("/save_user")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/list_user" ;
    }
    @PostMapping("/update_user")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/list_user" ;
    }

    @GetMapping("/list_user")
    public String getAllUser(Model model){
        model.addAttribute("users", userService.getAllUser());
    return "listUser";
    }

    @GetMapping("/delete_user")
    public String deleteUser(@RequestParam int id){
     return "redirect:/list_user";
    }
}
/*@GetMapping(value="/")
    public String index(Model model){
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setName("Sunny Chand");
        personalInfo.setAge(33);
        personalInfo.setAddress("MiddleTown,Newyork,USA");
        personalInfo.setEmail("sunnychand01111@gmail.com");
        personalInfo.setPhoneno("908-346-3022");
        personalInfo.setDescription("Working to make a bright future");
        //  personalInfo.setResume("");

        List<PortfolioService> services= apiService.getAllServices();

        *//*ArrayList<PortfolioService> services= new ArrayList<>();
        services.add(new PortfolioService("Spring Boot","create Web application using spring boot",""));
        services.add(new PortfolioService("Mobile app developer","create Mobile application using spring boot",""));
        services.add(new PortfolioService("Clerk App Developer","create account application using spring boot",""));*//*
        ArrayList<Education> educations= new ArrayList<>();
        educations.add(new Education("2006-2008","SLC","Little Angels School","iron gate"));
        educations.add(new Education("2009-2011","+2","Little Angels Collage","Higher Education"));
        educations.add(new Education("2012-2015","Aircraft Maintenance Engeenering","AAE","Bachalore"));
        educations.add(new Education("2015-2017","MBA","Kantipur Collage","Bussiness Studies"));
        Collections.sort(educations);

        ArrayList<Experience> experiences= new ArrayList<>();
        experiences.add(new Experience("2013-2018","Technician","Buddha air","maintained the Aircrafts"));
        experiences.add(new Experience("2018-2019","mechanic","Auto Repair","repaired cars"));
        experiences.add(new Experience("2019-2020","kitchen helper","Himalayan Aroma","dish washing, helping cook"));
        experiences.add(new Experience("2020-2021","Developer","MassMutual","Sailpoint"));
        Collections.sort(experiences);

        ArrayList<Skills> skills= new ArrayList<>();
        skills.add(new Skills("Web Design",69));
        skills.add(new Skills("HTML/CSS",70));
        skills.add(new Skills("JavaScript",75));
        skills.add(new Skills("React JS",80));
        skills.add(new Skills("Angular JS",74));
        skills.add(new Skills("Bootstrap",81));
        skills.add(new Skills("java ",90));



        model.addAttribute("personalInfo",personalInfo);
        model.addAttribute("services",services);
        model.addAttribute("educations",educations);
        model.addAttribute("experience",experiences);
        model.addAttribute("skills",skills);

        return "index";
    }

    @PostMapping(value="/contact")
    public String contact(@ModelAttribute Contact contact){

        contact.getName();
        System.out.println(contact);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name:");
        stringBuilder.append(contact.getName());
        stringBuilder.append("\n");
        stringBuilder.append("Email:");
        stringBuilder.append(contact.getEmail());
        stringBuilder.append("\n");
        stringBuilder.append("Message:");
        stringBuilder.append(contact.getMessage());
        stringBuilder.append("\n");

        MailHelper.sendEmail(stringBuilder.toString(),javaMailSender,"Email from your portfolio webpage","sunnychand01111@gmail.com");

        return"redirect:";*/

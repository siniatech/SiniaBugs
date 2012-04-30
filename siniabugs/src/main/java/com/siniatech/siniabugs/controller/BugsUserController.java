package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siniatech.siniabugs.dao.api.IBugsUserDao;

@Controller
public class BugsUserController {

    @Autowired
    private IBugsUserDao bugsUserDao;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser( @RequestParam(value = "id") String id, Model model ) {
        try {
            long longId = Long.parseLong( id );
            model.addAttribute( "user", bugsUserDao.getBugsUser( longId ) );
            return "user";
        } catch ( NumberFormatException e ) {
            return "user";
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers( Model model ) {
        model.addAttribute( "users", bugsUserDao.getBugsUsers() );
        return "users";
    }

}

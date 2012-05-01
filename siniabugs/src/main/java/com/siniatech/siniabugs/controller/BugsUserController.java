package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siniatech.siniabugs.dao.api.IBugsUserDao;
import com.siniatech.siniabugs.model.api.IBugsUser;

@Controller
public class BugsUserController {

    @Autowired
    private IBugsUserDao bugsUserDao;

    @RequestMapping(value = "/user/viewUser", method = RequestMethod.GET)
    public String getUser( @RequestParam(value = "id") String id, Model model ) {
        try {
            long longId = Long.parseLong( id );
            model.addAttribute( "user", bugsUserDao.getBugsUser( longId ) );
            return "user/viewUser";
        } catch ( NumberFormatException e ) {
            return "user/viewUser";
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers( Model model ) {
        model.addAttribute( "users", bugsUserDao.getBugsUsers() );
        return "users";
    }

    @RequestMapping(value = "/user/createUser", method = RequestMethod.GET)
    public String createBugsUser( Model model ) {
        model.addAttribute( "user", bugsUserDao.newInstance() );
        return "user/createUser";
    }

    @RequestMapping(value = "/user/createUser", method = RequestMethod.POST)
    public String saveAndViewBugsUser( @ModelAttribute IBugsUser bugsUser, Model model ) {
        bugsUserDao.save( bugsUser, bugsUserDao.getBugsUser( 1L ) );
        model.addAttribute( "user", bugsUser );
        return "user/viewUser";
    }

}

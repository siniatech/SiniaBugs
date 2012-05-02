package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siniatech.siniabugs.dao.api.IBugsUserDao;
import com.siniatech.siniabugs.model.current.BugsUser;

@Controller
public class BugsUserController {

    @Autowired
    private IBugsUserDao bugsUserDao;

    @RequestMapping(value = "/user/view", method = RequestMethod.GET)
    public String getUser( @RequestParam(value = "id") String id, Model model ) {
        try {
            long longId = Long.parseLong( id );
            model.addAttribute( "user", bugsUserDao.getBugsUser( longId ) );
            return "/user/viewUser";
        } catch ( NumberFormatException e ) {
            return "/user/viewUser";
        }
    }

    @RequestMapping(value = "/user/admin", method = RequestMethod.GET)
    public String getUsers( Model model ) {
        model.addAttribute( "users", bugsUserDao.getBugsUsers() );
        return "user/userAdmin";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String createBugsUser( Model model ) {
        model.addAttribute( "create", bugsUserDao.newInstance() );
        return "user/createUser";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String saveAndViewBugsUser( @ModelAttribute BugsUser bugsUser, Model model ) {
        bugsUserDao.save( bugsUser, bugsUserDao.getBugsUser( 1L ) );
        model.addAttribute( "user", bugsUser );
        return "user/viewUser";
    }

}

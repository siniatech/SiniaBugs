package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siniatech.siniabugs.dao.api.IBugsUserDao;
import com.siniatech.siniabugs.model.current.BugsUser;
import com.siniatech.siniautils.fn.IFunction1;

@Controller
public class BugsUserController {

    @Autowired
    private IBugsUserDao bugsUserDao;

    @PreAuthorize("hasRole('user')")
    @RequestMapping(value = "/user/View", method = RequestMethod.GET)
    public String getUser( @RequestParam(value = "id") String id, final Model model ) {
        return getIdAndApply( id, model, new IFunction1<Long, String>() {
            public String apply( Long longId ) {
                model.addAttribute( "user", bugsUserDao.readById( longId ) );
                return "/user/viewUser";
            }
        } );
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/user/Delete", method = RequestMethod.GET)
    public String deleteUser( @RequestParam(value = "id") String id, final Model model ) {
        return getIdAndApply( id, model, new IFunction1<Long, String>() {
            public String apply( Long longId ) {
                bugsUserDao.delete( bugsUserDao.readById( longId ), bugsUserDao.readById( 1L ) );
                model.addAttribute( "users", bugsUserDao.getBugsUsers() );
                return "user/userAdmin";
            }
        } );
    }

    private String getIdAndApply( String id, final Model model, IFunction1<Long, String> function ) {
        try {
            long longId = Long.parseLong( id );
            return function.apply( longId );
        } catch ( NumberFormatException e ) {
            model.addAttribute( "message", "Badly formatted URL" );
            return "/error";
        }
    }

    @PreAuthorize("hasRole('user')")
    @RequestMapping(value = "/user/Admin", method = RequestMethod.GET)
    public String getUsers( Model model ) {
        model.addAttribute( "users", bugsUserDao.getBugsUsers() );
        return "user/userAdmin";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/user/Edit", method = RequestMethod.GET)
    public String editBugsUser( @RequestParam(value = "id") String id, final Model model ) {
        return getIdAndApply( id, model, new IFunction1<Long, String>() {
            public String apply( Long longId ) {
                model.addAttribute( "user", bugsUserDao.readById( longId ) );
                model.addAttribute( "action", "Edit" );
                return "user/createUser";
            }
        } );
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/user/Edit", method = RequestMethod.POST)
    public String saveEditedBugsUser( @ModelAttribute BugsUser bugsUser, Model model ) {
        bugsUserDao.update( bugsUser, bugsUserDao.readById( 1L ) );
        model.addAttribute( "user", bugsUser );
        return "user/viewUser";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/user/Create", method = RequestMethod.GET)
    public String createBugsUser( Model model ) {
        model.addAttribute( "user", bugsUserDao.newInstance() );
        model.addAttribute( "action", "Create" );
        return "user/createUser";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/user/Create", method = RequestMethod.POST)
    public String saveNewBugsUser( @ModelAttribute BugsUser bugsUser, Model model ) {
        bugsUserDao.create( bugsUser, bugsUserDao.readById( 1L ) );
        model.addAttribute( "user", bugsUser );
        return "user/viewUser";
    }

}

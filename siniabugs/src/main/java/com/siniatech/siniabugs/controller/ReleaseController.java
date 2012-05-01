package com.siniatech.siniabugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siniatech.siniabugs.dao.api.IReleaseDao;

@Controller
public class ReleaseController {

    @Autowired
    private IReleaseDao releaseDao;

    @RequestMapping(value = "/release", method = RequestMethod.GET)
    public String getRelease( @RequestParam(value = "id") String id, Model model ) {
        try {
            long longId = Long.parseLong( id );
            model.addAttribute( "release", releaseDao.getRelease( longId ) );
            return "release";
        } catch ( NumberFormatException e ) {
            return "release";
        }
    }

    @RequestMapping(value = "/releases", method = RequestMethod.GET)
    public String getReleases( Model model ) {
        model.addAttribute( "releases", releaseDao.getReleases() );
        return "releases";
    }

}

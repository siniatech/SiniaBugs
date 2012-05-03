package com.siniatech.siniabugs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.siniatech.siniabugs.dao.api.IBugsUserDao;
import com.siniatech.siniabugs.model.api.IBugsUser;
import com.siniatech.siniabugs.model.current.BugsUser;
import com.siniatech.siniabugs.model.historical.BugsUserHistorical;
import com.siniatech.siniautils.collection.ListHelper;

public class BugsUserDao extends ModelObjectDao<IBugsUser> implements IBugsUserDao {

    public List<IBugsUser> getBugsUsers() {
        return hibernateTemplate.find( "from BugsUser" );
    }

    public IBugsUser readById( Long id ) {
        List<IBugsUser> users = hibernateTemplate.find( "from BugsUser where id = " + id );
        assert users.size() == 1;
        return ListHelper.head( users );
    }

    public List<IBugsUser> getHistoryForBugsUser( Long id ) {
        List<IBugsUser> users = new ArrayList<IBugsUser>();
        users.addAll( hibernateTemplate.find( "from BugsUser where id = " + id ) );
        users.addAll( hibernateTemplate.find( "from BugsUserHistory where id = " + id + " order by end desc" ) );
        return users;
    }

    public IBugsUser newInstance() {
        return new BugsUser();
    }

    public IBugsUser newInstanceHistorical() {
        return new BugsUserHistorical();
    }

    @Override
    protected void copyNonGenericFields( IBugsUser source, IBugsUser target ) {
        target.setFirstName( source.getFirstName() );
        target.setSurname( source.getSurname() );
    }

    public IBugsUser readByUid( Long uid ) {
        List<IBugsUser> users = hibernateTemplate.find( "from BugsUser where uid = " + uid );
        switch ( users.size() ) {
            case 0 : {
                users = hibernateTemplate.find( "from BugsUserHistorical where uid = " + uid );
                assert users.size() == 1;
                return ListHelper.head( users );
            }
            case 1 : {
                return ListHelper.head( users );
            }
        }
        assert false;
        return null;
    }

}

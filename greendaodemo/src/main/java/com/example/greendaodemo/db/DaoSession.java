package com.example.greendaodemo.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.greendaodemo.model.User;
import com.example.greendaodemo.model.MediaBean;
import com.example.greendaodemo.model.UserBean;

import com.example.greendaodemo.db.UserDao;
import com.example.greendaodemo.db.MediaBeanDao;
import com.example.greendaodemo.db.UserBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig mediaBeanDaoConfig;
    private final DaoConfig userBeanDaoConfig;

    private final UserDao userDao;
    private final MediaBeanDao mediaBeanDao;
    private final UserBeanDao userBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        mediaBeanDaoConfig = daoConfigMap.get(MediaBeanDao.class).clone();
        mediaBeanDaoConfig.initIdentityScope(type);

        userBeanDaoConfig = daoConfigMap.get(UserBeanDao.class).clone();
        userBeanDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        mediaBeanDao = new MediaBeanDao(mediaBeanDaoConfig, this);
        userBeanDao = new UserBeanDao(userBeanDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(MediaBean.class, mediaBeanDao);
        registerDao(UserBean.class, userBeanDao);
    }
    
    public void clear() {
        userDaoConfig.clearIdentityScope();
        mediaBeanDaoConfig.clearIdentityScope();
        userBeanDaoConfig.clearIdentityScope();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public MediaBeanDao getMediaBeanDao() {
        return mediaBeanDao;
    }

    public UserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

}
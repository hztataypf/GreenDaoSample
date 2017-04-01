package com.ypf.greendao.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.ypf.greendao.model.User;
import com.ypf.greendao.model.ExecPlan;

import com.ypf.greendao.db.dao.UserDao;
import com.ypf.greendao.db.dao.ExecPlanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig execPlanDaoConfig;

    private final UserDao userDao;
    private final ExecPlanDao execPlanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        execPlanDaoConfig = daoConfigMap.get(ExecPlanDao.class).clone();
        execPlanDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        execPlanDao = new ExecPlanDao(execPlanDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(ExecPlan.class, execPlanDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        execPlanDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public ExecPlanDao getExecPlanDao() {
        return execPlanDao;
    }

}
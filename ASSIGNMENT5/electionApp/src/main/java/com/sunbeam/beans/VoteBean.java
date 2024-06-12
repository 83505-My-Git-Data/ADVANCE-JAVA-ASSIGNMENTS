package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean {
    int id;
    int cnt = 0;
    int userStatus;
    int userId;

    public VoteBean() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public boolean checkUserStatus() {
        try (UserDao userDao = new UserDaoImpl()) {
            User user = userDao.findById(userId);
            return user.getStatus() == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void vote() {
        try (UserDao userDao = new UserDaoImpl(); CandidateDao cd = new CandidateDaoImpl()) {
            if (checkUserStatus()) {
                this.cnt = cd.incrementVote(id);
                userDao.updateStatus(userId, true);
            } else {
                this.cnt = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

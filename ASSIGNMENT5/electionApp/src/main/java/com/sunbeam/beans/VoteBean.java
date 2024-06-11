package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean 
{
	int id;
	int cnt=0;
	int voteStatus;
	int userStatus;
	int userId;
	
	public VoteBean(int id, int cnt, int voteStatus, int userStatus, int userId) {
		super();
		this.id = id;
		this.cnt = cnt;
		this.voteStatus = voteStatus;
		this.userStatus = userStatus;
		this.userId = userId;
	}
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
	public int getVoteStatus() {
		return voteStatus;
	}
	public void setVoteStatus(int voteStatus) {
		this.voteStatus = voteStatus;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public VoteBean(int id, int cnt, int voteStatus, int userStatus) {
		super();
		this.id = id;
		this.cnt = cnt;
		this.voteStatus = voteStatus;
		this.userStatus = userStatus;
	}
	public VoteBean() {
		super();
	}
	
	public void vote()
	{//cnt  id
		
		
		
		
		try {
			CandidateDao cd=new CandidateDaoImpl();
			this.cnt=cd.incrementVote(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getStatusOfVoting()
	{
		try 
		{
			UserDao userDao=new UserDaoImpl();
		    User user=userDao.findById(userId);	
		    if(user.getStatus()==0)
		    {
		      this.voteStatus=1;	
		    }
		    else
		    {
		    	this.voteStatus=0;
		    }
		    
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	public void setStatusUser()
	{
		try 
		{
			UserDao userDao=new UserDaoImpl();
		    userDao.updateStatus(userId, true);	
		    
		    
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
	}

}

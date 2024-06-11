package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
	private List list;
	
	public CandidateListBean() {
		
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	public List getCandidateList()
	{
		List<Candidate> li =  new ArrayList<>();
		try(CandidateDao candDao = new CandidateDaoImpl())
		{
			this.list =candDao.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return this.list;
		
	}
	
	
}

package com.qianhe.service;

import java.util.List;

import com.qianhe.model.Page;
import com.qianhe.model.Team;

public interface TeamServcie {
	
	public List<Team> findAllTeam(Page page);
	public Integer findAllTeamCounts();
	public void saveTeam(Team team);
	public Team findTeamById(Integer id);
	public void updateTeam(Team team);
	public void delTeam(Integer id);

}

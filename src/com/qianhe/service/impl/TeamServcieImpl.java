package com.qianhe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qianhe.mapper.TeamMapper;
import com.qianhe.model.Page;
import com.qianhe.model.Team;
import com.qianhe.service.TeamServcie;

@Transactional
@Service
public class TeamServcieImpl implements TeamServcie {
	
	@Autowired
	private TeamMapper teamMapper;

	@Override
	public List<Team> findAllTeam(Page page) {
		return teamMapper.findAllTeam(page);
	}

	@Override
	public Integer findAllTeamCounts() {
		return teamMapper.findAllTeamCounts();
	}

	@Override
	public void saveTeam(Team team) {
		teamMapper.saveTeam(team);
		
	}

	@Override
	public Team findTeamById(Integer id) {
		return teamMapper.findTeamById(id);
	}

	@Override
	public void updateTeam(Team team) {
		teamMapper.updateTeam(team);		
	}

	@Override
	public void delTeam(Integer id) {
		teamMapper.delTeam(id);
		
	}

}

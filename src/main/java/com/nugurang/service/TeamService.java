package com.nugurang.service;

import com.nugurang.constant.RoleName;
import com.nugurang.dao.RoleDao;
import com.nugurang.dao.TeamDao;
import com.nugurang.dao.XrefUserTeamDao;
import com.nugurang.dto.TeamInputDto;
import com.nugurang.entity.TeamEntity;
import com.nugurang.entity.XrefUserTeamEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService {
    private final UserService userService;
    private final RoleDao roleDao;
    private final TeamDao teamDao;
    private final XrefUserTeamDao xrefUserTeamDao;

    @Transactional
    public TeamEntity createTeam(TeamInputDto teamInputDto) {
        TeamEntity teamEntity = teamDao.save(TeamEntity.builder().name(teamInputDto.getName()).build());
        xrefUserTeamDao.save(XrefUserTeamEntity.builder().user(userService.getCurrentUser().get()).team(teamEntity).role(roleDao.findByName(RoleName.OWNER.name())).build());
        return teamEntity;
    }

    public Optional<TeamEntity> getTeam(Long teamId) {
        return teamDao.findById(teamId);
    }

    public Optional<TeamEntity> getTeam(String teamName) {
        return Optional.ofNullable(teamDao.findByName(teamName));
    }

    public List<TeamEntity> getTeams(String teamName, Pageable pageable) {
        return teamDao.findAllByNameContainingIgnoreCase(teamName, pageable).getContent();
    }

    public TeamEntity updateTeam(TeamInputDto teamInputDto, Long id) {
        TeamEntity teamEntity = teamDao.findById(id).get();
        teamEntity.setName(teamInputDto.getName());
        return teamDao.save(teamEntity);
    }

    public void deleteTeam(Long teamId) {
        teamDao.deleteById(teamId);
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public TeamService(final UserService userService, final RoleDao roleDao, final TeamDao teamDao, final XrefUserTeamDao xrefUserTeamDao) {
        this.userService = userService;
        this.roleDao = roleDao;
        this.teamDao = teamDao;
        this.xrefUserTeamDao = xrefUserTeamDao;
    }
    //</editor-fold>
}

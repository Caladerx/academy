package com.ctw.workstation.team.control;

import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TeamRepository implements PanacheRepositoryBase<Team, Long > {
}

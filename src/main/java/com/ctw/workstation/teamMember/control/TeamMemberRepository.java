package com.ctw.workstation.teamMember.control;

import com.ctw.workstation.teamMember.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.UUID;

public class TeamMemberRepository implements PanacheRepository<TeamMember> {
    public TeamMember findById(long id) {
        return findById(id);
    }
}

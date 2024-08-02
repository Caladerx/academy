package com.ctw.workstation.rack.entity;

import com.ctw.workstation.team.entity.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_RACK")
public class Rack {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackIdGenerator")
    @SequenceGenerator(name = "rackIdGenerator", sequenceName = "SEQ_RACK_ID")
    @JsonIgnore
    private long id;
    @Column(name = "SERIAL_NUMBER", length = 20, nullable = false)
    private String serialNumber;
    @Column(name = "TEAM_ID")
    private long teamId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", updatable = false, insertable = false, nullable = false)
    @JsonIgnore
    private Team team;
    @Column(name = "DEFAULT_LOCATION", length = 10, nullable = false)
    private String defaultLocation;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT")
    @JsonIgnore
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.control.RackRepository;
import com.ctw.workstation.rack.entity.Status;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class RackService {

    @Inject
    RackRepository rackRepository;

    @Transactional
    public void addRack(Rack rack) {
        rack.setCreatedAt(LocalDateTime.now());
        rackRepository.persist(rack);
    }

    public List<Rack> getRacks() {
        return rackRepository.listAll();
    }

    public Rack getRackById(Long id) {
        return rackRepository.findById(id);
    }

    @Transactional
    //Falta verificações de serialNumber duplicado e afins
    public void updateRackById(Rack rack) {
        Rack rackInDB = rackRepository.getEntityManager().find(Rack.class,rack.getId());
        if (rackInDB == null) throw new NotFoundException("Rack not found");
        rackInDB.setTeam(rack.getTeam());
        rackInDB.setStatus(rack.getStatus());
        rackInDB.setDefaultLocation(rack.getDefaultLocation());
        rackInDB.setTeamId(rack.getTeamId());
        rackInDB.setSerialNumber((rack.getSerialNumber()));
    }

    @Transactional
    public void deleteRackById(Long id) {
        Rack rackToDelete = rackRepository.findById(id);
        rackRepository.delete(rackToDelete);
    }

    public List<Rack> getAllRacksWithSpecificStatus(Status status) {
        List<Rack> racks = rackRepository.listAll();
        racks.stream()
                .filter(rack -> status.equals(rack.getStatus()))
                .collect(Collectors.toList());

        return racks;
    }
}

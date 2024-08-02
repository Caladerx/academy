package com.ctw.workstation.rack.control;

import com.ctw.workstation.rack.entity.Rack;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RackRepository implements PanacheRepositoryBase<Rack, Long> {
}

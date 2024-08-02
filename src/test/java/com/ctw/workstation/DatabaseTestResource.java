package com.ctw.workstation;

import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Map;

public class DatabaseTestResource implements QuarkusTestResourceLifecycleManager {
    PostgreSQLContainer postgres = new PostgreSQLContainer<>("postgres");

    @Override
    public Map<String, String> start() {
        Log.infov("About to start", "D");
        postgres.start();

        return Map.of(
                "quarkus.datasource.db-kind", "postgresql",
                "quarkus.log.console.json", "false",
                "quarkus.datasource.username", "postgres",
                "quarkus.datasource.password", "postgres",
                "quarkus.datasource.jdbc.url", "jdbc:postgresql://localhost:5432/fs_academy_new");
    }

    @Override
    public void stop() {
        Log.infov("Stop");
        postgres.stop();
    }
}

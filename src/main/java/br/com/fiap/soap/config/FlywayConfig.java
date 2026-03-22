package br.com.fiap.soap.config;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:postgresql://localhost:5432/convocation",
                        "postgres",
                        "postgres"
                )
                .load();

        flyway.migrate();
    }
}

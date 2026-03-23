package br.com.fiap.soap.config;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:postgresql://localhost:5432/cd",
                        "postgres",
                        "db-convocation"
                )
                .locations("classpath:db.migration")
                .load();

        flyway.migrate();
    }
}

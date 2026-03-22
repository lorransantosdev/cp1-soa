package br.com.fiap.soap.model;

import java.util.UUID;

public class Convocation {
    private UUID playerId;
    private String status;

    public Convocation() { }

    public Convocation(UUID playerId, String status) {
        this.playerId = playerId;
        this.status = status;
    }

    public UUID getPlayerId() { return playerId; }
    public void setPlayerId(UUID playerId) { this.playerId = playerId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

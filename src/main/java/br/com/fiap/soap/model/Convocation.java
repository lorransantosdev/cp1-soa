package br.com.fiap.soap.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Convocation {
    private Long id;
    private Long playerId;
    private String requestedBy;
    private String status;

    public Convocation() {}

    public Convocation(Long id, Long playerId, String requestedBy, String status) {
        this.id = id;
        this.playerId = playerId;
        this.requestedBy = requestedBy;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

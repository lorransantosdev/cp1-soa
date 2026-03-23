package br.com.fiap.soap.service;

import br.com.fiap.soap.model.Convocation;
import br.com.fiap.soap.model.Player;
import br.com.fiap.soap.repository.ConvocationRepository;
import br.com.fiap.soap.repository.PlayerRepository;
import org.flywaydb.core.internal.util.CollectionsUtils;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collections;
import java.util.List;

@WebService
public class ConvocationService {
    private final PlayerRepository playerRepository;
    private final ConvocationRepository convocationRepository;

    public ConvocationService(PlayerRepository playerRepository, ConvocationRepository convocationRepository) {
        this.playerRepository = playerRepository;
        this.convocationRepository = convocationRepository;
    }

    @WebMethod
    public List<Player> listPlayers() {
        return playerRepository.findAll();
    }

    @WebMethod
    public String callPlayer(
            @WebParam(name = "playerId") String playerId,
            @WebParam(name = "requestedBy")String requestedBy) {

        if (playerId == null) {
            return "Player ID cannot be null";
        }
        Long playerIdLong = Long.parseLong(playerId);

        Player player = playerRepository.findById(playerIdLong);

        if (player == null) {
            return "Player with ID " + playerIdLong + " not found";
        }

        Convocation c = new Convocation(
                null,
                playerIdLong,
                requestedBy,
                "CALLED"
        );

        convocationRepository.save(c);

        return "Player " + player.getName() + " called by " + requestedBy;
    }

    @WebMethod
    public List<Convocation> listConvocations() {
        return convocationRepository.findAll();
    }

    @WebMethod
    public String createPlayer(
            @WebParam(name = "name") String name,
            @WebParam(name = "position") String position) {

        if (name == null || position == null ) {
            return "Player ID cannot be null";
        }

        Player player = new Player(null, name, position);

        playerRepository.save(player);

        return "Player created successfully!";
    }
}

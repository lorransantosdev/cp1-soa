package br.com.fiap.soap.service;

import br.com.fiap.soap.model.Convocation;
import br.com.fiap.soap.model.Player;
import br.com.fiap.soap.repository.ConvocationRepository;
import br.com.fiap.soap.repository.PlayerRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
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
    public String callPlayer(Long playerId, String requestedBy) {

        Player player = playerRepository.findById(playerId);

        if (player == null) {
            return "Player not found";
        }

        Convocation c = new Convocation(
                null,
                playerId,
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
    public String createPlayer(String name, String position) {

        Player player = new Player(null, name, position);

        playerRepository.save(player);

        return "Player created successfully!";
    }
}

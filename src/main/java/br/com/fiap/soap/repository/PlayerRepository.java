package br.com.fiap.soap.repository;

import br.com.fiap.soap.config.ConnectionFactoryConfig;
import br.com.fiap.soap.model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    public List<Player> findAll() {
        List<Player> players = new ArrayList<>();

        String sql = "SELECT * FROM players";

        try (Connection conn = ConnectionFactoryConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                players.add(new Player(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("position")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return players;
    }

    public Player findById(Long id) {
        String sql = "SELECT * FROM players WHERE id = ?";

        try (Connection conn = ConnectionFactoryConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Player(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("position")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}

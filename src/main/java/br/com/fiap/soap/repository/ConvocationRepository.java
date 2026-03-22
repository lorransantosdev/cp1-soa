package br.com.fiap.soap.repository;

import br.com.fiap.soap.config.ConnectionFactoryConfig;
import br.com.fiap.soap.model.Convocation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConvocationRepository {
    public void save(Convocation c) {
        String sql = "INSERT INTO convocations (player_id, requested_by, status) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactoryConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, c.getPlayerId());
            ps.setString(2, c.getRequestedBy());
            ps.setString(3, c.getStatus());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Convocation> findAll() {
        List<Convocation> list = new ArrayList<>();

        String sql = "SELECT * FROM convocations order by 1 desc";

        try (Connection conn = ConnectionFactoryConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Convocation(
                        rs.getLong("id"),
                        rs.getLong("player_id"),
                        rs.getString("requested_by"),
                        rs.getString("status")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}

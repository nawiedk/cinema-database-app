package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public class VorstellungDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<VorstellungDTO> getAllVorstellungen() {
        String sql = "SELECT * FROM vorstellung";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new VorstellungDTO(
                        rs.getInt("vid"),
                        rs.getDate("datum"),
                        rs.getTime("uhrzeit"),
                        rs.getString("saalname"),
                        rs.getInt("filmid")
                )
        );
    }

    
    public List<VorstellungDTO> getVorstellungenByDatum(Date datum) {
        String sql = "SELECT * FROM vorstellung WHERE datum = ?";

        return jdbcTemplate.query(
                sql,
                new Object[]{datum},
                (rs, rowNum) -> new VorstellungDTO(
                        rs.getInt("vid"),
                        rs.getDate("datum"),
                        rs.getTime("uhrzeit"),
                        rs.getString("saalname"),
                        rs.getInt("filmid")
                )
        );
    }

     
    public List<VorstellungDTO> getVorstellungenByUhrzeit(Time uhrzeit) {
        String sql = "SELECT * FROM vorstellung WHERE uhrzeit = ?";

        return jdbcTemplate.query(
                sql,
                new Object[]{uhrzeit},
                (rs, rowNum) -> new VorstellungDTO(
                        rs.getInt("vid"),
                        rs.getDate("datum"),
                        rs.getTime("uhrzeit"),
                        rs.getString("saalname"),
                        rs.getInt("filmid")
                )
        );
    }
    
    public List<VorstellungDTO> getVorstellungenByDatumAndUhrzeit(Date datum, Time uhrzeit) {
        String sql = "SELECT * FROM vorstellung WHERE datum = ? AND uhrzeit = ?";

        return jdbcTemplate.query(
                sql,
                new Object[]{datum, uhrzeit},
                (rs, rowNum) -> new VorstellungDTO(
                        rs.getInt("vid"),
                        rs.getDate("datum"),
                        rs.getTime("uhrzeit"),
                        rs.getString("saalname"),
                        rs.getInt("filmid")
                )
        );
    }
    
    public void saveVorstellung(VorstellungDTO vorstellung) {
        String sql = "INSERT INTO vorstellung (vid, datum, uhrzeit, saalname, filmid) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, vorstellung.vId(), vorstellung.datum(), vorstellung.uhrzeit(), vorstellung.saalname(), vorstellung.filmId());
    }

}


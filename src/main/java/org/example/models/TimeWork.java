package org.example.models;

import com.mysql.cj.jdbc.DatabaseMetaData;

import javax.sql.DataSource;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeWork {
    private int id;
    private int employeeId;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    private int projectId;
    private LocalTime workingTime;

    public TimeWork() {
    }

    public TimeWork(int id, int employeeId, LocalDateTime loginTime, LocalDateTime logoutTime, int projectId, LocalTime workingTime) {
        this.id = id;
        this.employeeId = employeeId;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.projectId = projectId;
        this.workingTime = workingTime;
    }

    public void CreateTimeWork(Connection con, int employeeId, LocalDateTime loginTime, LocalDateTime logoutTime, int projectId) {
        try {
            String sql = "INSERT INTO time_work (id_pracownika, data_zalogowania, data_wylogowania, id_projektu) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ps.setTimestamp(2, Timestamp.valueOf(loginTime));
            ps.setTimestamp(3, Timestamp.valueOf(logoutTime));
            ps.setInt(4, projectId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public TimeWork getTimeWork(Connection con, int id) {
        TimeWork timeWork = null;
        try {
            String sql = "SELECT * FROM czas_pracy WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int employeeId = rs.getInt("id_pracownika");
                LocalDateTime loginTime = rs.getTimestamp("data_zalogowania").toLocalDateTime();
                LocalDateTime logoutTime = rs.getTimestamp("data_wylogowania").toLocalDateTime();
                int projectId = rs.getInt("id_projektu");

                Duration durationBetweenLoginLogout = Duration.between(loginTime, logoutTime);
                long seconds = durationBetweenLoginLogout.getSeconds();
                LocalTime workingTime = LocalTime.ofSecondOfDay(seconds);
                timeWork = new TimeWork(id, employeeId, loginTime, logoutTime, projectId, workingTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeWork;
    }
    public void insertTimeWork(int employeeId, LocalDateTime loginTime, LocalDateTime logoutTime, int projectId) {


        String sql = "INSERT INTO czas_pracy (id_pracownika, data_zalogowania, data_wylogowania, id_projektu, czas) VALUES (?,?,?,?,?)";
        DataSource dataSource=null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            Duration durationBetweenLoginLogout = Duration.between(loginTime, logoutTime);
            long minutes = durationBetweenLoginLogout.toMinutes();
            statement.setInt(1, employeeId);
            statement.setObject(2, loginTime);
            statement.setObject(3, logoutTime);
            statement.setInt(4, projectId);
            statement.setLong(5, minutes);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    }





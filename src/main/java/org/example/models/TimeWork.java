package org.example.models;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

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


        public void insertTimeWork(Connection con, int employeeId, LocalDate date, LocalTime loginTime, LocalTime logoutTime, int projectId) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO czas_pracy (id_pracownika, data_zalogowania, data_wylogowania, id_projektu, czas) VALUES (?,?,?,?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1, employeeId);
                ps.setDate(2, Date.valueOf(date));
                ps.setTime(3, Time.valueOf(loginTime));
                ps.setTime(4, Time.valueOf(logoutTime));
                ps.setInt(5, projectId);

                // obliczanie czasu pracy dla danego dnia
                long workTime = Duration.between(loginTime, logoutTime).toMinutes();
                ps.setLong(6, workTime);

                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public void insertMonthlyTimeWork(Connection con, int employeeId, LocalDate date, int projectId) {
            PreparedStatement ps = null;
            try {
                String query = "SELECT SUM(czas) FROM czas_pracy WHERE id_pracownika = ? AND MONTH(data_zalogowania) = MONTH(?) AND id_projektu = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, employeeId);
                ps.setDate(2, Date.valueOf(date));
                ps.setInt(3, projectId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int monthlyTime = rs.getInt(1);
                    // wstawienie sumy czasu pracy dla danego miesiąca do tabeli
                    // ...
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    public void insertTotalTimeWork(Connection con, int employeeId, int projectId) {
        PreparedStatement ps = null;
        try {
            String query = "SELECT SUM(czas) FROM czas_pracy WHERE id_pracownika = ? AND id_projektu = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, employeeId);
            ps.setInt(2, projectId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int totalTime = rs.getInt(1);
                System.out.println("Łączny czas pracy pracownika o ID " + employeeId + " dla projektu o ID " + projectId + " wynosi " + totalTime + " godzin.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    }











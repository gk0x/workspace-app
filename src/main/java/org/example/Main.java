package org.example;

import com.mysql.cj.jdbc.DatabaseMetaData;
import org.example.models.DBConnection;
import org.example.models.Employee;
import org.example.models.Project;
import org.example.models.Role;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //dodawanie uzytkownika
        /*
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("Połączenie z bazą danych udane.");
            // Tutaj można wykonywać operacje na bazie danych, np. wykonywać zapytania SQL
            Employee employee = new Employee("John", "Michalski", 2);
            employee.addEmployee(con);
            con.close();
            System.out.println("Połączenie z bazą danych zamknięte.");
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas połączenia z bazą danych: " + e.getMessage());
        }*/
        //pobieranie uzytkownika po id
        /*
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("polaczenie udane");
            Employee employee1 = new Employee();
            employee1 = employee1.getEmployee(con,8);
            System.out.println(employee1);
            con.close();
            System.out.println("polaczenie zamkniete");
        }catch (SQLException e){
            System.out.println("blad podczas polaczenia");
        }
*/
        //aktualizowanie pracownika
        /*
       try {
           Connection con = DBConnection.getConnection();
           System.out.println("polaczenie udane");
           Employee employee2 = new Employee("Czesław" , "Marecki", 4);
           employee2.updateEmployee(con,10);
           con.close();
           System.out.println("polaczenie zamkniete");
       }catch (SQLException e){
           System.out.println("błąd podczas polaczenia");
       }
*/
/*
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("polaczenie udane");
            Employee employee3 = new Employee();
            employee3.deleteEmployee(con,19);
            con.close();
            System.out.println("polaczenie zamkniete");
        }catch (SQLException e){
            System.out.println("Blad podczas polaczenia ");
        }
        */
/*
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("polaczenie udane");
            Project project = new Project("sklep Aygo",
                    "sklep internetowy dla firmy Aygo ",
                    new Date(122, 01, 01),
                    new Date(122, 07, 01),
                    4,
                    "w trakcie");
            project.addProject(con);
            con.close();
            System.out.println("polaczenie zamkniete");
        } catch (SQLException e) {
            System.out.println("Blad polaczenia");
        }

*/
/*
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("polaczenie udane");
            Project project = new Project();
            project = project.getProject(con,2);
            System.out.println(project);
            con.close();
            System.out.println("polaaczenie zamkniete");

        }catch (SQLException e ){
            System.out.println("Blad polaczenia");
        }
 */
        /*
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("polaczenie udane");
            Project project = new Project();
            project.updateProject
                    (con,2,"Aygo sklep", "sklep internetowy",new Date(122,02,02),new Date(122,07,07),5,"zakonczony");
            con.close();
            System.out.println("polaczenie zakonczone");
        }catch (SQLException e){
            System.out.println("Blad polaczenia");
        }

         */
        /*
        try {
            Connection con = DBConnection.getConnection();
            Project project = new Project();
            project.deleteProject(con,3);
            con.close();
            System.out.println("polaczenie zakonczone");
        }catch (SQLException e){
            System.out.println("blad polaczenia");
        }

         */
        /*
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("polaczenie udane");
            Role role = new Role();
            role.setName("starszy programista");
            role.addRole(con);
            con.close();
            System.out.println("polaczenie zakonczone");
        }catch (SQLException e){
            System.out.println("blad polaczenia");
        }

         */
        /*
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("polaczenieudane");
            Role role = new Role();
            role = role.getRole(con,4);
            System.out.println(role);
            con.close();
            System.out.println("polaczeniezakonczone");
        }catch (SQLException e){
            System.out.println("blad polaczenia");
        }

         */
        /*
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("polaczenieudane");
            Role role= new Role();
            role.updateRole(con,4,"tłumacz jezyk hiszpanski");
            con.close();
            System.out.println("polaczneie zakonczone");
        }catch (SQLException e){
            System.out.println("blad polaczenie");
        }

         */
        /*
        try {
            Connection con = DBConnection.getConnection();
            Role role = new Role();
            role.deleteRole(con,4);
            con.close();
            System.out.println("polacznie zakonczone");
        }catch (SQLException e ){
            System.out.println("blad polaczenia");
        }

         */
    }
}


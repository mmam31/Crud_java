package src.modris;

import java.sql.*;
import java.util.Scanner;


public class CrudLogic {

    String dbURL = "jdbc:mysql://localhost:3306/CRUD-java";
    String username = "root";
    String password = "Karameles1!";

    Scanner scanner = new Scanner(System.in);


    //ievietot
    public void insert() {
        try (
                Connection connection = DriverManager.getConnection(dbURL, username, password);

        ) {
            System.out.println("Ievadiet username");
            String user = scanner.nextLine();

            System.out.println("Ievadiet password");
            String pass = scanner.nextLine();

            System.out.println("Ievadiet name");
            String name = scanner.nextLine();

            System.out.println("Ievadiet email");
            String email = scanner.nextLine();

            //izpildīt ievietošanu
            PreparedStatement statement = connection.prepareStatement("INSERT INTO userdata (username, password, name, email) VALUES ('"+user+"', '"+pass+"', '"+name+"', '"+email+"')");



//            statement.setString(1, "banans");
//            statement.setString(2, "dzeltenais31");
//            statement.setString(3, "Dzeltens Banāns");
//            statement.setString(4, "dzeltans.banans@gmail.com");

            int i = statement.executeUpdate();
            System.out.println(i + " Pievienots jauns lietotājs!");




        } catch (Exception e) {
            System.out.println(e);

        }
    }

    //izvēlēties
    public void select() {
        try (
                Connection connection = DriverManager.getConnection(dbURL, username, password);
        ) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM userdata");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println("id " + resultSet.getInt("id"));
                System.out.println("username " + resultSet.getString("username"));
                System.out.println("password " + resultSet.getString("password"));
                System.out.println(" ");
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    //izdzēst
    public void delete() {
        try (
                Connection connection = DriverManager.getConnection(dbURL, username, password);
        ) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM userdata WHERE username=?");


            statement.setString(1, "banans");


            int i = statement.executeUpdate();
            System.out.println(i + " Lietotājs dzēsts!");




        } catch (Exception e) {
            System.out.println(e);

        }
    }
    public void update() {
        try (
                Connection connection = DriverManager.getConnection(dbURL, username, password);
        ) {
            PreparedStatement statement = connection.prepareStatement("UPDATE userdata SET password=?, name=?, email=? WHERE username=?");


            statement.setString(1, "sarezgitaParole");
            statement.setString(2, "Liels Ābols");
            statement.setString(3, "liels.sarkans.abols@gmail.com");
            statement.setString(4, "abols");

            int i = statement.executeUpdate();
            System.out.println(i + " Lietotājs atjaunināts!");




        } catch (Exception e) {
            System.out.println(e);

        }
    }
}

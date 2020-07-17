package com.Database;

import java.net.ConnectException;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String url = "jdbc:sqlite:/Users/peetermaeots/Documents/JAVA/Database/";
        String database = "items.db";

        try {

            Connection conn = DriverManager.getConnection(url+database);
            System.out.println("Ühendatud.");

            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE items");
            statement.execute("DROP TABLE players");
            statement.execute("DROP TABLE player_items");

            statement.execute("CREATE TABLE IF NOT EXISTS items (" +
                    "name TEXT NOT NULL PRIMARY KEY, strength DOUBLE, endurance INTEGER, level TEXT" +
                    ")");
            statement.execute("CREATE TABLE IF NOT EXISTS players (" +
                    "name TEXT NOT NULL PRIMARY KEY, type TEXT, level TEXT" +
                    ")");
            statement.execute("CREATE TABLE IF NOT EXISTS player_items (" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, item TEXT, player TEXT, " +
                    "FOREIGN KEY(item) REFERENCES items(name)" +
                    "FOREIGN KEY(player) REFERENCES players(name)" +
                    ")");

            statement.execute("INSERT OR IGNORE INTO items (name, strength, endurance, level)" +
                    "VALUES('Mõõk', 10.00, 1, 'STANDARD')");

            statement.execute("INSERT OR IGNORE INTO items (name, strength, endurance, level) " +
                    "VALUES('Haamer', 5.00, 1, 'STANDARD') ");

            statement.execute("INSERT OR IGNORE INTO items (name, strength, endurance, level) " +
                    "VALUES('Saabas', 1.00, 1, 'STANDARD') ");

            statement.execute("UPDATE items SET endurance=3 WHERE name='Mõõk'");

            statement.execute("INSERT OR IGNORE INTO players (name, type, level)" +
                    "VALUES('Pets', 'Warrior', 'STANDARD')");
            statement.execute("INSERT OR IGNORE INTO player_items (player, item) " +
                    "VALUES ('Pets', 'Mõõk')");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM items");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name")  +
                        " " + resultSet.getDouble("strength") +
                        " " + resultSet.getInt("endurance"));
            };

            resultSet = statement.executeQuery("SELECT * FROM player_items");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("player")  +
                        " " + resultSet.getString("item"));
            };
            statement.close();

            conn.close();
            System.out.println("Ühendus suletud.");

        } catch (SQLException e) {
            System.out.println("Viskas errori: " + e.getMessage());
        } finally {
            System.out.println("Finally plokk");
        }
    }
}

package database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbConnect {

    private static Properties prop = getProperties();

    public static void main(String[] args) {
//        prop.forEach((k,v)-> System.out.println(v.toString()));


        String query = "SELECT * FROM Categories WHERE CategoryID = 1";
        execStatement(query);

//        String query2 = "SELECT * FROM Categories WHERE CategoryID = ?";
//        execPreparedStatement(query2, 2);

//        loadCategories();
    }


    //Считываем параметры из проперти файла
    private static Properties getProperties() {

        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("src/test/resources/database/db.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    //    Считываем параметры в бд конект
    private static MysqlDataSource getDataSource() {

        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setServerName(prop.getProperty("HOST"));
        dataSource.setPort(Integer.parseInt(prop.getProperty("PORT")));
        dataSource.setUser(prop.getProperty("USER"));
        dataSource.setPassword(prop.getProperty("PWD"));
        dataSource.setDatabaseName(prop.getProperty("DBNAME"));

        return dataSource;
    }

    //    Создаем коннект к бд и запросы
    private static void execStatement(String query) {
        try (Connection connection = getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {


            while (rs.next()) {
                System.out.println(rs.getMetaData().getColumnLabel(2));
                System.out.println(rs.getString(3));
//                rs.getMetaData().getColumnCount();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    //    Создаем коннект к бд и запросы c парамметром
    private static void execPreparedStatement(String query, int id) {

        try (Connection connection = getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getString(2));
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //Загрузим категории из БД
    private static void loadCategories() {
        String query = "SELECT * FROM Categories";
        List<Category> categories = new ArrayList<Category>();

        try (Connection connection = getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                categories.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        categories.forEach((category -> System.out.println(category.toString())));
    }

}
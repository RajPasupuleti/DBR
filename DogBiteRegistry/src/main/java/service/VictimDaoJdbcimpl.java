package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.VictimPojo;

public class VictimDaoJdbcimpl implements VictimDao {

    private static final String VICTIM_TABLE = "victim_details";

    @Override
    public List<VictimPojo> fetchAllDetails() {
        List<VictimPojo> victims = new ArrayList<>();
        try (Connection connection = DBUtil.makeConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(DBNativeSqlQueries.VICTIM_FETCH_ALL)) {

            while (resultSet.next()) {
                VictimPojo victim = extractVictimFromResultSet(resultSet);
                victims.add(victim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return victims;
    }

    @Override
    public Optional<VictimPojo> fetchAaddress(int age) {
        try (Connection connection = DBUtil.makeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.VICTIM_FETCH_BY_AGE)) {

            preparedStatement.setInt(1, age);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(extractVictimFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<VictimPojo> fetchByBreed(String dogBreed) {
        List<VictimPojo> victims = new ArrayList<>();
        try (Connection connection = DBUtil.makeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.VICTIM_FETCH_BY_BREED)) {

            preparedStatement.setString(1, dogBreed);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    VictimPojo victim = extractVictimFromResultSet(resultSet);
                    victims.add(victim);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return victims;
    }

    @Override
    public void removeAddress(int age) {
        try (Connection connection = DBUtil.makeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.VICTIM_DELETE)) {

            preparedStatement.setInt(1, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public VictimPojo addAddress(VictimPojo newAddress) {
        try (Connection connection = DBUtil.makeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.VICTIM_ADD, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, newAddress.getName());
            preparedStatement.setInt(2, newAddress.getAge());
            preparedStatement.setString(3, newAddress.getDogBreed());
            preparedStatement.setBoolean(4, newAddress.isDogVaccinatedStatus());
            preparedStatement.setString(5, newAddress.getAddress());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating victim failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    newAddress.setAge(id);
                } else {
                    throw new SQLException("Creating victim failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newAddress;
    }

    @Override
    public VictimPojo updateAddress(VictimPojo updateAddress) {
        try (Connection connection = DBUtil.makeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.VICTIM_UPDATE)) {

            preparedStatement.setString(1, updateAddress.getAddress());
            preparedStatement.setInt(2, updateAddress.getAge());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateAddress;
    }

    private VictimPojo extractVictimFromResultSet(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("VictimName");
        int age = resultSet.getInt("VictimAge");
        String dogBreed = resultSet.getString("DogBreed");
        boolean vaccinatedStatus = resultSet.getBoolean("VaccinatedStatus");
        String address = resultSet.getString("VictimAddress");

        return new VictimPojo(name, age, dogBreed, vaccinatedStatus, address);
    }
}

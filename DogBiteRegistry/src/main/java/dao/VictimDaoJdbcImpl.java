// dao/VictimDaoJdbcImpl.java
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.VictimPojo;

public class VictimDaoJdbcImpl implements VictimDao {

    private Connection connection;

    public VictimDaoJdbcImpl() {
        this.connection = DBUtil.makeConnection();
    }

    @Override
    public List<VictimPojo> fetchAllVictims() {
        List<VictimPojo> victims = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.ADDRESS_FETCH_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
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
    public Optional<VictimPojo> fetchAVictim(int victimAge) {
        Optional<VictimPojo> optionalVictim = Optional.empty();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.ADDRESS_FETCH_BY_AGE)) {
            preparedStatement.setInt(1, victimAge);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    VictimPojo victim = extractVictimFromResultSet(resultSet);
                    optionalVictim = Optional.of(victim);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionalVictim;
    }

    @Override
    public List<VictimPojo> fetchByVaccinatedStatus(boolean isVaccinated) {
        List<VictimPojo> victims = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.ADDRESS_FETCH_BY_DOGBREED)) {
            preparedStatement.setBoolean(1, isVaccinated);
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
    public void removeVictim(int victimAge) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.ADDRESS_DELETE)) {
            preparedStatement.setInt(1, victimAge);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public VictimPojo addVictim(VictimPojo newVictim) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.ADDRESS_ADD,
                Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, newVictim.getName());
            preparedStatement.setInt(2, newVictim.getAge());
            preparedStatement.setString(3, newVictim.getDogBreed());
            preparedStatement.setBoolean(4, newVictim.isDogVaccinatedStatus());
            preparedStatement.setString(5, newVictim.getAddress());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating victim failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newVictim.setAge(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating victim failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newVictim;
    }

    @Override
    public VictimPojo updateVictim(VictimPojo updateVictim) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSqlQueries.ADDRESS_UPDATE)) {
            preparedStatement.setString(1, updateVictim.getAddress());
            preparedStatement.setInt(2, updateVictim.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateVictim;
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

package daos;

import models.Bikes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO implements DAOInterface<Bikes> {
    private final Connection connection1 = DBconnection.getConnection();
    @Override
    public Bikes findById(int id) {

        try {
            Statement stmt = connection1.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);

            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Bikes extractUserFromResultSet(ResultSet rs) {
        try {
            Bikes myBike = new Bikes();

            myBike.setId(rs.getInt("Id"));
            myBike.setColor(rs.getNString("Lime Green"));
            myBike.setMake(rs.getNString("Specialized"));
            myBike.setModel(rs.getNString("Allez"));
            myBike.setSize(rs.getInt("Size"));
            myBike.setYear(rs.getInt("Year"));

            return myBike;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bikes> findAll() {
        try {
            Statement ps = connection1.createStatement();
            ResultSet rs = ps.executeQuery("Select * From Bikes;");
            ArrayList<Bikes> bikesList = new ArrayList<>();


            if(rs.next())
            {
                Bikes bike = extractUserFromResultSet(rs);
                bikesList.add(bike);
            }
            return bikesList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Bikes update(Bikes object) {
        return null;
    }

    @Override
    public Bikes create(Bikes dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}

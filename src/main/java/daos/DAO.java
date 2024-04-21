package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements DAOInterface<Bikes> {
    private final Connection connection1 = DBconnection.getConnection();
    @Override
    public Bikes findById(int id) {

        try {
            Statement stmt = connection1.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Bikes WHERE id=" + id);

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
            myBike.setColor(rs.getNString("Color"));
            myBike.setMake(rs.getNString("Make"));
            myBike.setModel(rs.getNString("Model"));
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
            ResultSet rs = ps.executeQuery("SELECT * FROM Bikes;");
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
    public Bikes update(Bikes dto) {
        try {
            PreparedStatement statment = connection1.prepareStatement("UPDATE Bikes SET Make =?, Model=?, Year=?, Color=?, Size=?, WHERE Id=?");
            statment.setString(1, dto.getMake());
            statment.setString(2, dto.getModel());
            statment.setInt(3,dto.getYear());
            statment.setString(4, dto.getColor());
            statment.setInt(5, dto.getSize());
            statment.setInt(6, dto.getId());
            int i = statment.executeUpdate();

            if(i == 1) {
                return findById(dto.getId());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return null;

    }

    @Override
    public Bikes create(Bikes dto) {
        try {
            PreparedStatement statment = connection1.prepareStatement("INSERT INTO Bikes VALUES (NULL, ?, ?, ?, ?, ?, ?)");
            statment.setString(1, dto.getMake());
            statment.setString(2, dto.getModel());
            statment.setInt(3,dto.getYear());
            statment.setString(4, dto.getColor());
            statment.setInt(5, dto.getSize());
            statment.setInt(6, dto.getId());
            int i = statment.executeUpdate();

            if(i == 1) {
                return findById(dto.getId());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;    }

    @Override
    public void delete(int id) {

    }
}

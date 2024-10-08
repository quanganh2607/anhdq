/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Room;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    private Connection connection;

    public DAO() throws SQLException {
        // Assuming DBContext is a class that handles the connection setup
        DBContext dbContext = new DBContext();
        this.connection = dbContext.getConnection();
    }

    public List<Room> getAllRooms() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT Room.Room_id, Room.Motel_id, Room.Type_id, Room_Type.Name as roomTypeName, Motels.Motel_name as motelName "
                + "FROM Room "
                + "JOIN Room_Type ON Room.Type_id = Room_Type.Type_id "
                + "JOIN Motels ON Room.Motel_id = Motels.Motel_id";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Room room = new Room(
                    rs.getInt("Room_id"),
                    rs.getInt("Motel_id"),
                    rs.getInt("Type_id"),
                    rs.getString("roomTypeName"),
                    rs.getString("motelName")
            );
            rooms.add(room);
        }
        return rooms;
    }

    public List<Room> searchRooms(Integer motelId, String typeName) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT Room.Room_id, Room.Motel_id, Room.Type_id, Room_Type.Name as roomTypeName, Motels.Motel_name as motelName "
                + "FROM Room "
                + "JOIN Room_Type ON Room.Type_id = Room_Type.Type_id "
                + "JOIN Motels ON Room.Motel_id = Motels.Motel_id WHERE 1=1";
        if (motelId != null) {
            query += " AND Room.Motel_id = ?";
        }
        if (typeName != null) {
            query += " AND Room_Type.Name = ?";
        }

        PreparedStatement ps = connection.prepareStatement(query);
        int paramIndex = 1;
        if (motelId != null) {
            ps.setInt(paramIndex++, motelId);
        }
        if (typeName != null) {
            ps.setString(paramIndex++, typeName);
        }

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Room room = new Room(
                    rs.getInt("Room_id"),
                    rs.getInt("Motel_id"),
                    rs.getInt("Type_id"),
                    rs.getString("roomTypeName"),
                    rs.getString("motelName")
            );
            rooms.add(room);
        }
        return rooms;
    }

    public static void main(String[] args) {
        try {
            DAO dao = new DAO();
            System.out.println();
            List<Room> rooms = dao.getAllRooms();
            for(Room room : rooms){
                System.out.println(room.getRoomId());
                System.out.println(room.getMotelName());
                System.out.println(room.getRoomTypeName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

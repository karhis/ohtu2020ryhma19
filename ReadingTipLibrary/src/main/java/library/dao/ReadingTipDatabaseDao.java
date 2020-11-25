package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadingTipDatabaseDao implements ReadingTipDao {

    private String databaseAddress;

//    @Override
//    public List<String> getAllTips(int userId) throws Exception {
//
//        Connection conn = DriverManager.getConnection(databaseAddress);
//        Statement stmt = conn.createStatement();
//        ResultSet result = stmt.executeQuery("SELECT * FROM ReadingTip");
//
//        List<ReadingTip> readingTips = new ArrayList<>();
//
//        while (result.next()) {
//            String title = result.getString("title");
//            int id = result.getInt("id");
//
//            ReadingTip readingTip = new ReadingTip(id, title);
//            readingTips.add(todo);
//        }
//
//        conn.close();
//
//        return readingTips;
//
//    }

    @Override
    public void addTip(String title) throws Exception {

        Connection conn = DriverManager.getConnection(databaseAddress);
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO ReadingTip (title) "
                + "VALUES (?)");
        stmt.setString(1, title);
        stmt.execute();

        conn.close();
    }

//    @Override
//    public void removeTip(String id) throws Exception {
//        
//        Connection conn = DriverManager.getConnection(databaseAddress);
//        PreparedStatement stmt = conn.prepareStatement("DELETE FROM ReadingTip WHERE id = ?");
//        stmt.setInt(1, Integer.parseInt(id));
//        stmt.execute();
//        conn.close();
//    }
}
package view;

import model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {
    private List<Mail> emails;
    public MailListReaderBD() {
        emails= new ArrayList<Mail>();
        this.connect();
    }

    private Connection connect() {
// SQLite connection string
        String url = "jdbc:sqlite:H:\\SQLiteDatabaseBrowserPortable\\Data\\KATA5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Mail> read() {
        this.connect();
        String sql = "SELECT * FROM mail";
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                emails.add(new Mail(rs.getString("Mail")));
            }
            System.out.print(emails);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return this.emails;
    }

}

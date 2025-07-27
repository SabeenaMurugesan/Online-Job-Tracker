import java.sql.*;
import java.util.*;

public class JobDAO {
    private final String url = "jdbc:mysql://localhost:3306/job_tracker";
    private final String user = "root";
    private final String password = ""; // Replace with your MySQL password

    public void insertJob(Job job) throws Exception {
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO jobs (company, role, status, applied_on) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, job.getCompany());
        ps.setString(2, job.getRole());
        ps.setString(3, job.getStatus());
        ps.setString(4, job.getAppliedOn());
        ps.executeUpdate();
        conn.close();
    }

    public List<Job> getAllJobs() throws Exception {
        List<Job> jobs = new ArrayList<>();
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM jobs";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Job job = new Job(
                rs.getString("company"),
                rs.getString("role"),
                rs.getString("status"),
                rs.getString("applied_on")
            );
            jobs.add(job);
        }

        conn.close();
        return jobs;
    }
}

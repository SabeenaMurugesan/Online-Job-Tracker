public class Job {
    private int id;
    private String company;
    private String role;
    private String status;
    private String appliedOn;

    public Job(String company, String role, String status, String appliedOn) {
        this.company = company;
        this.role = role;
        this.status = status;
        this.appliedOn = appliedOn;
    }

    // Getters and setters
    public String getCompany() { return company; }
    public String getRole() { return role; }
    public String getStatus() { return status; }
    public String getAppliedOn() { return appliedOn; }
}

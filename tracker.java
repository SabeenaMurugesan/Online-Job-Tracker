import java.util.*;

public class JobTrackerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JobDAO dao = new JobDAO();

        while (true) {
            System.out.println("\n--- Online Job Tracker ---");
            System.out.println("1. Add Job");
            System.out.println("2. View All Jobs");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine(); // clear buffer

            try {
                if (option == 1) {
                    System.out.print("Company Name: ");
                    String company = sc.nextLine();
                    System.out.print("Job Role: ");
                    String role = sc.nextLine();
                    System.out.print("Application Status: ");
                    String status = sc.nextLine();
                    System.out.print("Applied On (YYYY-MM-DD): ");
                    String appliedOn = sc.nextLine();

                    Job job = new Job(company, role, status, appliedOn);
                    dao.insertJob(job);
                    System.out.println("✅ Job added successfully!");
                } else if (option == 2) {
                    List<Job> jobs = dao.getAllJobs();
                    System.out.println("\nYour Job Applications:");
                    for (Job j : jobs) {
                        System.out.println("Company: " + j.getCompany() + ", Role: " + j.getRole()
                                + ", Status: " + j.getStatus() + ", Applied On: " + j.getAppliedOn());
                    }
                } else if (option == 3) {
                    System.out.println("👋 Exiting. Thank you!");
                    break;
                } else {
                    System.out.println("❌ Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}

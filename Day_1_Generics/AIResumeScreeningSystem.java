import java.util.ArrayList;
import java.util.List;
abstract class JobRole {
    String candidateName;

    JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String candidateName) {
        super(candidateName);
    }
}

class DataScientist extends JobRole {
    DataScientist(String candidateName) {
        super(candidateName);
    }
}

class ProductManager extends JobRole {
    ProductManager(String candidateName) {
        super(candidateName);
    }
}

class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public List<T> getResumes() {
        return resumes;
    }

    public static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println("Screening Resume of: " + resume.getCandidateName());
        }
    }
}

public class AIResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareResumes = new Resume<>();
        softwareResumes.addResume(new SoftwareEngineer("Alice"));
        softwareResumes.addResume(new SoftwareEngineer("Bob"));

        Resume<DataScientist> dataResumes = new Resume<>();
        dataResumes.addResume(new DataScientist("Charlie"));
        dataResumes.addResume(new DataScientist("Diana"));

        Resume<ProductManager> productResumes = new Resume<>();
        productResumes.addResume(new ProductManager("Eve"));
        productResumes.addResume(new ProductManager("Frank"));

        System.out.println("Software Engineer Resumes:");
        Resume.screenResumes(softwareResumes.getResumes());

        System.out.println("Data Scientist Resumes:");
        Resume.screenResumes(dataResumes.getResumes());

        System.out.println("Product Manager Resumes:");
        Resume.screenResumes(productResumes.getResumes());
    }
}

import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> priorityQueue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));

        priorityQueue.add(new Patient("John", 3));
        priorityQueue.add(new Patient("Alice", 5));
        priorityQueue.add(new Patient("Bob", 2));

        System.out.println("Order of treatment:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}

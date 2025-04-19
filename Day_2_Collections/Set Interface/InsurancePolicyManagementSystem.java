import java.util.*;
import java.time.LocalDate;

class InsurancePolicy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return policyNumber.equals(that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagementSystem {

    private static HashSet<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private static LinkedHashSet<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private static TreeSet<InsurancePolicy> treeSetPolicies = new TreeSet<>(Comparator.comparing(policy -> policy.expiryDate));

    public static void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public static void displayAllPolicies() {
        System.out.println("HashSet Policies:");
        hashSetPolicies.forEach(System.out::println);
        System.out.println("LinkedHashSet Policies:");
        linkedHashSetPolicies.forEach(System.out::println);
        System.out.println("TreeSet Policies (Sorted by Expiry Date):");
        treeSetPolicies.forEach(System.out::println);
    }

    public static void displayExpiringSoonPolicies() {
        LocalDate currentDate = LocalDate.now();
        LocalDate expiryThreshold = currentDate.plusDays(30);
        System.out.println("Policies expiring soon (within 30 days):");
        treeSetPolicies.stream()
                .filter(policy -> policy.expiryDate.isBefore(expiryThreshold) && policy.expiryDate.isAfter(currentDate))
                .forEach(System.out::println);
    }

    public static void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("Policies with coverage type " + coverageType + ":");
        treeSetPolicies.stream()
                .filter(policy -> policy.coverageType.equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    public static void displayDuplicatePolicies() {
        Set<String> seenPolicyNumbers = new HashSet<>();
        Set<InsurancePolicy> duplicatePolicies = new HashSet<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            if (!seenPolicyNumbers.add(policy.policyNumber)) {
                duplicatePolicies.add(policy);
            }
        }
        System.out.println("Duplicate Policies:");
        duplicatePolicies.forEach(System.out::println);
    }

    public static void performanceComparison() {
        long startTime = System.nanoTime();
        hashSetPolicies.add(new InsurancePolicy("P001", "John Doe", LocalDate.of(2024, 12, 15), "Health", 1200));
        long endTime = System.nanoTime();
        System.out.println("HashSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        hashSetPolicies.contains(new InsurancePolicy("P001", "John Doe", LocalDate.of(2024, 12, 15), "Health", 1200));
        endTime = System.nanoTime();
        System.out.println("HashSet Contains Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        hashSetPolicies.remove(new InsurancePolicy("P001", "John Doe", LocalDate.of(2024, 12, 15), "Health", 1200));
        endTime = System.nanoTime();
        System.out.println("HashSet Remove Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSetPolicies.add(new InsurancePolicy("P002", "Jane Smith", LocalDate.of(2024, 11, 10), "Auto", 1000));
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSetPolicies.contains(new InsurancePolicy("P002", "Jane Smith", LocalDate.of(2024, 11, 10), "Auto", 1000));
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Contains Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSetPolicies.remove(new InsurancePolicy("P002", "Jane Smith", LocalDate.of(2024, 11, 10), "Auto", 1000));
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Remove Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSetPolicies.add(new InsurancePolicy("P003", "Alice Cooper", LocalDate.of(2024, 10, 5), "Home", 1500));
        endTime = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSetPolicies.contains(new InsurancePolicy("P003", "Alice Cooper", LocalDate.of(2024, 10, 5), "Home", 1500));
        endTime = System.nanoTime();
        System.out.println("TreeSet Contains Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSetPolicies.remove(new InsurancePolicy("P003", "Alice Cooper", LocalDate.of(2024, 10, 5), "Home", 1500));
        endTime = System.nanoTime();
        System.out.println("TreeSet Remove Time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        addPolicy(new InsurancePolicy("P001", "John Doe", LocalDate.of(2024, 12, 15), "Health", 1200));
        addPolicy(new InsurancePolicy("P002", "Jane Smith", LocalDate.of(2024, 11, 10), "Auto", 1000));
        addPolicy(new InsurancePolicy("P003", "Alice Cooper", LocalDate.of(2024, 10, 5), "Home", 1500));
        addPolicy(new InsurancePolicy("P004", "Bob Brown", LocalDate.of(2024, 9, 30), "Health", 1300));

        displayAllPolicies();
        displayExpiringSoonPolicies();
        displayPoliciesByCoverageType("Health");
        displayDuplicatePolicies();
        performanceComparison();
    }
}

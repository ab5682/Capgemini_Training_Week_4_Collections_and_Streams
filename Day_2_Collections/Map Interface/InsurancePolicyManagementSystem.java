import java.util.*;
import java.text.*;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry Date: " + sdf.format(expiryDate) + ", Premium: " + premiumAmount;
    }
}

class InsuranceSystem {
    private Map<String, InsurancePolicy> policyMap;
    private LinkedHashMap<String, InsurancePolicy> orderedPolicyMap;
    private TreeMap<Date, List<InsurancePolicy>> policiesByExpiryDate;

    public InsuranceSystem() {
        policyMap = new HashMap<>();
        orderedPolicyMap = new LinkedHashMap<>();
        policiesByExpiryDate = new TreeMap<>();
    }

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);

        policiesByExpiryDate.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public void listPoliciesExpiringSoon() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date dateIn30Days = calendar.getTime();

        System.out.println("\nPolicies expiring within the next 30 days:");
        for (Map.Entry<Date, List<InsurancePolicy>> entry : policiesByExpiryDate.entrySet()) {
            if (!entry.getKey().after(dateIn30Days)) {
                for (InsurancePolicy policy : entry.getValue()) {
                    System.out.println(policy);
                }
            }
        }
    }

    public void listPoliciesByPolicyholder(String policyholderName) {
        System.out.println("\nPolicies for " + policyholderName + ":");
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equals(policyholderName)) {
                System.out.println(policy);
            }
        }
    }

    public void removeExpiredPolicies() {
        Date today = new Date();
        List<String> expiredPolicyNumbers = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getExpiryDate().before(today)) {
                expiredPolicyNumbers.add(policy.getPolicyNumber());
            }
        }
        for (String policyNumber : expiredPolicyNumbers) {
            policyMap.remove(policyNumber);
            orderedPolicyMap.remove(policyNumber);
        }
        System.out.println("\nExpired policies have been removed.");
    }

    public void displayAllPolicies() {
        System.out.println("\nAll policies:");
        for (InsurancePolicy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }

    public void displayPoliciesSortedByExpiryDate() {
        System.out.println("\nPolicies sorted by expiry date:");
        for (Map.Entry<Date, List<InsurancePolicy>> entry : policiesByExpiryDate.entrySet()) {
            for (InsurancePolicy policy : entry.getValue()) {
                System.out.println(policy);
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        InsuranceSystem system = new InsuranceSystem();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        system.addPolicy(new InsurancePolicy("P001", "Alice", sdf.parse("2025-06-15"), 500.0));
        system.addPolicy(new InsurancePolicy("P002", "Bob", sdf.parse("2025-05-30"), 300.0));
        system.addPolicy(new InsurancePolicy("P003", "Charlie", sdf.parse("2025-06-05"), 400.0));
        system.addPolicy(new InsurancePolicy("P004", "Alice", sdf.parse("2025-07-01"), 600.0));

        system.displayAllPolicies();

        system.listPoliciesExpiringSoon();

        system.listPoliciesByPolicyholder("Alice");

        system.removeExpiredPolicies();

        system.displayAllPolicies();
        system.displayPoliciesSortedByExpiryDate();
    }
}

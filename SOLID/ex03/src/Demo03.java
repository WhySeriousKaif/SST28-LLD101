import java.util.*;

public class Demo03 {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");

        List<EligibilityRule> rules = Arrays.asList(
                new DisciplinaryRule(),
                new CgrRule(),
                new AttendanceRule(),
                new CreditsRule());

        FakeEligibilityStore store = new FakeEligibilityStore();
        EligibilityEngine engine = new EligibilityEngine(store, rules);

        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.1, 72, 18, LegacyFlags.NONE);
        engine.runAndPrint(s);
    }
}

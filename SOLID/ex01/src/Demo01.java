public class Demo01 {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");

        StudentStore db = new FakeDb();
        StudentParser parser = new StudentParser();
        StudentValidator validator = new StudentValidator();
        StudentPrinter printer = new StudentPrinter();

        OnboardingService svc = new OnboardingService(db, parser, validator, printer);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        printer.printDbDump(db);
    }
}

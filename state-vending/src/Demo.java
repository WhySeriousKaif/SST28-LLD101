interface State {
    void insertMoney();
    void ejectMoney();
    void selectProduct();
    void dispense();
}

class IdleState implements State {
    VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Money inserted.");
        machine.setState(machine.getInsertedMoneyState());
    }

    @Override
    public void ejectMoney() {
        System.out.println("No money to eject.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Insert money first.");
    }

    @Override
    public void dispense() {
        System.out.println("Nothing to dispense.");
    }
}

class InsertedMoneyState implements State {
    VendingMachine machine;

    public InsertedMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Already inserted money.");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Money ejected.");
        machine.setState(machine.getIdleState());
    }

    @Override
    public void selectProduct() {
        System.out.println("Product selected.");
        machine.setState(machine.getDispensingState());
    }

    @Override
    public void dispense() {
        System.out.println("Select product first.");
    }
}

class DispensingState implements State {
    VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Wait, dispensing product.");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Cannot eject, dispensing product.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Already selected.");
    }

    @Override
    public void dispense() {
        System.out.println("Product dispensed.");
        machine.setState(machine.getIdleState());
    }
}

class VendingMachine {
    private State idleState;
    private State insertedMoneyState;
    private State dispensingState;

    private State currentState;

    public VendingMachine() {
        idleState = new IdleState(this);
        insertedMoneyState = new InsertedMoneyState(this);
        dispensingState = new DispensingState(this);
        currentState = idleState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void insertMoney() { currentState.insertMoney(); }
    public void ejectMoney() { currentState.ejectMoney(); }
    public void selectProduct() { currentState.selectProduct(); }
    public void dispense() { currentState.dispense(); }

    public State getIdleState() { return idleState; }
    public State getInsertedMoneyState() { return insertedMoneyState; }
    public State getDispensingState() { return dispensingState; }
}

public class Demo {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        System.out.println("Scenario 1: Full cycle");
        machine.insertMoney();
        machine.selectProduct();
        machine.dispense();

        System.out.println("\nScenario 2: Eject money");
        machine.insertMoney();
        machine.ejectMoney();

        System.out.println("\nScenario 3: Invalid actions");
        machine.selectProduct();
        machine.dispense();
    }
}

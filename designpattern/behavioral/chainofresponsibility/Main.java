// The request class
class ExpenseRequest {
    private double amount;
    private String purpose;

    public ExpenseRequest(double amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public String getPurpose() {
        return purpose;
    }
}

// Base handler
abstract class ExpenseHandler {
    protected ExpenseHandler nextHandler;
    protected double approvalLimit;

    public void setNext(ExpenseHandler handler) {
        this.nextHandler = handler;
    }

    public void processRequest(ExpenseRequest request) {
        if (request.getAmount() <= approvalLimit) {
            approve(request);
        } else if (nextHandler != null) {
            nextHandler.processRequest(request);
        } else {
            System.out.println("Request needs board approval!");
        }
    }

    protected abstract void approve(ExpenseRequest request);
}

// Concrete handler for Team Lead
class TeamLead extends ExpenseHandler {
    public TeamLead() {
        this.approvalLimit = 1000; // Can approve up to $1000
    }

    @Override
    protected void approve(ExpenseRequest request) {
        System.out.println("Team Lead approved expense of $" + request.getAmount() 
            + " for " + request.getPurpose());
    }
}

// Concrete handler for Manager
class Manager extends ExpenseHandler {
    public Manager() {
        this.approvalLimit = 5000; // Can approve up to $5000
    }

    @Override
    protected void approve(ExpenseRequest request) {
        System.out.println("Manager approved expense of $" + request.getAmount() 
            + " for " + request.getPurpose());
    }
}

// Concrete handler for Director
class Director extends ExpenseHandler {
    public Director() {
        this.approvalLimit = 10000; // Can approve up to $10000
    }

    @Override
    protected void approve(ExpenseRequest request) {
        System.out.println("Director approved expense of $" + request.getAmount() 
            + " for " + request.getPurpose());
    }
}

// Main class to demonstrate usage
public class Main {
    public static void main(String[] args) {
        // Create the chain of responsibility
        TeamLead teamLead = new TeamLead();
        Manager manager = new Manager();
        Director director = new Director();

        // Set up the chain
        teamLead.setNext(manager);
        manager.setNext(director);

        // Create some expense requests
        ExpenseRequest request1 = new ExpenseRequest(400, "Office Supplies");
        ExpenseRequest request2 = new ExpenseRequest(4000, "Team Building");
        ExpenseRequest request3 = new ExpenseRequest(8000, "Training Program");
        ExpenseRequest request4 = new ExpenseRequest(15000, "New Equipment");

        // Process the requests
        System.out.println("Processing expense requests...\n");
        
        teamLead.processRequest(request1);  // Will be approved by Team Lead
        teamLead.processRequest(request2);  // Will be approved by Manager
        teamLead.processRequest(request3);  // Will be approved by Director
        teamLead.processRequest(request4);  // Will need board approval
    }
}
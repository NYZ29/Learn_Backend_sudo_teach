class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    private boolean isActive;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Номер счёта обязателен");
        }
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя владельца обязательно");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.isActive = true;
    }

    public BankAccount(String accountNumber, String ownerName) {
        this(accountNumber, ownerName, 0);
    }

    public void deposit(double amount) {
        if (!isActive) {
            System.out.println("Счёт заблокирован!");
            return;
        }
        if (amount <= 0) {
            System.out.println("Сумма должна быть положительной");
            return;
        }
        balance += amount;
        System.out.printf("Зачислено %.2f руб. Баланс: %.2f руб.%n", amount, balance);
    }

    public boolean withdraw(double amount) {
        if (!isActive) {
            System.out.println("Счёт заблокирован!");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Сумма должна быть положительной");
            return false;
        }
        if (amount > balance) {
            System.out.printf("Недостаточно средств. Баланс: %.2f руб.%n", balance);
            return false;
        }
        balance -= amount;
        System.out.printf("Списано %.2f руб. Баланс: %.2f руб.%n", amount, balance);
        return true;
    }

    public void close() {
        isActive = false;
        System.out.println("Счёт " + accountNumber + " закрыт");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void displayInfo() {
        System.out.println("Счёт: " + accountNumber);
        System.out.println("Владелец: " + ownerName);
        System.out.printf("Баланс: %.2f руб.%n", balance);
        System.out.println("Статус: " + (isActive ? "активен" : "закрыт"));
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println();

        BankAccount acc1 = new BankAccount("123456", "Иванов И.И.", 10000);
        acc1.deposit(5000);
        acc1.withdraw(3000);
        acc1.displayInfo();

        System.out.println("---");

        BankAccount acc2 = new BankAccount("789012", "Петров П.П.");
        acc2.deposit(1000);
        acc2.displayInfo();
    }
}
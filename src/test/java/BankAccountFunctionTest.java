import it.proactivity.BankAccount;
import it.proactivity.BankAccountFunction;
import it.proactivity.BankAccountOperation;
import it.proactivity.BankAccountOpertionEnum;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountFunctionTest {

    @Test
    public void createBanckAccountTest() {
        BankAccount bankAccount = BankAccountFunction.createBanckAccount("IT0989CF988343X00012345688", "Paolo", "de Paoli");
        assertNotEquals(null, bankAccount);
    }

    public List<BankAccountOperation> createBankAccountOperationList() {
        return  Arrays.asList(
                new BankAccountOperation(1l, LocalDate.of(2022, 1, 21), BankAccountOpertionEnum.Balance, "balance view", 0f),
                new BankAccountOperation(1l, LocalDate.of(2022, 1, 21), BankAccountOpertionEnum.Payment, "first payment", 150.50f),
                new BankAccountOperation(1l, LocalDate.of(2022, 3, 14), BankAccountOpertionEnum.Payment, "second payment", 150.50f),
                new BankAccountOperation(1l, LocalDate.of(2022, 3, 21), BankAccountOpertionEnum.Balance, "balance view", 0f),
                new BankAccountOperation(1l, LocalDate.of(2022, 5, 7), BankAccountOpertionEnum.Transfer, "money transfer to Cloe", 10.42f),
                new BankAccountOperation(1l, LocalDate.of(2022, 5, 21), BankAccountOpertionEnum.Withdrawal, "balance view", 80f),
                new BankAccountOperation(1l, LocalDate.of(2022, 6, 12), BankAccountOpertionEnum.Withdrawal, "balance view", 80f),
                new BankAccountOperation(1l, LocalDate.of(2022, 6, 17), BankAccountOpertionEnum.Payment, "third payment", 1150.50f),
                new BankAccountOperation(1l, LocalDate.of(2022, 6, 21), BankAccountOpertionEnum.Payment, "fourth payment", 250.50f),
                new BankAccountOperation(1l, LocalDate.of(2022, 7, 4), BankAccountOpertionEnum.Withdrawal, "balance view", 40f),
                new BankAccountOperation(1l, LocalDate.of(2022, 7, 4), BankAccountOpertionEnum.Withdrawal, "balance view", 80f),
                new BankAccountOperation(1l, LocalDate.of(2022, 7, 21), BankAccountOpertionEnum.Payment, "fifth payment", 1150.50f),
                new BankAccountOperation(1l, LocalDate.of(2022, 10, 4), BankAccountOpertionEnum.Payment, "sixth payment", 550.50f),
                new BankAccountOperation(1l, LocalDate.of(2022, 10, 5), BankAccountOpertionEnum.Payment, "seventh payment", 850.50f),
                new BankAccountOperation(1l, LocalDate.of(2022, 10, 6), BankAccountOpertionEnum.Transfer, "money transfer to Jim", 567.98f),
                new BankAccountOperation(1l, LocalDate.of(2022, 11, 2), BankAccountOpertionEnum.Transfer, "money transfer to Jow", 67.42f),
                new BankAccountOperation(1l, LocalDate.of(2022, 12, 21), BankAccountOpertionEnum.Balance, "balance view", 0f));
    }

    public BankAccount createBankAaccountForTest() {
        BankAccount bankAccount = BankAccountFunction.createBanckAccount("IT0989CF988343X00012345688", "Paolo", "de Paoli");
        bankAccount.setBankAccountOperationList(createBankAccountOperationList());
        return bankAccount;
    }

    @Test
    public void totalBankAccountOperationTest() {
        assertEquals(17, BankAccountFunction.totalBankAccountOperation(createBankAaccountForTest()));
    }

    @Test
    public void totalBankAccountBalanceOperationTest() {
        assertEquals(3, BankAccountFunction.totalBankAccountBalanceOperation(createBankAaccountForTest()));
    }

    @Test
    public void totalAmountOfMoneyTransferTest() {
        assertEquals(645,82f, BankAccountFunction.totalAmountOfMoneyTransfer(createBankAaccountForTest()));
    }

    @Test
    public void bankAccountOperationSummaryListTest() {
        assertEquals(17, BankAccountFunction.bankAccountOperationSummaryList(createBankAaccountForTest()).size());
    }

    @Test
    public void bankAccountOperationSummaryListBetweenIntervalTest() {
        assertEquals(7, BankAccountFunction.bankAccountOperationSummaryListBetweenInterval(createBankAaccountForTest(),
                LocalDate.of(2022, 5, 7), LocalDate.of(2022, 7, 4)).size());
    }

    @Test
    public void moneyTransferToPeopleWithInitialNameStartTest() {
        assertEquals(2, BankAccountFunction.moneyTransferToPeopleWithInitialNameStart(createBankAaccountForTest(), "J"));
    }
}

package my.rinat;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz_2_9Test {

    @Test
    public void shouldFindNonEmptyAccounts() {
        List<Account> nonEmptyAccounts = accounts
                .stream()
                .filter(account -> account.getBalance() > 0)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(nonEmptyAccounts.toArray(new Account[nonEmptyAccounts.size()])));
        Assert.assertEquals(2, nonEmptyAccounts.size());
        Assert.assertEquals("2", nonEmptyAccounts.get(0).getNumber());
        Assert.assertEquals("3", nonEmptyAccounts.get(1).getNumber());
    }

    @Test
    public void shouldFindAccountsWithTooMuchMoney() {
        List<Account> accountsWithTooMuchMoney = accounts
                .stream()
                .filter(account -> account.getBalance() >= 100_000_000L && !account.isLocked())
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(accountsWithTooMuchMoney.toArray(new Account[accountsWithTooMuchMoney.size()])));
        Assert.assertEquals(1, accountsWithTooMuchMoney.size());
        Assert.assertEquals("3", accountsWithTooMuchMoney.get(0).getNumber());
    }

    private static final List<Account> accounts = Arrays.asList(
            new Account("1", 0L, false),
            new Account("2", 1L, true),
            new Account("3", 100_000_000L, false)
    );

    private static class Account {
        private String number;
        private Long balance;
        private boolean isLocked;

        Account(String number, Long balance, boolean isLocked) {
            this.number = number;
            this.balance = balance;
            this.isLocked = isLocked;
        }

        String getNumber() {
            return number;
        }

        Long getBalance() {
            return balance;
        }

        boolean isLocked() {
            return isLocked;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "number='" + number + '\'' +
                    ", balance=" + balance +
                    ", isLocked=" + isLocked +
                    '}';
        }
    }

}

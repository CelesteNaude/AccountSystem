package za.ac.nwu.acsys.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;
import za.ac.nwu.acsys.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTransactionDto implements Serializable {

    public static final long serialVersionUID = -6731456901152363824L;

    private Long transactionId;
    private String accountTypeMnemonic;
    private Long memberId;
    private Long amount;
    private Long balance;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Long transactionId, String accountTypeMnemonic, Long memberId, Long amount, Long balance, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.balance = balance;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.transactionId = accountTransaction.getTransactionId();
        this.accountTypeMnemonic = accountTransaction.getAccountType().getMnemonic();
        this.memberId = accountTransaction.getMemberId();
        this.amount = accountTransaction.getAmount();
        this.balance = accountTransaction.getBalance();
        this.transactionDate = accountTransaction.getTransactionDate();
    }

    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountType accountType) {
        return new AccountTransaction(this.getTransactionId(), accountType, this.getMemberId(),
                this.getAmount(), this.getBalance(), this.getTransactionDate());
    }


    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }

    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return transactionId.equals(that.transactionId) && accountTypeMnemonic.equals(that.accountTypeMnemonic) && memberId.equals(that.memberId) && amount.equals(that.amount) && balance.equals(that.balance) && transactionDate.equals(that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountTypeMnemonic, memberId, amount, balance, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionId=" + transactionId +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", balance=" + balance +
                ", transactionDate=" + transactionDate +
                '}';
    }
}

package za.ac.nwu.acsys.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSAX")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 5320578342102714156L;

    private Long transactionId;
    private AccountType accountType; // Foreign key
    private Long memberId;
    private AccountInfo accountInfo;
    private Long amount;
    private LocalDate transactionDate;

    // Alt+Insert -> Constructor (select none)
    public AccountTransaction() {
    }

    // Alt+Insert -> Constructor (select all)
    public AccountTransaction(Long transactionId, AccountType accountType, Long memberId, AccountInfo accountInfo, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.accountInfo = accountInfo;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "NWU_GENERIC_SEQ", sequenceName = "NWU_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NWU_GENERIC_SEQ")
    @Column(name = "TRANSAX_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    // Lazy only pulls data from the table if you want to use it
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INFO_ID")
    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    @Column(name = "TRANSAX_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }



    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Alt+Insert -> equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return transactionId.equals(that.transactionId) && accountType.equals(that.accountType) && memberId.equals(that.memberId) && accountInfo.equals(that.accountInfo) && amount.equals(that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, accountInfo, amount, transactionDate);
    }

    // Alt+Insert -> toString()
    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType +
                ", memberId=" + memberId +
                ", accountInfo=" + accountInfo +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}

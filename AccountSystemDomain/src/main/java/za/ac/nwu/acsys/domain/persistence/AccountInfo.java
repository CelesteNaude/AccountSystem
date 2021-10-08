package za.ac.nwu.acsys.domain.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACCOUNT_INFO")
public class AccountInfo implements Serializable {

    private static final long serialVersionUID = -6775099641025189787L;
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountInfo.class);

    private Long accountInfoId;
    private AccountType accountType;
    private Long memberId;
    private Long balance;

    private Set<AccountTransaction> accountTransactions;

    public AccountInfo() {
    }

    public AccountInfo(Long accountInfoId, AccountType accountType, Long memberId, Long balance) {
        this.accountInfoId = accountInfoId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.balance = balance;
    }

    @Id
    @SequenceGenerator(name = "NWU_GENERIC_SEQ", sequenceName = "NWU_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NWU_GENERIC_SEQ")
    // Alt+Insert -> Getter and Setter
    @Column(name = "INFO_ID")
    public Long getAccountInfoId() {
        return accountInfoId;
    }

    public void setAccountInfoId(Long accountInfoId) {
        this.accountInfoId = accountInfoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "BALANCE")
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountInfo")
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountInfo that = (AccountInfo) o;
        return accountInfoId.equals(that.accountInfoId) && accountType.equals(that.accountType) && memberId.equals(that.memberId) && balance.equals(that.balance) && accountTransactions.equals(that.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfoId, accountType, memberId, balance, accountTransactions);
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "accountInfoId=" + accountInfoId +
                ", accountType=" + accountType +
                ", memberId=" + memberId +
                ", balance=" + balance +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}

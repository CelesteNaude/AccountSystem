package za.ac.nwu.acsys.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 3833725316797154577L;

    private Long accountTypeId;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    private Set<AccountTransaction> accountTransactions;
    private Set<AccountInfo> accountInfos;

    // Alt+Insert -> Constructor (select none)
    // Default constructor
    public AccountType() {
    }

    // Alt+Insert -> Constructor (select all)
    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }


    // Used by AccountTypeDto
    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    @Id
    @SequenceGenerator(name = "NWU_GENERIC_SEQ", sequenceName = "NWU_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NWU_GENERIC_SEQ")
    // Alt+Insert -> Getter and Setter
    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }

//    Never cascade a transaction table (AccountTransaction) from a config table (AccountType)
//    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType")
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    @OneToMany(targetEntity = AccountInfo.class, fetch = FetchType.LAZY, mappedBy = "accountType")
    public Set<AccountInfo> getAccountInfos() {
        return accountInfos;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {this.accountTransactions = accountTransactions;}

    public void setAccountInfos(Set<AccountInfo> accountInfos) {this.accountInfos = accountInfos;}

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    // Alt+Insert -> equals() and hashCode()


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return accountTypeId.equals(that.accountTypeId) && mnemonic.equals(that.mnemonic) && accountTypeName.equals(that.accountTypeName) && Objects.equals(creationDate, that.creationDate) && accountTransactions.equals(that.accountTransactions) && accountInfos.equals(that.accountInfos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, accountTypeName, creationDate, accountTransactions, accountInfos);
    }

    // Alt+Insert -> toString()

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                ", accountTransactions=" + accountTransactions +
                ", accountInfos=" + accountInfos +
                '}';
    }
}

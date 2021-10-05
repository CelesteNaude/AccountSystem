package za.ac.nwu.acsys.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;
import za.ac.nwu.acsys.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTD that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    public static final long serialVersionUID = -6731456901152363824L;

    private Long transactionId;
    private String accountType;
    private Long memberId;
    private Long accountInfo;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Long transactionId, String accountType, Long memberId, Long accountInfo, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.accountInfo = accountInfo;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.transactionId = accountTransaction.getTransactionId();
        this.accountType = accountTransaction.getAccountType().getMnemonic();
        this.memberId = accountTransaction.getMemberId();
        this.accountInfo = accountTransaction.getAccountInfo().getAccountInfoId();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();
    }

    @ApiModelProperty(position = 1,
            value = "AccountTransaction Id",
            name = "transactionId",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.Long",
            example = "1",
            required = true)
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

        @ApiModelProperty(position = 3,
            value = "Member Id",
            name = "MemberId",
            notes = "Uniquely identifies the member",
            dataType = "java.lang.Long",
            example = "2",
            required = true)
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(position = 4,
            value = "AccountInfo Id",
            name = "AccountInfo",
            notes = "Uniquely identifies the account information",
            dataType = "java.lang.Long",
            example = "1",
            required = true)
    public Long getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(Long accountInfo) {
        this.accountInfo = accountInfo;
    }

        @ApiModelProperty(position = 5,
            value = "AccountTransaction Amount",
            name = "Amount",
            notes = "The amount of an account transaction",
            dataType = "java.lang.Long",
            example = "200",
            required = true)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

        @ApiModelProperty(position = 6,
            value = "AccountTransaction Transaction Date",
            name = "TransactionDate",
            notes = "The date on which the AccountTransaction was occurred",
            dataType = "java.lang.LocalDate",
            example = "2020-04-01",
            required = true)
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @JsonIgnore
    public  AccountTransaction getAccountTransaction(AccountType accountType, AccountInfo accountInfo) {
        return new AccountTransaction(this.getTransactionId(), accountType, this.getMemberId(), accountInfo, this.getAmount(), this.getTransactionDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return transactionId.equals(that.transactionId) && accountType.equals(that.accountType) && memberId.equals(that.memberId) && accountInfo.equals(that.accountInfo) && amount.equals(that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, accountInfo, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionId=" + transactionId +
                ", accountType='" + accountType + '\'' +
                ", memberId=" + memberId +
                ", accountInfo=" + accountInfo +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}

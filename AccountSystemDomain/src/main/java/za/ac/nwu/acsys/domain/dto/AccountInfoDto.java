package za.ac.nwu.acsys.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.domain.persistence.AccountType;

import java.io.Serializable;
import java.util.Objects;


@ApiModel(value = "AccountInfo", description = "A DTD that represents the AccountInfo")
public class AccountInfoDto implements Serializable {

    private static final long serialVersionUID = -5156438385259257037L;
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountInfoDto.class);

    private Long accountInfoId;
    private String accountType;
    private Long memberId;
    private Long balance;

    public AccountInfoDto() {
    }

    public AccountInfoDto(Long accountInfoId, String accountType, Long memberId, Long balance) {
        this.accountInfoId = accountInfoId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.balance = balance;
    }

    public AccountInfoDto(AccountInfo accountInfo) {
        this.accountInfoId = accountInfo.getAccountInfoId();
        this.accountType = accountInfo.getAccountType().getMnemonic();
        this.memberId = accountInfo.getMemberId();
        this.balance = accountInfo.getBalance();
    }

    @ApiModelProperty(position = 1,
            value = "AccountInfo Id",
            name = "accountInfoId",
            notes = "Uniquely identifies the account information",
            dataType = "java.lang.Long",
            example = "1",
            required = true)
    public Long getAccountInfoId() {
        return accountInfoId;
    }

    public void setAccountInfoId(Long accountInfoId) {
        this.accountInfoId = accountInfoId;
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
            value = "AccountInfo Balance",
            name = "Balance",
            notes = "The balance of an account",
            dataType = "java.lang.Long",
            example = "200",
            required = true)
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @JsonIgnore
    public AccountInfo getAccountInfo(AccountType accountType) {
        return new AccountInfo(this.getAccountInfoId(), accountType, this.getMemberId(), this.getBalance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountInfoDto that = (AccountInfoDto) o;
        return accountInfoId.equals(that.accountInfoId) && accountType.equals(that.accountType) && memberId.equals(that.memberId) && balance.equals(that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountInfoId, accountType, memberId, balance);
    }

    @Override
    public String toString() {
        return "AccountInfoDto{" +
                "accountInfoId=" + accountInfoId +
                ", accountType='" + accountType + '\'' +
                ", memberId=" + memberId +
                ", balance=" + balance +
                '}';
    }
}

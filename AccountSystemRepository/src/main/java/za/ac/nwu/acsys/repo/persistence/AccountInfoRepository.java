package za.ac.nwu.acsys.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;


@Repository
public interface AccountInfoRepository extends JpaRepository<AccountInfo, Long> {

    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountInfo at" +
            "   WHERE at.accountInfoId = :accountInfoId ")
    AccountInfo getAccountBalanceById(Long accountInfoId);


    @Modifying
    @Query(value = "UPDATE " +
            "       ACCOUNT_INFO" +
            "   SET " +
            "       BALANCE = BALANCE + :amount" +
            "   WHERE INFO_ID = :accountInfo ", nativeQuery = true)
    void getAccountAddBalanceById(Long accountInfo, Long amount);


    @Modifying
    @Query(value = "UPDATE " +
            "       ACCOUNT_INFO" +
            "   SET " +
            "       BALANCE = BALANCE - :amount" +
            "   WHERE INFO_ID = :accountInfo ", nativeQuery = true)
    void getAccountSubtractBalanceById(Long accountInfo, Long amount);
}

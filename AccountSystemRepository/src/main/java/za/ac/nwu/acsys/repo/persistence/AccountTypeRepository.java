package za.ac.nwu.acsys.repo.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.domain.persistence.AccountType;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.acsys.domain.dto.AccountTypeDto( " +
            "       at.mnemonic, " +
            "       at.accountTypeName, " +
            "       at.creationDate )" +
            "   FROM " +
            "       AccountType at" +
            "   WHERE at.mnemonic = :mnemonic ")
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    @Modifying
    @Query(value = "UPDATE " +
            "       ACCOUNT_TYPE" +
            "   SET " +
            "       ACCOUNT_TYPE_NAME = :newAccountTypeName," +
            "       CREATION_DATE = :newCreationDate" +
            "   WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
    void updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newCreationDate);

    @Modifying
    @Query(value = "DELETE " +
            "   FROM " +
            "       ACCOUNT_TYPE" +
            "   WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
    void deleteAccountType(String mnemonic);
}

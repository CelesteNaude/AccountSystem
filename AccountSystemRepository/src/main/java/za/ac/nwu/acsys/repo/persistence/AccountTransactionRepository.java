package za.ac.nwu.acsys.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {


    @Query(value = "SELECT " +
            "       at" +
            "   FROM " +
            "       AccountTransaction at" +
            "   WHERE at.transactionId = :transactionId ")
    AccountTransaction getAccountTransaxById(Long transactionId);
}

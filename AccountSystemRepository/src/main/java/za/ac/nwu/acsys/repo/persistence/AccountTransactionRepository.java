package za.ac.nwu.acsys.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
}

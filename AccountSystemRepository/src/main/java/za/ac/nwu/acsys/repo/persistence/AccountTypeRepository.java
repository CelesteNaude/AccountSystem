package za.ac.nwu.acsys.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.acsys.domain.persistence.AccountType;

import java.time.LocalDate;
import java.util.Set;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

}

package za.ac.nwu.acsys.translator;

// checked

import za.ac.nwu.acsys.domain.persistence.AccountTransaction;

public interface AccountTransactionTranslator {
    AccountTransaction save(AccountTransaction accountTransaction);

    AccountTransaction getAccountTransactionByPk(Long transactionId);
}

package za.ac.nwu.acsys.translator;

import za.ac.nwu.acsys.domain.dto.AccountInfoDto;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;

public interface AccountInfoTranslator {
    AccountInfo save(AccountInfo accountInfo);

    AccountInfoDto getAccountBalanceById(Long accountInfoId);

    AccountInfo getAccountInfoDbEntityById(Long accountInfo);

    AccountInfo getAccountInfoAddById(Long accountInfo, Long amount);

    AccountInfo getAccountInfoSubtractById(Long accountInfo, Long amount);
}

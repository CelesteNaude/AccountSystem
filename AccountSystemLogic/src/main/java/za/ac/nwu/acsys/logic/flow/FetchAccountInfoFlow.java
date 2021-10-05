package za.ac.nwu.acsys.logic.flow;

import za.ac.nwu.acsys.domain.dto.AccountInfoDto;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;

public interface FetchAccountInfoFlow {
    AccountInfo getAccountInfoDbEntityById(Long accountInfo);

    AccountInfoDto getAccountBalance(Long accountInfoId);

    AccountInfo getAccountInfoAddById(Long accountInfo, Long amount);

    AccountInfo getAccountInfoSubtractById(Long accountInfo, Long amount);
}

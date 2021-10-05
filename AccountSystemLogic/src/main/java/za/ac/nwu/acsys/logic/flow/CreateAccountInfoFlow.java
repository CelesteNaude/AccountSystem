package za.ac.nwu.acsys.logic.flow;

import za.ac.nwu.acsys.domain.dto.AccountInfoDto;

public interface CreateAccountInfoFlow {
    AccountInfoDto create(AccountInfoDto accountInfoDto);
}

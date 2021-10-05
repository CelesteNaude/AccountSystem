package za.ac.nwu.acsys.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.logic.flow.ModifyAccountTransactionFlow;

import javax.transaction.Transactional;

@Transactional
@Component
public class ModifyAccountTransactionFlowImpl implements ModifyAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyAccountTransactionFlowImpl.class);

}

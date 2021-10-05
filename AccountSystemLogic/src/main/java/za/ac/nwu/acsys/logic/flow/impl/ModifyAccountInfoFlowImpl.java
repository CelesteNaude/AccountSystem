package za.ac.nwu.acsys.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.logic.flow.ModifyAccountInfoFlow;

import javax.transaction.Transactional;


@Transactional
@Component
public class ModifyAccountInfoFlowImpl implements ModifyAccountInfoFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyAccountInfoFlowImpl.class);

}

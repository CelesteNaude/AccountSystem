package za.ac.nwu.acsys.web.sb.config;

// Checked
// Standard code --> copy and paste for other projects

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.acsys.logic.config.LogicConfig;

@Import({LogicConfig.class})
//scan packages to pick up classes that are spring beans
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.acsys.web.sb.controller",
        "za.ac.nwu.acsys.web.sb.exception"
})
public class WebConfig {
}

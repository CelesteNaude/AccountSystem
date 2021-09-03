package za.ac.nwu.acsys.web.sb.config;

// Standard code --> copy and paste for other projects

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//scan packages to pick up classes that are spring beans
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.acsys.web.sb.controller",
        "za.ac.nwu.acsys.web.sb.exception"
})
public class WebConfig {
}

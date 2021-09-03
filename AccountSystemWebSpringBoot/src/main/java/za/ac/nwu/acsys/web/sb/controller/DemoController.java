package za.ac.nwu.acsys.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Class in AccountSystemDomain
import za.ac.nwu.acsys.domain.service.GeneralResponse;

@RestController
@RequestMapping("demo")
public class DemoController {

    // Get method
    @GetMapping("/ping")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<String>> ping(
            @RequestParam(value = "value that will be echoed", defaultValue = "pong")
                    String echo) {
        GeneralResponse<String> response = new GeneralResponse<>(true, echo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get method of outer mapping
    @GetMapping("")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<String>> getPing(
            @RequestParam(value = "echo", defaultValue = "pong", required = false)
                    String echo) {
        GeneralResponse<String> response = new GeneralResponse<>(true, echo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

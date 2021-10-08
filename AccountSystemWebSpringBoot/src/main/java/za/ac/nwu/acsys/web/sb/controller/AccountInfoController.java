package za.ac.nwu.acsys.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.acsys.domain.dto.AccountInfoDto;
import za.ac.nwu.acsys.domain.service.GeneralResponse;
import za.ac.nwu.acsys.logic.flow.CreateAccountInfoFlow;
import za.ac.nwu.acsys.logic.flow.FetchAccountInfoFlow;


@RestController
@RequestMapping("account-info")
public class AccountInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountInfoController.class);

    private final FetchAccountInfoFlow fetchAccountInfoFlow;
    private final CreateAccountInfoFlow createAccountInfoFlow;

    @Autowired
    public AccountInfoController(FetchAccountInfoFlow fetchAccountInfoFlow,
                                 CreateAccountInfoFlow createAccountInfoFlow) {
        this.fetchAccountInfoFlow = fetchAccountInfoFlow;
        this.createAccountInfoFlow = createAccountInfoFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountInfo.", notes = "Creates a  new AccountInfo in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountInfo was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountInfoDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction", required = true)
            @RequestBody AccountInfoDto accountInfoDto) {
        AccountInfoDto AccountInfoResponse = createAccountInfoFlow.create(accountInfoDto);
        GeneralResponse<AccountInfoDto> response = new GeneralResponse<>(true, AccountInfoResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{accountInfoId}") // define PathVariable
    @ApiOperation(value = "Fetches the specified AccountInfo.", notes = "Fetches the AccountInfo corresponding to the given accountInfoId.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountInfo found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resources not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountInfoDto>> getAccountInfo(
            @ApiParam(value = "The transactionId that uniquely identifies the AccountInfo.",
                    example = "1",
                    name = "accountInfoId",
                    required = true)
            @PathVariable("accountInfoId") final Long accountInfoId) {
        AccountInfoDto accountInfoDto = fetchAccountInfoFlow.getAccountBalance(accountInfoId);
        GeneralResponse<AccountInfoDto> response = new GeneralResponse<>(true, accountInfoDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

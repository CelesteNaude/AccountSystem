package za.ac.nwu.acsys.web.sb.controller;

// checked

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.domain.service.GeneralResponse;
import za.ac.nwu.acsys.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.acsys.logic.flow.FetchAccountTransactionFlow;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(CreateAccountTransactionFlow createAccountTransactionFlow,
                                        FetchAccountTransactionFlow fetchAccountTransactionFlow) {
        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
    }

    @GetMapping("/{transactionId}") // define PathVariable
    @ApiOperation(value = "Fetches the specified AccountTransaction.", notes = "Fetches the AccountTransaction corresponding to the given transactionId.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountTransaction found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resources not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
            @ApiParam(value = "The transactionId that uniquely identifies the AccountType.",
                    example = "1",
                    name = "transactionId",
                    required = true)
            @PathVariable("transactionId") final Long transactionId) {
        AccountTransactionDto accountTransactionDto = fetchAccountTransactionFlow.getAccountTransax(transactionId);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("{memberId}") // define PathVariable
//    @ApiOperation(value = "Fetches the specified AccountTransaction.", notes = "Fetches the AccountTransaction corresponding to the given transactionId.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "AccountTransaction found"),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Resources not found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
//            @ApiParam(value = "The memberId that uniquely identifies the Member.",
//                    example = "2",
//                    name = "memberId",
//                    required = true)
//            @PathVariable("memberId") final Long memberId,
//            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
//                    example = "MILES",
//                    name = "accountType",
//                    required = true)
//            @RequestParam("accountType") final String accountType) {
//        AccountTransactionDto accountTransactionDto = fetchAccountTransactionFlow.getAccountBalance(accountType, memberId);
//        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionDto);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }


    @PostMapping("Add")
    @ApiOperation(value = "Creates a AccountTransaction that adds an amount.", notes = "Creates a AccountTransaction that adds an amount in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction", required = true)
            @RequestBody AccountTransactionDto AccountTransaction) {
        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @PostMapping("Subtract")
//    @ApiOperation(value = "Creates a new AccountTransaction.", notes = "Creates a new AccountTransaction in the DB.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "The AccountTransaction was created successfully", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<AccountTransactionDto>> subtract(
//            @ApiParam(value = "Request body to create a new AccountTransaction", required = true)
//            @RequestBody AccountTransactionDto AccountTransaction) {
//        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.subtract(AccountTransaction);
//        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

//    @GetMapping("{transactionId}") // define PathVariable
//    @ApiOperation(value = "Fetches the specified AccountTransaction.", notes = "Fetches the AccountTransaction corresponding to the given transactionId.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "AccountTransaction found"),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Resources not found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
//            @ApiParam(value = "The transactionId that uniquely identifies the AccountTransaction.",
//                    example = "1",
//                    name = "transactionId",
//                    required = true)
//            @PathVariable("transactionId") final Long transactionId) {
//        AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionById(transactionId);
//        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

}

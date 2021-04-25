package com.nick.software.medicines.account.service;

import com.nick.software.medicines.account.dto.LoginDTO;
import com.nick.software.medicines.account.dto.RegistrationDTO;
import com.nick.software.medicines.account.dto.RegistrationResponse;
import com.nick.software.medicines.account.dto.Response;
import com.nick.software.medicines.account.model.Account;
import com.nick.software.medicines.account.model.AccountType;
import com.nick.software.medicines.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public RegistrationResponse registerUser(RegistrationDTO registrationDTO){
        RegistrationResponse registrationResponse = new RegistrationResponse();

        Account account = new Account();
        AccountType accountType = AccountType.USER;
        Set<AccountType> accountTypes = new HashSet<>();
        accountTypes.add(accountType);

        try {
            account.setUsername(registrationDTO.getUsername());
            account.setEmail(registrationDTO.getEmail());
            account.setPassword(registrationDTO.getPassword());
            account.setAccountTypes(accountTypes);

            accountRepository.save(account);
            log.info("-------------------------------------- account created --------------------------------------");
        }catch (Exception e){
            registrationResponse.setStatus(false);
            registrationResponse.setMessage(e.getMessage());
            registrationResponse.setException(e);
            return registrationResponse;
        }

        registrationResponse.setStatus(true);
        registrationResponse.setMessage("Registration complete");
        return registrationResponse;
    }

    public Response login(LoginDTO loginDTO){
        Response response = new Response();
        Account account = accountRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (account == null){
            response.setMessages(Collections.singletonList("Incorrect username or password"));
            return response;
        }else {
            response.setMessages(Collections.singletonList(account.getUsername()));
        }
        return response;
    }

    public Response deleteAccount(String username){
        Response response = new Response();
        Account account = accountRepository.findByUsername(username);
        account.setAccountTypes(Collections.singleton(AccountType.DELETED));
        accountRepository.save(account);
        log.info("====================== account deleted ========================");
        response.setMessages(Collections.singletonList(account.getUsername()));
        return response;
    }
}

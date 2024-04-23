package com.hexagonal.application.usecases;

import com.hexagonal.domain.command.ModifyAccount;
import com.hexagonal.domain.command.RegisterAccount;
import com.hexagonal.domain.model.Account;

public interface AccountUseCase {

    Account registerAccount(RegisterAccount registerAccount);

    Account modifyAccount(ModifyAccount modifyAccount);

}

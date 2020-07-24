package com.booster.demos.sbbankaccount.infra;

import java.util.UUID;

public class GraphQLInputs {
    public static class CreateBankAccount {
        public UUID owner;
    }

    public static class Deposit {
        public UUID iban;
        public int amount;
    }

    public static class Withdraw {
        public UUID iban;
        public int amount;
    }
}

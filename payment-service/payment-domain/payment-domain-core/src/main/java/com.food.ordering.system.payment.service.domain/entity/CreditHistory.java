package com.food.ordering.system.payment.service.domain.entity;

import com.food.ordering.system.application.domain.entity.BaseEntity;
import com.food.ordering.system.application.domain.valueobject.CustomerId;
import com.food.ordering.system.application.domain.valueobject.Money;
import com.food.ordering.system.payment.service.domain.valueobject.CreditHistoryId;
import com.food.ordering.system.payment.service.domain.valueobject.TransactionType;

public class CreditHistory extends BaseEntity<CreditHistoryId> {
    private final CustomerId customerId;
    private final Money totalCreditAmount;
    private final TransactionType transactionType;

    private CreditHistory(Builder builder) {
        this.setId(builder.creditHistoryId);
        customerId = builder.customerId;
        totalCreditAmount = builder.totalCreditAmount;
        transactionType = builder.transactionType;
    }


    public CustomerId getCustomerId() {
        return customerId;
    }

    public Money getTotalCreditAmount() {
        return totalCreditAmount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public static final class Builder {
        private CreditHistoryId creditHistoryId;
        private final CustomerId customerId;
        private final Money totalCreditAmount;
        private final TransactionType transactionType;

        public Builder(CustomerId customerId, Money totalCreditAmount, TransactionType transactionType) {
            this.customerId = customerId;
            this.totalCreditAmount = totalCreditAmount;
            this.transactionType = transactionType;
        }

        public Builder id(CreditHistoryId val) {
            creditHistoryId = val;
            return this;
        }

        public CreditHistory build() {
            return new CreditHistory(this);
        }
    }
}

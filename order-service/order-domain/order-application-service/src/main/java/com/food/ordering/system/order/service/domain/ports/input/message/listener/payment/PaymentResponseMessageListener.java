package com.food.ordering.system.order.service.domain.ports.input.message.listener.payment;

import com.food.ordering.system.order.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {
    void paymentCompleted(PaymentResponse paymentResponse);

    /**
     * Called in case a payment is failed, maybe a biz logic invariant
     * or, can be a response to a paymentCancel Request, in the saga rollback operation.
     *
     * @param paymentResponse
     */
    void paymentCancelled(PaymentResponse paymentResponse);
}

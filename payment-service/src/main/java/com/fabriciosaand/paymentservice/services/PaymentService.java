package com.fabriciosaand.paymentservice.services;

import com.fabriciosaand.paymentservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}

package com.fabriciosaand.jsonconsumer.listener;

import com.fabriciosaand.jsonconsumer.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Slf4j
@RequiredArgsConstructor
@Component
public class JsonListner {


    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Recebi o pagamento {}", payment.toString());
        sleep(2000);
        log.info("Validando fraude");
        sleep(2000);

        log.info("Compra aprovada ...");
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){
        sleep(5000);
        log.info("Gerando PDF do pagamento de id {}", payment.getId());

    }
}

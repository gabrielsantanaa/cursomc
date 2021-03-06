package com.brabos.bahia.cursoSpring.services;

import com.brabos.bahia.cursoSpring.domain.Client;
import com.brabos.bahia.cursoSpring.domain.ClientOrder;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmation(ClientOrder order);

    void sendEmail(SimpleMailMessage message);

    void sendNewPasswordEmail(Client client, String newPassword);
}

package com.solyha.bgitubot.services;

import com.solyha.bgitubot.driver.Driver;
import com.solyha.bgitubot.messagesender.MessageSender;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

@Service
public class SendMessageService {
    private final MessageSender messageSender;

    public SendMessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void gitHub(Message message){
        var sm = SendMessage.builder()
                .text("This project <b><a href=\"https://github.com/SoAruy\">GitHub</a></b>")
                .parseMode("HTML")
                .chatId(message.getChatId().toString())
                .build();
        messageSender.sendMessage(sm);
    }

    public void help(Message message){

    }

    public void compliment(Message message){
        Driver driver = new Driver();
        var markup = new ReplyKeyboardMarkup();
        var keyboardRows = new ArrayList<KeyboardRow>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("Комплімент");
        keyboardRows.add(row1);
        markup.setKeyboard(keyboardRows);
        markup.setResizeKeyboard(true);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(driver.getCompliment());
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyMarkup(markup);
        messageSender.sendMessage(sendMessage);
    }
}

package com.solyha.bgitubot.messagesender;

import com.solyha.bgitubot.BGITUBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSenderImpl implements MessageSender {
    private BGITUBot bgituBot;

    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            bgituBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setBgituBot(BGITUBot bgituBot) {
        this.bgituBot = bgituBot;
    }
}

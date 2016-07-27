package com.orunmila.provider.telegram;

import com.orunmila.config.BotConfig;
import com.orunmila.services.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

/**
 * @author Pelumi<pelumi@maven.ai>
 *         Created on 28/04/16 at 06:42.
 */
public class OrunmilaTelegramHandler extends TelegramLongPollingBot {
    private static final Logger logger = LoggerFactory.getLogger(OrunmilaTelegramHandler.class);
    private final MessageService messageService;


    public OrunmilaTelegramHandler(MessageService messageService) {
        this.messageService = messageService;
        logger.info("Initializing Orunmila Telegram handler...");
    }

    public void onUpdateReceived(Update update) {

        logger.info("Update received, type is [{}]", update.getUpdateId());
        logger.info("The update received is: [{}]", update.getMessage());
        logger.info("Update.hasMessage returns: [{}]", update.hasMessage());
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                logger.info("Text message received from user: [{}] with content [{}]", message.getFrom().getFirstName(), message.getText());
                SendMessage sendMessageRequest = getResponseSendMessage(message);
                try {
                    sendMessage(sendMessageRequest);
                } catch (TelegramApiException e) {
                    logger.error("There was an exception sending a message through telegram's API.");
                }
            }
        }
    }

    private SendMessage getResponseSendMessage(Message message) {
        String userId = message.getChatId().toString();
        String messageText = message.getText();
        String responseText = messageService.sendMessage(userId, messageText);
        SendMessage sendMessageRequest = new SendMessage();
        sendMessageRequest.setChatId(userId);
        sendMessageRequest.setText(responseText);
        return sendMessageRequest;
    }

    public String getBotUsername() {
        return BotConfig.ORUNMILA_NAME;
    }

    public String getBotToken() {
        return BotConfig.TELEGRAM_ORUNMILA_TOKEN;
    }

}

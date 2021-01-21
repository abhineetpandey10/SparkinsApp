package com.sparkee.sparkinsapp.interfaces;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;

public interface BotReply {

    void callback(DetectIntentResponse returnResponse);
}

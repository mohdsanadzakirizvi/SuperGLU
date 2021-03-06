package edu.usc.ict.superglu.util;

import edu.usc.ict.superglu.core.BaseMessage;
import edu.usc.ict.superglu.core.Message;
import edu.usc.ict.superglu.core.SpeechActEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

public class MessageTest {

    @Test
    public void testToJSON() {

        MockSerializables.MockSerializable m = new MockSerializables.MockSerializable(32, "penguins");

        BaseMessage message = new Message("testActor", "TestVerb", "TestObj", m, SpeechActEnum.INFORM_ACT, new Date(), new HashMap<String, Object>(), "testID");

        message.setContextValue(Message.SESSION_ID_CONTEXT_KEY, "mockSessionID");

        String json = SerializationConvenience.serializeObject(message, SerializationFormatEnum.JSON_FORMAT);

        System.out.println(json);
    }


    @Test
    public void testFromJSON() {
        MockSerializables.MockSerializable m = new MockSerializables.MockSerializable(32, "penguins");

        BaseMessage message = new Message("testActor", "TestVerb", "TestObj", m, SpeechActEnum.INFORM_ACT, new Date(), new HashMap<String, Object>(), "testID");

        message.setContextValue(Message.SESSION_ID_CONTEXT_KEY, "mockSessionID");

        String json = SerializationConvenience.serializeObject(message, SerializationFormatEnum.JSON_FORMAT);

        BaseMessage copy = (BaseMessage) SerializationConvenience.nativeizeObject(json, SerializationFormatEnum.JSON_FORMAT);

        Assert.assertEquals(message, copy);
    }

}

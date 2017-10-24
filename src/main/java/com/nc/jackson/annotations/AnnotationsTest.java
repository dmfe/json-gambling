package com.nc.jackson.annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Date;

public class AnnotationsTest {
    public static final Logger log = Logger.getLogger(AnnotationsTest.class);

    public void run() throws JsonProcessingException, IOException {
        extendableBeanTesting();
        myBeanTest();
        rawBeanTest();
        jsonValueTest();
        userWithRootTest();
        customSerializerTest();
        deserializingUsingCreatorTest();
        deserializingUsingJsonInjectTest();
    }

    private void extendableBeanTesting() throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean("My bean");
        bean.add("key1", "value1");
        bean.add("key2", "value2");

        String result = new ObjectMapper().writeValueAsString(bean);
        log.info(result);
    }

    private void myBeanTest() throws JsonProcessingException {
        MyBean bean = new MyBean(1, "My Bean");
        String result = new ObjectMapper().writeValueAsString(bean);
        log.info(result);
    }

    private void rawBeanTest() throws JsonProcessingException {
        RawBean bean = new RawBean("Raw Bean 1", "{\"attr\":false}");
        String result = new ObjectMapper().writeValueAsString(bean);
        log.info(result);
    }

    private void jsonValueTest() throws JsonProcessingException {
        String enumAsSring = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);
        log.info(enumAsSring);
    }

    private void userWithRootTest() throws JsonProcessingException {
        UserWithRoot user = new UserWithRoot(1, "Dmitry");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(user);

        log.info(result);
    }

    private void customSerializerTest() throws JsonProcessingException {
        Event event = new Event("event1", new Date());
        String result = new ObjectMapper().writeValueAsString(event);
        log.info(result);
    }

    private void deserializingUsingCreatorTest() throws IOException {
        String json = "{\"id\":1, \"theName\":\"My bean\"}";

        BeanWithCreator bean = new ObjectMapper().readerFor(BeanWithCreator.class).readValue(json);
        log.info("id: " + bean.id + ", name: " + bean.name);
    }

    private void deserializingUsingJsonInjectTest() throws IOException {
        String json = "{\"name\":\"My bean\"}";

        InjectableValues inject = new InjectableValues.Std().addValue(int.class, 10);
        BeanWithInject bean = new ObjectMapper().reader(inject).forType(BeanWithInject.class).readValue(json);
        log.info("id: " + bean.id + ", name: " + bean.name);
    }
}
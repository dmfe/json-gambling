package com.nc.jackson.annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
        deserializingUsingJsonAnySetter();
        deserializingUsingJsonSetter();
        deserializingUsingJsonDeserialize();
        serializingUsingJsonIgnoreProperties();
        serializingUsingJsonIgnoreType();
        serializingUsingJsonInclude();
        serializingUsingJsonAutoDetect();
        serializingPolimorphic();
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

    private void deserializingUsingJsonAnySetter() throws IOException {
        String json = "{\"name\":\"My bean 2\"," +
                      " \"key1\":\"value1\"," +
                      " \"key2\":\"value2\"}";

        ExtendableBean bean = new ObjectMapper().reader().forType(ExtendableBean.class).readValue(json);
        log.info("name: " + bean.name + ", properties: " + bean.getProperties());
    }

    private void deserializingUsingJsonSetter() throws IOException {
        String json = "{\"id\":\"101\", \"name\":\"My bean 101\"}";
        MyBean bean = new ObjectMapper().readerFor(MyBean.class).readValue(json);
        log.info("id: " + bean.id + ", name: " + bean.getTheName());
    }

    private void deserializingUsingJsonDeserialize() throws IOException {
        String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2070 20:45:00\"}";

        MappingIterator<Event> mi = new ObjectMapper().readerFor(Event.class).readValues(json);
        Event event = mi.hasNextValue() ? mi.nextValue() : null;
        log.info("event name: " + event.name + ", event date: " + event.eventDate);
    }

    private void serializingUsingJsonIgnoreProperties() throws JsonProcessingException {
        BeanWithIgnore bean = new BeanWithIgnore(202, "My ignore bean", false);
        String result = new ObjectMapper().writeValueAsString(bean);
        log.info(result);
    }

    private void serializingUsingJsonIgnoreType() throws JsonProcessingException {
        User.Name name = new User.Name("Foo", "Bar");
        User user = new User(99, name);

        String result = new ObjectMapper().writeValueAsString(user);
        log.info(result);
    }

    private void serializingUsingJsonInclude() throws JsonProcessingException {
        MyBean bean = new MyBean(444, null);
        String result = new ObjectMapper().writeValueAsString(bean);
        log.info(result);
    }

    private void serializingUsingJsonAutoDetect() throws JsonProcessingException {
        PrivateBean bean = new PrivateBean(333, "My private bean 333");
        String result = new ObjectMapper().writeValueAsString(bean);
        log.info(result);
    }

    private void serializingPolimorphic() throws JsonProcessingException {
        Zoo.Dog dog = new Zoo.Dog("lacy");
        Zoo.Cat cat = new Zoo.Cat("zoe");
        Zoo zoo = new Zoo();
        zoo.addAnimal(dog);
        zoo.addAnimal(cat);

        String result = new ObjectMapper().writeValueAsString(zoo);
        log.info(result);
    }
}
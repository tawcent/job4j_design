package ru.job4j.serialization;

import jakarta.xml.bind.*;

import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person(true, 11, "Boris", new String[]{"purrs", "eatin"});

        JAXBContext context = JAXBContext.newInstance(Person.class);

        // Сериализация
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            xml = writer.toString();
            System.out.println("Serialized XML:\n" + xml);
        }

        // Десериализация
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Person restored = (Person) unmarshaller.unmarshal(reader);
            System.out.println("Deserialized object:\n" + restored);
        }
    }
}

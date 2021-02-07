package freeIt.hw21xml.validatorXml;

import freeIt.hw21xml.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXML {
   static Logger logger = LoggerFactory.getLogger(ValidatorXML.class.getName());
    public static void validator(){
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "src/main/java/freeIt/hw21xml/resources/flowers.xml";
        String schemaName = "src/main/java/freeIt/hw21xml/resources/flowers.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            // создание схемы
            Schema schema = factory.newSchema(schemaLocation);
            // создание валидатора на основе схемы
            Validator validator = schema.newValidator();
            // проверка документа
            Source source = new StreamSource(fileName);
            validator.validate(source);
            logger.info(fileName + " is valid.");
        } catch (SAXException e) {
            logger.error("validation "+ fileName + " is not valid because "
                    + e.getMessage());
        } catch (IOException e) {
            logger.error(fileName + " is not valid because "
                    + e.getMessage());
        }
    }
}

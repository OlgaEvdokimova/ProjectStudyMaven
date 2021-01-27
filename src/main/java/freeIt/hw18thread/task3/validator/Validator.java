package freeIt.hw18thread.task3.validator;
import freeIt.hw18thread.task3.client.Client;
import freeIt.hw18thread.task3.exceptions.EmptyFileException;
import freeIt.hw18thread.task3.exceptions.NotNumberException;
import freeIt.hw18thread.task3.exceptions.WrongEmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Validator {

    public static Logger logger = LoggerFactory.getLogger(Validator.class.getName());

    public static void clientListSizeNotEmpty(List<Client> clientList) {
        if (clientList.size() == 0) {
            logger.error("File is empty");
            throw new EmptyFileException("File is empty");
        }
    }

    public static void validEmail(String email) {
        if (!email.matches("[\\w+\\-\\.]+@\\w+\\.\\w{2,4}")) {
            throw new WrongEmailException("wrong email: login consists from [A-Za-z][0-9] . - _");
        }
    }



    public static void parseInt(String id) {
        while (true) {
            try {
                int n = Integer.parseInt(id);
                break;
            } catch (NumberFormatException e) {
                logger.error("Not a number, input a number");
                logger.error(e.getMessage());
                throw new NotNumberException(" Not a number, input a number");
            }
        }
    }

}


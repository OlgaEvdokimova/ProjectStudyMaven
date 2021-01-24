package freeIt.hw18thread.task3.validator;

import freeIt.hw18thread.task3.client.Client;
import freeIt.hw18thread.task3.exceptions.EmptyFileException;
import freeIt.hw18thread.task3.exceptions.NotNumberException;
import freeIt.hw18thread.task3.exceptions.WrongEmailException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean clientListSizeNotEmpty(List<Client> clientList){
        if (clientList.size() == 0) {
            throw new EmptyFileException("File is empty");
        }else {
            return true;
        }
    }

    public static boolean validEmail(String email){
        Pattern pattern = Pattern.compile("[\\w+\\-\\.]+@\\w+\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.find()) {
            throw new WrongEmailException("wrong email: login consists from [A-Za-z][0-9] . - _");
        }
        return true;
    }

    public static boolean parseInt(String id){
        try {
            int n = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new NotNumberException(" Not a number, input a number");
        }
        return true;
    }

}

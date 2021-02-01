package freeIt.hw18thread.task3;
import freeIt.hw18thread.task3.client.Client;
import freeIt.hw18thread.task3.client.ClientCreator;
import freeIt.hw18thread.task3.clientRepository.ClientRepository;
import freeIt.hw18thread.task3.purchase.Purchase;
import freeIt.hw18thread.task3.clientRepository.ClientRepositoryImp;
import freeIt.hw18thread.task3.validator.Validator;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    /**
     * В текстовом файле лежат данные о покупателях и их покупках (в любом удобном формате).
     * Создать классы Клиент (покупатель) и Покупка. Создать класс ClientRepository, в котором
     * разместить методы для работы с файлом: добавить нового покупателя со списком покупок, по
     * id покупателя найти список его покупок, по email найти покупателя (учитывать то, что
     * покупателя с нужным id или email может не быть, использовать Optional для возвращаемых
     * значений методов). Написать класс main с использованием методов класса ClientRepository.
     */


    public static void main(String[] args) {

        PropertyConfigurator.configure("src/main/java/freeIt/log4j.properties");
        Logger logger = LoggerFactory.getLogger(Main.class.getName());
        ClientRepository clientRepositoryImp = new ClientRepositoryImp();
        Optional<List<Client>> clientListOpt = Optional.ofNullable(ClientRepositoryImp.getClients());
        List<Client> clientList = clientListOpt.get();

        Validator.clientListSizeNotEmpty(clientList);
// достаю клиентов из списка
            for (Client c : clientList) {
                logger.info(c.toString());
            }


        //добавить нового покупателя со списком покупок
        clientRepositoryImp.addClient(ClientCreator.createClient("Pol", "popol_123@mail.ru", new ArrayList<>(List.of("apple watch", "socks"))));

        //по id покупателя найти список его покупок
        List<Purchase> purchaseList = clientRepositoryImp.getPurchaseListById("4");
        if (purchaseList.size() == 0) {
            logger.info("No purchases");
        }
        purchaseList.forEach(p -> logger.info(p.toString()));

        //по email найти покупателя
        Optional<Client> clientByEmail1 = clientRepositoryImp.getByEmail("olga.ev@mail.ru");
        Optional<Client> clientByEmail2 = clientRepositoryImp.getByEmail("olgaev@mail.ru");
        if (clientByEmail2.isPresent()) {
            logger.info(clientByEmail2.get().toString());
        } else {
            logger.info("No such client");
        }

    }

}


//logger.info("1 - добавить нового покупателя со списком покупок ");
//        logger.info("2 - по id покупателя найти список его покупок");
//        logger.info("3 - по email найти покупателя");
//        switch (ScannerUtil.scannerString()) {
//            case "1":
//                clientRepositoryImp.addClient(ClientCreator.createClient());
//                break;
//            case "2":
//                logger.info("Input ID");
//                String id = ScannerUtil.scannerString();
//                logger.info(id);
//                if (Validator.parseInt(id)) {
//                    List<Purchase> purchaseList = clientRepositoryImp.getPurchaseListById(id);
//                    purchaseList.forEach(p ->logger.info(p.toString()));
//                }
//                break;
//            case "3":
//                logger.info("Input EMAIL");
//                String email = ScannerUtil.scannerString();
//                logger.info(email);
//                if (Validator.validEmail(email)) {
//                    Optional<Client> clientByEmail = clientRepositoryImp.getByEmail(email);
//                    if (clientByEmail.isPresent()) {
//                        logger.info(clientByEmail.get().toString());
//                    } else {
//                        logger.info("No such client");
//                    }
//                }
//                break;
//        }
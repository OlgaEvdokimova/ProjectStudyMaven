package hw18thread.task3;

import hw18thread.task3.exceptions.ClientHaveNotPurchaseException;
import hw18thread.task3.exceptions.NotNumberException;
import hw18thread.task3.exceptions.WrongEmailException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientRepository {

    private static final int NAME = 1;
    private static final int ID = 0;
    private static final int EMAIL = 2;

    public static List<Client> getClients(String PATH) {
        List<Client> clients = new ArrayList<>();
        String line;
        try (BufferedReader bf = new BufferedReader(new FileReader(PATH))) {
            while ((line = bf.readLine()) != null) {
                List<Purchase> purchaseList = new ArrayList<>();
                String[] splitLine = line.split("[^\\w@\\.-]+");
                Client client = new Client();
                client.setId(splitLine[ID]);
                client.setName(splitLine[NAME]);
                client.setEmail(splitLine[EMAIL]);
                if (splitLine.length > 3) {
                    for (int j = 3; j < splitLine.length; j++) {
                        purchaseList.add(new Purchase(splitLine[j]));
                    }
                } else
                    throw new ClientHaveNotPurchaseException("Client " + client.getName() + " does not have any purchase");
                client.setPurchaseList(purchaseList);
                clients.add(client);

            }
        } catch (IOException e) {
            e.getMessage();
        }
        return clients;
    }


    public static void addClient(String PATH) {
        List<Client> listOfClients = getClients(PATH);
        Client client = new Client();
        client.setId((String.valueOf(listOfClients.size() + 1)));
        Scanner sc = new Scanner(System.in);
        System.out.println("New client name");
        client.setName(sc.nextLine());
        System.out.println("Email");
        String email = sc.nextLine();
        if (!(email.equals("[\\w+\\-\\.]+@\\w+\\.\\w{2,4}"))){
            throw new WrongEmailException("wrong email: login consists from [A-Za-z][0-9] . - _");
        }
        client.setEmail(email);
        List<Purchase> purchaseList = new ArrayList<>();
        while (true) {
            System.out.println("Do u wanna add purchase (add + or -)");
            if (sc.nextLine().equalsIgnoreCase("+")) {
                System.out.println("Write purchase");
                purchaseList.add(new Purchase(sc.nextLine()));
            } else break;
        }
        client.setPurchaseList(purchaseList);
        try (FileWriter fw = new FileWriter("D:\\Java\\IdeaProjects\\ProjectStudyMaven\\src\\main\\java\\hw18thread\\task3\\list.txt")) {
            for (Client s : listOfClients) {
                fw.write(s.toString());
                fw.write("\n");
            }
            fw.write(client.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Optional<List<Purchase>> getPurchaseListById(String id, String PATH)  {
        List<Client> clientList = getClients(PATH);
        Client client = clientList.stream().filter(s -> s.getId().equals(id)).findFirst().get();
        return Optional.ofNullable(client.getPurchaseList());
    }

    public static Optional<Client> getByEmail(String regex, String PATH) {
        List<Client> clientList = getClients(PATH);
        Pattern pattern = Pattern.compile(regex);
        for (Client cl : clientList) {
            Matcher matcher = pattern.matcher(cl.getEmail());
            if (matcher.find()) {
                return Optional.ofNullable(cl);
            }
        }
        return null;
    }
}

// email regex [\w+\-\.]+@\w+\.\w{2,4}
// [\w+@?\-\.]+ any pattern in line


//public static List<Client> getClients(String PATH)  {
//
//        List<Client> clients = new ArrayList<>();
//        String line;
//        try (BufferedReader bf = new BufferedReader(new FileReader(PATH))) {
//            while ((line = bf.readLine()) != null) {
//                List<Purchase> purchaseList = new ArrayList<>();
//                String[] splitLine = line.split("\\W+");
//                Client client = new Client();
//                client.setId(ID);
//                client.setName(splitLine[NAME]);
//                if (splitLine.length > 2) {
//                    for (int i = 1; i < splitLine.length; i++) {
//                        purchaseList.add(new Purchase(splitLine[i]));
//                    }
//                } else throw new ClientHaveNotPurchaseException("Client " + client.getName() + " does not have any purchase");
//                client.setPurchaseList(purchaseList);
//                clients.add(client);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return clients;
//    }

//    public static List<String> readFile(String PATH) {
//        String line;
//        List<String> list = new ArrayList<>();
//        try (BufferedReader bf = new BufferedReader(new FileReader(PATH))) {
//            while ((line = bf.readLine()) != null) {
//                list.add(line);
//            }
//        } catch (IOException e) {
//            e.getMessage();
//        }
//        return list;
//    }
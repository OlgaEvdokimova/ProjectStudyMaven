package hw18thread.task3;

import hw18thread.task3.exceptions.ClientHaveNotPurchaseException;
import hw18thread.task3.exceptions.NotNumberException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientRepository {

    private static final int NAME = 1;

    public static List<Client> getClients(String PATH) {
        List<Client> clients = new ArrayList<>();
        int i = 1;
        String line;
        try (BufferedReader bf = new BufferedReader(new FileReader(PATH))) {
            while ((line = bf.readLine()) != null) {
                List<Purchase> purchaseList = new ArrayList<>();
                String[] splitLine = line.split("\\W+");
                Client client = new Client();
                client.setId(i++);
                client.setName(splitLine[NAME]);
                if (splitLine.length > 2) {
                    for (int j = 2; j < splitLine.length; j++) {
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


    public static void addClient(List<Client> listOfClients) {
        Client client = new Client();
        client.setId((listOfClients.size() + 1));
        Scanner sc = new Scanner(System.in);
        System.out.println("New client");
        client.setName(sc.nextLine());
        List<Purchase> purchaseList = new ArrayList<>();
        while (true) {
            System.out.println("Do u wanna add purchase");
            if (sc.nextLine().equalsIgnoreCase("yes")) {
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

    public static List<Purchase> getById(int id, List<Client> clientList) throws NotNumberException {
        Client client = clientList.stream().filter(s -> s.getId() == id).findFirst().get();
        return client.getPurchaseList();
    }
}


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
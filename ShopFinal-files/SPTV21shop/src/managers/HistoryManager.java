/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;
import enyity.Product;
import enyity.Client;
import enyity.History;
import java.util.GregorianCalendar;
import java.util.Scanner;
import enyity.Oborot;
/**
 *
 * @author NikitaSkr
 */
public class HistoryManager {
private final Scanner scanner;
public static int totalSumma;
    public HistoryManager() {
        scanner = new Scanner(System.in);
    }
 public History takeOnProduct(Product[] products, Client[] clients){
        System.out.println("Список клиентов: ");
        for (int i = 0; i < clients.length; i++) {
            System.out.println(i+1+". "+clients[i].getFirstname()+" "+clients[i].getLastname());
        }
        System.out.print("Выбери клиента: ");
        int numberClient = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список обуви: ");
        for (int i = 0; i < products.length; i++) {
            System.out.print(i+1+". "+products[i].getProdName()+". ");
            System.out.println();    
        }   
        System.out.print("Выбери номер обуви: ");
        int numberProduct = scanner.nextInt();scanner.nextLine();
        System.out.print("Выберите кол-во товара: ");
        int quantityBuyingProduct = scanner.nextInt(); scanner.nextLine();
        History history = new History();
        int clientMonay = clients[numberClient - 1].getMony();
        int productPrice = products[numberProduct - 1].getPrice();
        if(quantityBuyingProduct<=products[numberProduct - 1].getQuantity() ){
        if(quantityBuyingProduct>0){
            productPrice = quantityBuyingProduct*productPrice;
        if (clientMonay > productPrice) {
            history.setTakeOnProduct(new GregorianCalendar().getTime());
            history.setProduct(products[numberProduct - 1]);
            history.setClient(clients[numberClient-1]);
            history.getClient().setMony(  history.getClient().getMony()-history.getProduct().getPrice()*quantityBuyingProduct);
            int ark = products[numberProduct - 1].getQuantity() - quantityBuyingProduct;
            products[numberProduct - 1].setQuantity(ark);
            totalSumma = productPrice;
            return history;
        }else {
            System.out.println("денег не хватает");
            return null;
        }}else{System.out.println("товар закончился");
            return null;
            }}else{System.out.println("такого кол-ва товара нет");
            return null;
}    
 }}

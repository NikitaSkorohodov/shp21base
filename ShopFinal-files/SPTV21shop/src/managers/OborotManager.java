package managers;

import enyity.Oborot;
import enyity.Product;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */

    
  public class OborotManager {
    public Oborot oborotCashEveryTime(int summaProduct){
        Oborot oborot = new Oborot();
        oborot.setSumma(summaProduct);
        return oborot;
    }

    public Oborot createOborotList() {
        int summaProduct = HistoryManager.totalSumma;
        return oborotCashEveryTime(summaProduct);
    }

    public void printListOborots(Oborot[] oborots){
        int sum = 0;
        for (Oborot oborot : oborots) {
            sum = sum + oborot.getSumma();
        }
        System.out.print("Общая прибыль магазина: " + sum);

        System.out.println();
  } 
}

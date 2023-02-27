package periphery;
import java.util.ArrayList;
import java.util.Scanner;
import periphery.ComputerMouse;
import periphery.MonitorScreen;

public class Stockroom {
  /*private Periphery[] Product;  //одномерный массив использовать коллекцию java ArrayList*/
  
  public static ArrayList<Periphery> Product = new ArrayList<Periphery>(20);
  
  public static char AddProduct () {
    char out='0';  
    String vvod="";
    Scanner scan = new Scanner (System.in);
    
    while (vvod!="10") {
        menu.Menu.MenuCreator("Выбор товара","Компьютерная мышь","Монитор",
                              "Устройства выхода","Вернуться назад","-", "",4);    
        vvod = scan.nextLine();
        switch (vvod) {
            case "1" : out='1';
                       vvod="10";
                       break;
                
            case "2" : out='2';
                       vvod="10";
                       break;
                
            case "3" : out='3';
                       vvod="10";
                       break;
                
            case "4" : vvod="10";
                       break;
                
            default : System.out.println("\nПроизошла ошибка ввода, пожалуйста введите предложенные варианты {1,2,3,4}");
        } 
    }
    return (out);
  }
  
  public static void WritingOut () {
    int i;
    Object type;
    if (Product.size()==0) System.out.println("\nНа складе нет товара.");
     else {
       System.out.println("\nСодержимое склада:");
       for (i=0; i<Product.size(); i++) {
         type=Product.get(i);
         System.out.print((i+1)+") ");
         System.out.println(type.toString());

       }
     }
  }
  
  public static void WritingOutExpiredProduct() {
    int i,k;
    Object type;
    k=0;
    if (Product.size()==0) System.out.println("\nНа складе нет товара с возможным истекающим сроком годности.");
     else {
       System.out.println("\nТовар с возможно истекающим сроком годности, находящийся на складе:");
       for (i=0; i<Product.size(); i++) {
         type=Product.get(i);
         if (type instanceof ExpiredProduct) {
           k++;  
           System.out.print((k)+") ");
           System.out.println(type.toString());
         }
       }
     }
    if (k==0) System.out.println("\nНа складе нет товара с возможным истекающим сроком годности.");
  }
  
  
}
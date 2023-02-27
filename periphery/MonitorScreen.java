package periphery;

import java.util.Scanner;

public class MonitorScreen extends Periphery implements ExpiredProduct{
  
  private String DisplayType;
    
  public MonitorScreen (String DispType) {
    this.DisplayType=DispType; 
  }

  @Override
  public void connected() {
      Scanner scan = new Scanner (System.in);
      String vvod="";
      String vvod1="";
      int bright=100;
     
      System.out.println("\nТип матрицы монитора: "+DisplayType);
      System.out.println("Яркость экрана: "+bright);
      System.out.println("\nУстройство подключено...");
      System.out.println("Изображение выводится на экране...");
      
      while (vvod!="10") {
        System.out.println("\nВы хотите изменить яркость экрана ?");
        menu.Menu.MenuCreator("", "Да", "Нет", "", "", "", "", 2);
        vvod=scan.nextLine();
        switch (vvod) {
            case "1" : while (vvod1!="10") {
                         System.out.println("\nТекущая яркость: "+bright);
                         menu.Menu.MenuCreator("Изменение яркости", "Увеличить на 10", "Уменьшить на 10", "Выйти", "", "", "", 3);
                         vvod1=scan.nextLine();
                         switch (vvod1) {
                           case "1" : if (bright<100) bright+=10; else System.out.println("Достигнута максимальная яркость.");
                                      break;
                               
                           case "2" : if (bright>0) bright-=10; else System.out.println("Достигнута минимальная яркость.");
                                      break;
                               
                           case "3" : vvod1="10";
                                      vvod="10";
                                      break;
                           default : System.out.println("\nПроизошла ошибка ввода, пожалуйста введите предложенные варианты {1,2,3}"); 
                         }
                       }       
                       break;
            
            case "2" : vvod="10";
                       break;
                       
            default : System.out.println("\nПроизошла ошибка ввода, пожалуйста введите предложенные варианты {1,2}"); 
        }
      }
      System.out.println("Товар исправен и полностью пригоден к использованию!");
      

  }
  
  @Override
  public String toString() {
      String s;
      s = "Монитор"
        + "\n     Тип матрицы: "+DisplayType;
      return s;
  }
  
    
}

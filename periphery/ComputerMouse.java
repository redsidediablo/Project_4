package periphery;

import java.util.Scanner;

public class ComputerMouse extends Periphery implements ExpiredProduct{
  
  private String SensorType;
    
  public ComputerMouse (String SenType) {
    this.SensorType=SenType; 
  }
    
  @Override
  public void connected () {
      Scanner scan = new Scanner (System.in);
      String vvod="";
      String vvod1="";
      int MouseSens=1;
     
      System.out.println("\nТип сенсора мыши: "+SensorType);
      System.out.println("Чувствительность мыши: "+MouseSens);
      System.out.println("\nУстройство подключено...");
      System.out.println("Координаты перемещения передаются...");
      
      while (vvod!="10") {
        System.out.println("\nВы хотите изменить чувствительность ?");
        menu.Menu.MenuCreator("", "Да", "Нет", "", "", "", "", 2);
        vvod=scan.nextLine();
        switch (vvod) {
            case "1" : while (vvod1!="10") {
                         System.out.println("\nТекущая чувствительность: "+MouseSens);
                         menu.Menu.MenuCreator("Изменение чувствительности", "Увеличить на 1", "Уменьшить на 1", "Выйти", "", "", "", 3);
                         vvod1=scan.nextLine();
                         switch (vvod1) {
                           case "1" : if (MouseSens<6) MouseSens+=1; else System.out.println("Достигнута максимальная чувствительность мыши.");
                                      break;
                               
                           case "2" : if (MouseSens>1) MouseSens-=1; else System.out.println("Достигнута минимальная чувствительность мыши.");
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
      s = "Компьютерная мышь"
        + "\n     Тип сенсора: "+SensorType;
      return s;
  }
    
}

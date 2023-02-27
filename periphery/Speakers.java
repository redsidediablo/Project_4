package periphery;

import java.util.Scanner;

public class Speakers extends Periphery{
 
  private int NumberOfSpeakers;
  private final int NumberOfSubwoofers=1;
    
  public Speakers (int NumOfSpeak) {
    this.NumberOfSpeakers=NumOfSpeak;
  }
    
  @Override
  public void connected () {
      Scanner scan = new Scanner (System.in);
      String vvod="";
      String vvod1="";
      int volume=100;
     
      System.out.println("\nТип аудиосистемы: "+NumberOfSpeakers+' '+NumberOfSubwoofers);
      System.out.println("Количество динамиков: "+NumberOfSpeakers);
      System.out.println("Количество сабвуферов: "+NumberOfSubwoofers);
      System.out.println("Громкость звука: "+volume+'%');
      System.out.println("\nУстройство подключено...");
      System.out.println("Координаты перемещения передаются...");
      
      while (vvod!="10") {
        System.out.println("\nВы хотите изменить громкость ?");
        menu.Menu.MenuCreator( "", "Да", "Нет", "", "", "", "", 2);
        vvod=scan.nextLine();
        switch (vvod) {
            case "1" : while (vvod1!="10") {
                         System.out.println("\nТекущая чувствительность: "+volume);
                         menu.Menu.MenuCreator("Изменение чувствительности", "Увеличить на 10", "Уменьшить на 10", "Выйти", "", "", "", 3);
                         vvod1=scan.nextLine();
                         switch (vvod1) {
                           case "1" : if (volume<100) volume+=10; else System.out.println("Достигнут максимальный уровень громкости.");
                                      break;
                               
                           case "2" : if (volume>0) volume-=10; else System.out.println("Достигнут минимальный уровень громкости.");
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
      s = "Ауидиосистема"
        + "\n     Количество колонок: "+NumberOfSpeakers
        + "\n     Количество сабвуферов: "+NumberOfSubwoofers;
      return s;
  }
    
}

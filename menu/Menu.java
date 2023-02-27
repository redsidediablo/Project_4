package menu;

import static java.lang.Integer.parseInt;
import java.util.Scanner;
import periphery.ComputerMouse;
import periphery.ExpiredProduct;
import periphery.MonitorScreen;
import periphery.Periphery;
import periphery.Speakers;
import periphery.Stockroom;

public class Menu {

  public static void main(String[] args) {
    //комп. мышь
      String SenType="";
    //монитор
      String DispType="";
    //колонки
      int NumOfSpeak=0;
    
    char choise='0';
    String vvod="";
    String vvod1="";
    Scanner scan = new Scanner (System.in);
    boolean flag=false;
    int k=-1;
    
    periphery.Stockroom.Product.add(new ComputerMouse ("Лазерный"));
    periphery.Stockroom.Product.add(new ComputerMouse ("Оптический"));
    periphery.Stockroom.Product.add(new MonitorScreen ("OLED"));
    periphery.Stockroom.Product.add(new MonitorScreen ("VA/MVA"));
    periphery.Stockroom.Product.add(new MonitorScreen ("IPS"));
    periphery.Stockroom.Product.add(new Speakers (4));
    
    while (vvod!="10") {
        Menu.MenuCreator("Управление складом","Добавить товар на склад","Просмотреть содержимое склада",
                         "Очистить склад","Испытать товар","Просмотреть товары с истекшим сроком годности","Выход",6);
        
        vvod = scan.nextLine();
        if ( (periphery.Stockroom.Product.size()==19)&&(vvod=="1") ) System.out.println("Склад переполнен, вы не можете больше добавить товар!");
         else 
          switch (vvod) {
            case "1" : choise = periphery.Stockroom.AddProduct();
                       switch (choise) {
                             case '1' : while (vvod1!="10") {
                                          Menu.MenuCreator("Тип сенсора компьютерной мыши","Лазерный","Оптический",
                                                           "-","-","-","-",2);
                                          vvod1=scan.nextLine();
                                          switch (vvod1) {
                                              case "1" : SenType="Лазерный";
                                                         vvod1="10";
                                                         break;
                                 
                                              case "2" : SenType="Оптический";
                                                         vvod1="10";
                                                         break;
                                 
                                              default : System.out.println("\nПроизошла ошибка ввода, пожалуйста введите предложенные варианты {1,2,3,4}");
                                          }
                                        }
                                        System.out.println("Товар успешно добавлен.");
                                        periphery.Stockroom.Product.add(new ComputerMouse (SenType));
                                        break;
                                 
                             case '2' : while (vvod1!="10") {
                                          Menu.MenuCreator("Тип матрицы монитора","OLED","VA (Vertical Alignment)/MVA (Multi-Domain Vertical Alignment)",
                                                           "IPS","-","-","-",3);
                                          vvod1=scan.nextLine();
                                          switch (vvod1) {
                                              case "1" : DispType="OLED";
                                                         vvod1="10";
                                                         break;
                                 
                                              case "2" : DispType="VA/MVA";
                                                         vvod1="10";
                                                         break;
                                                  
                                              case "3" : DispType="IPS";
                                                         vvod1="10";
                                                         break;
                                 
                                              default : System.out.println("\nПроизошла ошибка ввода, пожалуйста введите предложенные варианты {1,2,3,4}");
                                          }
                                        }
                                        System.out.println("Товар успешно добавлен.");
                                        periphery.Stockroom.Product.add(new MonitorScreen (DispType));
                                        break;
                                 
                             case '3' : while ( (NumOfSpeak<1)||(NumOfSpeak>9) ) {
                                          System.out.print("Ввелите количество колонок (от 1 до 9): ");
                                          try { vvod1=scan.nextLine();
                                                NumOfSpeak=parseInt(vvod1);
                                                flag=false;
                                          } catch (Exception e) {
                                              System.out.println("Введены неверные данные\n");
                                              flag=true;
                                            }
                                          if ( ((NumOfSpeak<1)||(NumOfSpeak>9))&&(flag==false) ) System.out.println("Число не входит в заданный диапазон\n");
                                        }
                                        System.out.println("Товар успешно добавлен.");
                                        periphery.Stockroom.Product.add(new Speakers (NumOfSpeak));
                                        NumOfSpeak=0;
                                        break;
                                 
                             case '0' : break;
                       }
                       vvod1="";
                       break;
                
            case "2" : periphery.Stockroom.WritingOut();
                       break;
                
            case "3" : while (Stockroom.Product.size()!=0) {
                         Stockroom.Product.remove(0); 
                       }
                       System.out.println("Склад успешно очищен");
                       break;    
                
            case "4" : if (Stockroom.Product.size()<=0) {
                          System.out.println("\nСклад пуст, нет товара для проверки. "
                                           + "Пожалуйста добавьте товар в разделе (Добавить товар на склад)");    
                    } else {
                       while (vvod1!="10") {
                         Menu.MenuCreator("Выбор вида товара","Компьютерная мышь","Монитор",
                                          "Устройства выхода","Вернуться назад","-","-",4);
                         vvod1=scan.nextLine();
                         switch (vvod1) {
                             case "1" :try {
                                        for (int i=0; i<Stockroom.Product.size(); i++) {
                                          if (Stockroom.Product.get(i) instanceof ComputerMouse) {
                                            k=i;
                                            break;
                                          }  
                                        }
                                        Stockroom.Product.get(k).connected();
                                        vvod1="10";
                                        k=-1; 
                                       } catch (Exception e) {
                                           System.out.println("Товара данного типа нет на складе, добавьте пожалуйста.");
                                         }
                                        break;
                                 
                             case "2" :try {
                                        for (int i=0; i<Stockroom.Product.size(); i++) {
                                          if (Stockroom.Product.get(i) instanceof MonitorScreen) {
                                            k=i;
                                            break;
                                          }  
                                        }
                                        Stockroom.Product.get(k).connected();
                                        vvod1="10";
                                        k=-1;
                                       } catch (Exception e) {
                                           System.out.println("Товара данного типа нет на складе, добавьте пожалуйста.");
                                         }
                                        break;
                                 
                             case "3" :try { 
                                        for (int i=0; i<Stockroom.Product.size(); i++) {
                                          if (Stockroom.Product.get(i) instanceof Speakers) {
                                            k=i;
                                            break;
                                          }  
                                        }
                                        Stockroom.Product.get(k).connected();
                                        vvod1="10";
                                        k=-1;
                                        } catch (Exception e) {
                                           System.out.println("Товара данного типа нет на складе, добавьте пожалуйста.");
                                          }
                                        break;
                                 
                             case "4" : vvod1="10";
                                        break;
                                 
                             default : System.out.println("\nПроизошла ошибка ввода, пожалуйста введите предложенные варианты {1,2,3,4}");
                         }
                       }
            }
                       vvod1="";
                       break;
                
            case "5" : Stockroom.WritingOutExpiredProduct(); //instanceof ExpiredProduct
                       break;
                       
            case "6" : vvod="10";
                       break;
                
            default : System.out.println("\nПроизошла ошибка ввода, пожалуйста введите предложенные варианты {1,2,3,4,5}");
          }
         
    }
  }
  
  public static void MenuCreator (String s,String s1,String s2,String s3,String s4,String s5, String s6,int amount) {
    if (s!="") System.out.println("\n|------"+s+"------|");
    System.out.println("1) "+s1);
    System.out.println("2) "+s2);
    if (amount >= 3) System.out.println("3) "+s3);
    if (amount >= 4) System.out.println("4) "+s4);
    if (amount >= 5) System.out.println("5) "+s5);
    if (amount >= 6) System.out.println("6) "+s6);
    System.out.print(">>");     
  } 
    
}
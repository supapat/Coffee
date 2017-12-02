import java.util.Scanner;

public class Run {
	public static void main(String[] args)throws Exception {
				int numMenu = 0;
				do{
				numMenu = listMainMenu();
					// ÍèÒ¹¤èÒàÁ¹Ù
				Menu menu = new Menu();
				menu.readFileToSetValues();
				menu.readRecipeToSetValues();
				
				switch(numMenu){
				case (1):menu.listAllCoffee();break;
				case (2):menu.AddCoffee();break;
				case (3):menu.deleteCoffee();break;
				case (4):menu.editCoffee();break;
				case (5):menu.listAllRecipe();break;
				case (6):menu.editRecipe();break;
				case (7):menu.listAllCoffee_Recipe();break;
				default :break;
				
				}
				}while(numMenu > 8 || numMenu < 1);
			}
			
			public static int listMainMenu(){  //áÊ´§ÃÒÂ¡ÒÃ
				Scanner scan = new Scanner(System.in);
				
				System.out.println("*******************************************************************\n"+
							"\tWelcome to the IT Coffee House!\n\n" +
							"\t\t1. áÊ´§ÃÒÂª×èÍ¡Òá¿·Ñé§ËÁ´ (List All Coffees)\n"+
							"\t\t2. à¾ÔèÁª¹Ô´¡Òá¿ (Add Coffee)\n"+
							"\t\t3. Åºª¹Ô´¡Òá¿ (Delete Coffee)\n"+
							"\t\t4. á¡éä¢ª¹Ô´¡Òá¿ (Edit Coffee)\n"+
							"\t\t5. áÊ´§ÃÒÂ¡ÒÃÊèÇ¹¼ÊÁ (List All Recipes)\n"+
							"\t\t6. á¡éä¢ÃÒÂ¡ÒÃÊèÇ¹¼ÊÁ (Edit Recipe)\n"+
							"\t\t7. áÊ´§ÃÒÂÅĞàÍÕÂ´·Ñé§ËÁ´ (List All Coffees and Recipes)\n"+
							"\t\t8. ¨º¡ÒÃ·Ó§Ò¹ (Exit)\n\n"+
							"\t¡ÃØ³ÒàÅ×Í¡ËÁÒÂàÅ¢à¾×èÍÃÑº¡ÒÃºÃÔ¡ÒÃµÑé§áµè 1 - 8\n"+
							"*******************************************************************\n");
						int numMenu = scan.nextInt();
						return numMenu;
			}
		}

import java.util.Scanner;

public class Run {
	public static void main(String[] args)throws Exception {
				int numMenu = 0;
				do{
				numMenu = listMainMenu();
					// ��ҹ�������
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
			
			public static int listMainMenu(){  //�ʴ���¡��
				Scanner scan = new Scanner(System.in);
				
				System.out.println("*******************************************************************\n"+
							"\tWelcome to the IT Coffee House!\n\n" +
							"\t\t1. �ʴ���ª��͡�ῷ����� (List All Coffees)\n"+
							"\t\t2. ������Դ��� (Add Coffee)\n"+
							"\t\t3. ź��Դ��� (Delete Coffee)\n"+
							"\t\t4. ��䢪�Դ��� (Edit Coffee)\n"+
							"\t\t5. �ʴ���¡����ǹ��� (List All Recipes)\n"+
							"\t\t6. �����¡����ǹ��� (Edit Recipe)\n"+
							"\t\t7. �ʴ���������´������ (List All Coffees and Recipes)\n"+
							"\t\t8. ����÷ӧҹ (Exit)\n\n"+
							"\t��س����͡�����Ţ�����Ѻ��ú�ԡ�õ���� 1 - 8\n"+
							"*******************************************************************\n");
						int numMenu = scan.nextInt();
						return numMenu;
			}
		}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

public class Menu {
	private Vector<Coffee> coffeeVector = new Vector();

	public void addCoffeeInVector(Coffee coffee) {
		coffeeVector.add(coffee);
	}

	public void readFileToSetValues() { // ��ҹ��� coffee.txt
		try {
			File file = new File("coffee.txt");
			Scanner inputRead = new Scanner(file);
			while (inputRead.hasNext()) {
				String text = inputRead.nextLine();
				Scanner inputData = new Scanner(text);

				Coffee coffee = new Coffee();
				coffee.setArticle(inputData.next());
				coffee.setCoffeeName(inputData.next());
				int i = 0;
				int price[] = new int[3];

				while (inputData.hasNextInt()) {
					price[i] = inputData.nextInt();
					i++;
				}
				coffee.setPrice(price);

				this.addCoffeeInVector(coffee);
			}
			inputRead.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readRecipeToSetValues() { // ��ҹ��� recipe.txt
		try {
			File file = new File("recipe.txt");
			Scanner inputRead = new Scanner(file);

			while (inputRead.hasNext()) {
				String text = inputRead.nextLine();
				Scanner inputData = new Scanner(text);

				String no = inputData.next();
				String coffeeName = inputData.next();
				String text1 = inputData.next();

				int indexOfCoffee = this
						.getIndexOfCoffeeVecotorByName(coffeeName);

				while (inputData.hasNext()) {
					String recipe = inputData.next();
					Recipe r = new Recipe();
					r.setRecipeName(recipe);
					coffeeVector.get(indexOfCoffee).addRecipeInVector(r);
				}

				System.out.println();
			}
			inputRead.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void AddCoffee() { // �������١�� / ��ǹ���
		Scanner in = new Scanner(System.in);
		System.out
				.println("��سҡ�͡���͡�� (coffee name) ����ͧ���������¡��: ");
		String name = in.next();
		System.out.println("��سҡ�͡�Ҥҡ�� (hot) ��͹ : ");
		int hot = in.nextInt();
		System.out.println("��سҡ�͡�Ҥҡ�� (small) ��繢�Ҵ��� : ");
		int small = in.nextInt();
		if (small > hot || small == hot) {
			System.out.println("��سҡ�͡�Ҥҡ�� (Large) ��繢�Ҵ�˭�: ");
			int Large = in.nextInt();
			if (Large > small || Large == small) {
				Coffee coffee = new Coffee();
				coffee.setArticle(String.valueOf(coffeeVector.size() + 1));
				coffee.setCoffeeName(name);
				int i = 0;
				int price[] = new int[3];
				price[0] = hot;
				price[1] = small;
				price[2] = Large;
				coffee.setPrice(price);
				int norecipe = 0;
				do {
					System.out.println("��سҡ�͡�ӹǹ��ǹ�������ͧ��� : ");
					norecipe = in.nextInt();
				} while (norecipe > 4);
				for (int aaa = 0; aaa < norecipe; aaa++) {
					System.out.println("��سҡ�͡�ӹǹ��ǹ������ " + (aaa + 1)+ ": ");
					String namerecipe = in.next();
					Recipe r = new Recipe();
					r.setRecipeName(namerecipe);
					coffee.addRecipeInVector(r);
				}
				this.addCoffeeInVector(coffee);
				this.WriteFile();
			}
		}
	}
	public void WriteFile() { // ��¹���
		try {
			FileWriter fout = new FileWriter("coffee.txt");// Create file
			for (int i = 0; i < coffeeVector.size(); i++) {

				fout.write(coffeeVector.get(i).toString() + "\n");
			}
			fout.close();// Close the file output
			fout = new FileWriter("recipe.txt");// Create file
			for (int i = 0; i < coffeeVector.size(); i++) {

				fout.write(coffeeVector.get(i).getAllRecipe() + "\n");
			}
			fout.close();// Close the file output
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public int getIndexOfCoffeeVecotorByName(String coffeeName) {
		for (int i = 0; i < coffeeVector.size(); i++) {
			if (coffeeVector.get(i).getCoffeeName().equals(coffeeName))
				return i;
		}
		return -1;
	}

	public void listAllCoffee() {
		for (int i = 0; i < coffeeVector.size(); i++) {
			System.out.println(coffeeVector.get(i).toString());
		}
	}

	public void listAllRecipe() {
		for (int i = 0; i < coffeeVector.size(); i++) {
			System.out.println(coffeeVector.get(i).getAllRecipe());
		}
	}

	public void deleteCoffee() {
		this.listAllCoffee();
		Scanner in = new Scanner(System.in);
		System.out.println("��سҡ�͡�����Ţ�����ͧ���ź: ");
		int no = in.nextInt();
		coffeeVector.remove(no - 1);
		this.WriteFile();
	}

	public void editCoffee() {
		this.listAllCoffee();
		Scanner in = new Scanner(System.in);
		System.out.println("��سҡ�͡�����Ţ�����ͧ������: ");
		int no = in.nextInt();
		System.out
				.println("��سҡ�͡���͡�� (coffee name) ����ͧ���������¡��: ");
		String name = in.next();
		System.out.println("��سҡ�͡�Ҥҡ�� (hot) ��͹ : ");
		int hot = in.nextInt();
		System.out.println("��سҡ�͡�Ҥҡ�� (small) ��繢�Ҵ��� : ");
		int small = in.nextInt();
		if (small > hot || small == hot) {
			System.out.println("��سҡ�͡�Ҥҡ�� (Large) ��繢�Ҵ�˭�: ");
			int Large = in.nextInt();
			if (Large > small || Large == small) {
				coffeeVector.get(no - 1).setArticle(String.valueOf(no));
				coffeeVector.get(no - 1).setCoffeeName(name);
				int price[] = new int[3];
				price[0] = hot;
				price[1] = small;
				price[2] = Large;
				coffeeVector.get(no - 1).setPrice(price);
				int norecipe = 0;
				do {
					System.out.println("��سҡ�͡�ӹǹ��ǹ�������ͧ��� : ");
					norecipe = in.nextInt();
				} while (norecipe > 4);
				coffeeVector.get(no - 1).removeAllRecipes();
				for (int aaa = 0; aaa < norecipe; aaa++) {
					System.out.println("��سҡ�͡�ӹǹ��ǹ������ " + (aaa + 1)
							+ ": ");
					String namerecipe = in.next();
					Recipe r = new Recipe();
					r.setRecipeName(namerecipe);
					coffeeVector.get(no - 1).addRecipeInVector(r);
				}
				this.WriteFile();
			}
		}
	}
	public void editRecipe() {
		this.listAllRecipe();
		Scanner in = new Scanner(System.in);
		System.out.println("��سҡ�͡���͡��: ");
		String name = in.next();
		int no = this.getIndexOfCoffeeVecotorByName(name);
		int norecipe = 0;
		do {
			System.out.println("��سҡ�͡�ӹǹ��ǹ�������ͧ��� : ");
			norecipe = in.nextInt();
		} while (norecipe > 4);
		coffeeVector.get(no).removeAllRecipes();
		for (int aaa = 0; aaa < norecipe; aaa++) {
			System.out.println("��سҡ�͡�ӹǹ��ǹ������ " + (aaa + 1) + ": ");
			String namerecipe = in.next();
			Recipe r = new Recipe();
			r.setRecipeName(namerecipe);
			coffeeVector.get(no).addRecipeInVector(r);
		}

		this.WriteFile();
	}

	public void listAllCoffee_Recipe() {
		this.listAllCoffee();
		this.listAllRecipe();
	}
	
}

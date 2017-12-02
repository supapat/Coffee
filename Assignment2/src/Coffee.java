import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Coffee {
	private String coffeeName;
	private Vector<Recipe> recipeVector = new Vector();
	private String article;
	private int price[] = new int[3];
	
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public int[] getPrice() {
		return price;
	}
	public void setPrice(int[] price) {
		this.price = price;
	}

	public void addRecipeInVector(Recipe recipe){
		recipeVector.add(recipe);
	}
	
	public String getAllRecipe() {
		String text = "";
		text = article + "\t" + coffeeName + "\t: ";
		for (int i = 0; i < recipeVector.size(); i++) {
			text = text + recipeVector.get(i).toString() + "\t";
		}
		return text;
	}
	
	public void removeAllRecipes(){
		recipeVector.removeAllElements();
	}
	
	public String toString(){
		return article + "\t" + coffeeName + "\t"
				+ price[0] + "\t" + price[1] + "\t" + price[2];
	}
}

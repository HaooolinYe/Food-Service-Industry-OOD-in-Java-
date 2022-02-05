public class Owner extends IncomeTaxPayer {

	final private int incomeTaxPct = 10;
	private double salaryExpenses;

	private FoodPlace foodPlace;

	public Owner(String name) {
		/* TODO: Add your code here */
		/* TODO: Also edit the super call */
		super(name);
	}

	public int getIncomeTaxPct() {
		return incomeTaxPct;
	}

	public FoodPlace getFoodPlace() { return foodPlace; }

	public double getSalaryExpenses() {
		return salaryExpenses;
	}

	public void setSalaryExpenses(double salaryExpenses) {
		this.salaryExpenses = salaryExpenses;
	}

	public void setFoodPlace(FoodPlace foodPlace) {
		this.foodPlace = foodPlace;
	}

	@Override
	public double calculateIncomeTax() {
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		salaryExpenses += foodPlace.getFixedCosts();
		if (this.getIncome() > salaryExpenses) {
			return (0.1) * (this.getIncome() - salaryExpenses);
		}
		return 0;
	}
}

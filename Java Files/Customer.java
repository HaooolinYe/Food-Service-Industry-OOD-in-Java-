public class Customer  {

	private String name;
	private int  targetTipPct;

	public Customer(String name, int targetTipPct) {
		/* TODO: Add your code here */
		this.name = name;
		this.targetTipPct = targetTipPct;
	}

	public String getName() {
		return name;
	}

	public int getTargetTipPct() {
		return targetTipPct;
	}

	public String getDescriptiveMessage(FoodPlace foodPlace) {
		return this.name + " dined in " + foodPlace.getName();
	}

	public void dineAndPayCheck(FoodPlace foodPlace, double menuPrice ) {
		/* TODO: Add your code here */
		Check check = new Check(menuPrice);
		double average_tip = (this.targetTipPct + foodPlace.getTipPercentage()) / 2;
		check.setTipByPct(average_tip);
		foodPlace.distributeIncomeAndSalesTax(check);
	}
}

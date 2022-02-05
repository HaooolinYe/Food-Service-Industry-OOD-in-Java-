import java.util.ArrayList;
import java.util.List;

public class Restaurant extends FoodPlace {

	private Staff cook;
	private Server server;

	public Restaurant(String name, double fixedCosts, Owner owner, Staff cook, Server server) {
		/* TODO: Add your code here */
		/* TODO: Also edit the super call */
		super(name,fixedCosts,owner);
		this.cook = cook;
		this.server = server;
	}

	public Staff getCook() {
		return cook;
	}

	public Server getServer() {
		return server;
	}

	@Override
	public String toString() {
		return "Name of restaurant: " + this.getName() +
				"\n" + "Owner: " + this.getOwner() +
				"\n" + "Cook: " + cook +
				"\n" + "Server: " + server;
	}

	@Override
	public void workShift(int hours) {
		/* TODO: Add your code here */
		Owner owner = this.getOwner();
		owner.setSalaryExpenses(cook.workHours(hours) + server.workHours(hours));

	}

	@Override
	public List<IncomeTaxPayer> getIncomeTaxPayers() {
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		ArrayList<IncomeTaxPayer> arrayList = new ArrayList<IncomeTaxPayer>();
		arrayList.add(this.getServer());
		arrayList.add(this.getOwner());
		arrayList.add(this.getCook());
		return arrayList;
	}

	@Override
	public void distributeIncomeAndSalesTax(Check check) {
		/* TODO: Add your code here */
		Owner owner = this.getOwner();
		owner.setIncome(owner.getIncome() + check.getMenuPrice());
		this.setTotalSalesTax(this.getTotalSalesTax() + check.getSalesTax());
		this.getCook().setIncome(this.cook.getIncome() + (check.getTip() * 0.2));
		this.server.setIncome(this.server.getIncome() + check.getTip() * 0.8);

	}

	@Override
	public double getTipPercentage() {
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		return server.getTargetTipPct();
	}

}

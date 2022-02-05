public class Staff extends IncomeTaxPayer {

	private int salaryPerHour;
	final private int incomeTaxPercentage = 25;

	public Staff(String name, boolean isCook) {
		/* TODO: Add your code here */
		/* TODO: Also edit the super call */
		super(name);
		this.salaryPerHour = isCook ? 20 : 10;
	}

	public int getSalaryPerHour() {
		return salaryPerHour;
	}

	public int getIncomeTaxPercentage() {
		return incomeTaxPercentage;
	}

	public double workHours(int numHours) {
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		double salary = numHours * this.getSalaryPerHour();
		this.setIncome(this.getIncome() + salary);
		return this.getIncome();
	}

	@Override
	public double calculateIncomeTax() {
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		return this.getIncome() * incomeTaxPercentage / 100;
	}

}

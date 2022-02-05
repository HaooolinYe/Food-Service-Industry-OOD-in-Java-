
import java.util.ArrayList;
import java.util.List;

public class FastFood extends FoodPlace {

    private List<Staff> staff = new ArrayList<>();

    public FastFood(String name, double fixedCosts, Owner owner, List<Staff> staff) {
        /* TODO: Add your code here */
        /* TODO: Also edit the super call */
        super(name,fixedCosts,owner);
        this.staff = List.copyOf(staff);
    }

    public List<Staff> getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name of FastFood: " + this.getName() +
                "\n" + "Owner: " + this.getOwner());
        int index = 1;
        for (Staff staff: staff) {
            builder.append("\n" + "Staff " + index++ + " : " + staff );
        }
        return builder.toString();
    }

    @Override
    public void workShift(int hours) {
        /* TODO: Add your code here */
        Owner owner = this.getOwner();
        for (Staff s : staff) {
            owner.setSalaryExpenses(owner.getSalaryExpenses() + s.workHours(hours));
        }
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        /* TODO: Add your code here */
        /* TODO: Also remove return statement below*/
        ArrayList<IncomeTaxPayer> arrayList = new ArrayList<IncomeTaxPayer>();
        arrayList.add(this.getOwner());
        for ( Staff s : staff) {
            arrayList.add(s);
        }
        return arrayList;
    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {
        /* TODO: Add your code here */
        Owner owner = this.getOwner();
        owner.setIncome(owner.getIncome() + check.getMenuPrice());
        this.setTotalSalesTax(this.getTotalSalesTax() + check.getSalesTax());
        double tip = check.getTip();
        if (tip > 0) {
            int number_of_staff = staff.size();
            for (Staff s : staff) {
                s.setIncome(tip / number_of_staff);
            }
        }
    }

    @Override
    public double getTipPercentage() {
        return 0;
    }
}

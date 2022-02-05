import java.util.ArrayList;
import java.util.List;

public class FoodStand extends FoodPlace {

    public FoodStand(String name, double fixedCosts, WorkingOwner owner) {
        /* TODO: Add your code here */
        /* TODO: Also edit the super call */
        super(name,fixedCosts,owner);
    }

    @Override
    public String toString() {
        return "Name of FoodStand: " + this.getName() +
                "\n" + "Owner: " + this.getOwner();
    }

    @Override
    public void workShift(int hours) {
        // no salaried workers so do nothing
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        /* TODO: Add your code here */
        /* TODO: Also remove return statement below*/
        ArrayList<IncomeTaxPayer> arrayList = new ArrayList<IncomeTaxPayer>();
        arrayList.add(this.getOwner());
        return arrayList;

    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {
        /* TODO: Add your code here */
        Owner owner = this.getOwner();
        owner.setIncome(owner.getIncome() + check.getMenuPrice() + check.getTip());
        this.setTotalSalesTax(this.getTotalSalesTax() + check.getSalesTax());
    }

    @Override
    public double getTipPercentage() {
        /* TODO: Add your code here */
        /* TODO: Also remove return statement below*/
        WorkingOwner owner = (WorkingOwner) this.getOwner();
        return owner.getTargetTipPct();
    }
}

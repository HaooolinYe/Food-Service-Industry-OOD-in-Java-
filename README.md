<div id="top"></div>

# Food Service Industry (OOD in Java) <img src="https://user-images.githubusercontent.com/90864900/152653951-5ba48dee-204c-4687-8725-8faf602494d4.png" height=50 width=50>
An Object-Oriented-Design project written in Java which models parts of the food service industry.
* I modeled places where customers can buy food: restaurants, food stands, and fast food.
* I modeled the payment of bills, including sales tax and tip. 
* I also modeled a tax collector who collects both sales tax and income tax. 
* I only modeled one year: the workers each have some income and pay tax for that year.
* I did not model many other things such as the food or menu.

<img src="https://user-images.githubusercontent.com/90864900/152652880-dc3453da-bcb1-4728-8f2a-114a1dae8842.png">

## Classes <img src="https://user-images.githubusercontent.com/90864900/152654045-ceb55752-3068-4a72-8d8f-afc8e36a3acb.png" height=45 width=45>
<div id="fp">
 
### FoodPlace (Abstract  Class) <img src="https://user-images.githubusercontent.com/90864900/152698171-083716c9-aef7-4104-b4bd-cffd112895a2.png" height=45 width=45>
FoodPlace is an abstract class. It has several private fields such as:
* <strong>foodPlaceID</strong> – each FoodPlace has a unique ID; the id’s are determined by a counter, namely the
following static variable (currentMaxFoodPlaceID)
* <strong>currentMaxFoodPlaceID</strong> – at any time, this is the largest ID of any FoodPlace; when a new Food-
Place is instantiated, the value of this variable is incremented and becomes the id of this new Food-
Place
* <strong>fixedCosts</strong> – every FoodPlace has certain maintenance, supply, and other fixed costs (lumped together)
* <strong>totalSalesTax</strong> - each Check paid by a Customer will have a sales tax that is added; the FoodPlace
needs to accumulate these sales taxes; they will be collected by a TaxCollector.

It also has two methods:
* a <strong>constructor FoodPlace()</strong> - sets the fields; also, sets the owner’s FoodPlace field.
* <strong>equals()</strong> – returns true if the argument object is indeed a FoodPlace and the foodPlaceID’s
match; otherwise, it returns false

<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

---------------------------------------------------------------------------
<div id="res">
 
### Restaurant <img src="https://user-images.githubusercontent.com/90864900/152698314-c710c159-a023-4290-aaab-cdf255446992.png" height=45 width=45>

The Restaurant class extends <a href="#fp">FoodPlace</a>. It has the following public methods:
* <strong>a constructor Restaurant()</strong> – sets the fields; note that a Restaurant is a FoodPlace, so call
super().
* <strong>workShift()</strong> – returns nothing (void). This method models that the cook and server are
paid an hourly wage: specifically, the method increases the cook’s and server’s incomes based on
the number of hours worked and per hour salary; the method also adds these wages to the owner’s
accumulated salary expenses.
* <strong>getIncomeTaxPayers()</strong> – returns a List of IncomeTaxPayers that work at that Restaurant,
namely a cook, server, and owner; the List return type is an
ArrayList. The order of IncomeTaxPayer’s is radom.
* <strong>distributeIncomeAndSalesTax()</strong> – returns nothing (void) ; the parameter for this method is
a Check. In all restaurants, the menu price component of the check is added to the owner’s income;
the tip component is added to the income of the cook (20 % of tip) and to the server (80 % of tip);
the total sales tax is accumulated as well.
 * <strong>getTipPercentage()</strong> – returns the Server’s target tip percentage

<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

---------------------------------------------------------------------------
<div id="fs">
 
### Food Stand <img src="https://user-images.githubusercontent.com/90864900/152698985-3136daf9-35a1-4b0a-9553-808ec885c44e.png" height=45 width=45>
 The FoodStand class extends <a href="#fp">FoodPlace</a>. It has the following methods:
* a <strong>constructor FoodStand()</strong> – sets the fields; note that a FoodStand is a FoodPlace, so call
super().
* <strong>getIncomeTaxPayers()</strong> – returns a List containing one element (the owner); it is an ArrayList.
* <strong>distributeIncomeAndSalesTax()</strong> – using the check, it updates the owner’s income by
adding the menu price and the tip; it also updates the total sales tax.
* <strong>getTipPercentage()</strong> – returns the target tip percentage defined by the owner; note that
the owner of a FoodStand is a WorkingOwner which has a field targetTipPct
 <p align="right">(<a href="#top">↑Top</a>)</p>
 </div>
 
 ---------------------------------------------------------------------------
 <div id="ff">
 
### Fast Food <img src="https://user-images.githubusercontent.com/90864900/152699314-871f8971-5314-4190-9ee2-ec089dba266a.png" height=45 width=45>
The FastFood class extends <a href="#fp">FoodPlace</a>. It has the following methods:
* a <strong>constructor FastFood</strong> – sets the fieldsThe Staff list field contains a shallow copy of the Staff list argument.
* <strong>workShift()</strong> – returns nothing (void) ; it models that the owner pays each staff an hourly
wage. The method adds an amount to each of the staff’s incomes, and it adds these amounts to the
owner’s total salary expenses.
* <strong>getIncomeTaxPayers()</strong> – returns a shallow copy of the ArrayList that includes the owner
and all the staff in a random order.
* <strong>distributeIncomeAndSalesTax()</strong> – returns nothing (void); in all fastfood places, the menu
price is an income for the owner. It is also possible to have tips, but the tip only depends on the
customer. The tip is split equally between all the staff (which does not include the owner).
<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

 ---------------------------------------------------------------------------
 <div id="itp">
 
### IncomeTaxPayer <img src="https://user-images.githubusercontent.com/90864900/152699856-c8c281ac-b791-4aa8-99dc-8bcfe0f396e1.png" height=45 width=45>
This is an abstract class. It has the following methods:
* a constructor <strong>IncomeTaxPayer()</strong> – assigns a uniqueID to this income tax payer.
* <strong>equals()</strong> – returns true if the argument is indeed an IncomeTaxPayer and if the id’s match,
and otherwise returns false. Two IncomeTaxPayers might have the same name, but they
are guaranteed to have different id’s.
<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

 ---------------------------------------------------------------------------
 <div id="staff">
 
### Staff <img src="https://user-images.githubusercontent.com/90864900/152700093-de84cdec-d246-4a94-8765-fdaeaab264ef.png" height=30 width=50>
Staff is a class which extends <a href="#itp">IncomeTaxPayer</a>. It has the following methods:
* a <strong>constructor Staff</strong> – the salaryPerHour is determined by the parameter isCook: a cook is
paid $20 per hour and otherwise a staff is paid $10 per hour.
* <strong>workHours()</strong> – returns the amount of money earned by that staff, and modifies that staff’s
income.
The parameter of this method is the number of hours worked in a shift; whenever a staff works this
number of hours, the staff’s income increases; this method will be called in the different implementations
 of FoodPlace.workShift() method. This method is both a mutator and an accessor,
namely it changes a field in the staff object and it also returns the amount of money earned by that
staff.
  * <strong>calculateIncomeTax()</strong> – all staff pay 25% income tax.
<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

 ---------------------------------------------------------------------------
<div id="server">
 
### Server <img src="https://user-images.githubusercontent.com/90864900/152831666-a60b6fab-94c0-4f05-815a-b37b41975069.png" height=43 width=43>
Server is a class which extends <a href="#staff">Staff</a>. (Restaurant is the only FoodPlace that has Server's.) It contains one method:
* a <strong>constructor Server()</strong> – a Server is a Staff and in particular a Server is not a
cook.
Each server (and cook) receives a tip from each Customer as part of the check – see the <a href="#res">Restaurant</a>’s <a href="#res">distributeIncomeAndSalesTax()</a>
method. The tip is calculated by the Customer.dineAndPayCheck() method:
the tip depends on both the Server (e.g. their skill and friendliness) and on the Customer (whether they are
generous or not), namely the final tip percentage is the average of the target tip percentages of the Server
and the Customer.
<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

 ---------------------------------------------------------------------------
 <div id="owner">
 
### Owner <img src="https://user-images.githubusercontent.com/90864900/152857898-1b728275-0a99-44aa-8452-b52a0577e061.png" height=43 width=43>
The Owner class extends <a href="#itp">IncomeTaxPayer</a>. It contains the following methods:
 * a <strong>constructor Owner()</strong> – sets the name of this owner (owner inherits its
name field from its superclass)
 * <strong>calculateIncomeTax()</strong> – returns the amount of tax that the owner needs to pay, based on
the owner’s income and expenses. The owner’s income is the sum of the menu prices on all the
customer’s checks. The owner’s expenses are the hourly wages paid to the staff (salaryExpenses),
and certain fixed costs (fixedCosts) for running the restaurant (e.g. maintenance, equipment, food
supplies, etc) which aren't modeled in detail. The owner’s income tax is 10 percent of the difference
of the income and the expenses, assuming the income is greater than the expenses; if the
income is less than the expenses, then the income tax is zero rather than negative.
<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

 ---------------------------------------------------------------------------
<div id="wo">
 
 ### Working Owner <img src="https://user-images.githubusercontent.com/90864900/153055406-8353f3c1-67b6-4718-8ff6-9c6f2bfd28f6.png" height=45 width=45>
 WorkingOwner extends <a href="#owner">Owner</a>. In our model, the only WorkingOwners are the owners of <a href="#fs">FoodStands</a>.
WorkingOwners are different from general <a href="#owner">Owner</a> in that working owners get tips. An example of a
WorkingOwner would be a hot dog stand owner.<br>
It contains just one method:
 * a <strong>constructor WorkingOwner()</strong> – sets the name (WorkingOwner inherits its
name field) as well as the targetTipPct field.
<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

 ---------------------------------------------------------------------------
 <div id="ck">
 
 ### Check<img src="https://user-images.githubusercontent.com/90864900/153055894-2bca56ee-20c8-41c9-ae3c-271ba18dd310.png" height=45 width=45>
It contains two methods:
* a <strong>constructor Customer()</strong> – there are two parameters: the name (this is the only place where
the customer identity is used) and the targetTipPct (this is the tip percentage that this customer give
for their expected level of service; the tip is determined by the Customer in its dineAndPayCheck
method – see next)
 * <strong>dineAndPayCheck()</strong> – returns nothing (void); the details of this method are given below.
 <t>The idea of the dineAndPayCheck() method is that a customer visits a FoodPlace, eats, and pays the
check. The tip calculation and the way the payment is distributed depends on the FoodPlace. Specifically,
the method does the following:
1. construct a new check;
2. calculate the tip: The tip percentage is the average of a target tip for that customer and the Food-
Place’s tip percentage returned by the getTipPercentage() method of the FoodPlace. For example,
a customer might have a target tip of 10% and the food place might have a target tip of 20%, and
in this case the customer would tip the average, namely 15%. Another example is a customer with
15% tip percentage who goes to a FastFood place like McDonalds; the FastFood tip percentage is
0 % and so the customer would only give 7.5% tip percentage on the check. These target tips are
fields within the Customer and Foodplace objects. Hint: the method Check.setTipByPct() should be
called here.
3. distribute earnings of this check: the owner gets an income contribution of the menu price; the tip
is distributed according to the FoodPlace’s class policy; the sales tax is set aside for the tax collector.
This procedure is done with the FoodPlace.distributeEarnings() method. [update: Should be
FoodPlace.distributeIncomeAndSalesTax() method]
<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

 ---------------------------------------------------------------------------
 <div id="tc">
  
  ### TaxCollector<img src="https://user-images.githubusercontent.com/90864900/153056883-ee9946bf-4e4e-4d2a-bc37-01a11fc97ed5.png" height=45 width=45>
  It contains the following methods:
* a <strong>constructor</strong> TaxCollector - assigns the food place list.
* <strong>collectTax()</strong> – returns nothing (void); for each FoodPlace in the list of all FoodPlace’s,
the sales tax is collected and the income taxes from all IncomeTaxPayer’s are collected, and these
values are added to the incomeTaxCollected and salesTaxCollected fields.
  

<div id="top"></div>

# Food Service Industry (OOD in Java) <img src="https://user-images.githubusercontent.com/90864900/152653951-5ba48dee-204c-4687-8725-8faf602494d4.png" height=50 width=50>
An Object-Oriented-Design project written in Java which models parts of the food service industry.
* We model places where customers can buy food: restaurants, food stands, and fast food.
* We model the payment of bills, including sales tax and tip. 
* We also model a tax collector who collects both sales tax and income tax. 
* We only model one year: the workers each have some income and pay tax for that year.
* We do not model many other things such as the food or menu.

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
* a constructor FastFood – sets the fieldsThe Staff list field contains a shallow copy of the Staff list argument.
* workShift() – returns nothing (void) ; it models that the owner pays each staff an hourly
wage. The method adds an amount to each of the staff’s incomes, and it adds these amounts to the
owner’s total salary expenses.
* getIncomeTaxPayers() – returns a shallow copy of the ArrayList that includes the owner
and all the staff in a random order.
* distributeIncomeAndSalesTax() – returns nothing (void); in all fastfood places, the menu
price is an income for the owner. It is also possible to have tips, but the tip only depends on the
customer. The tip is split equally between all the staff (which does not include the owner).
<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

 ---------------------------------------------------------------------------
 <div id="itp">
 
### IncomeTaxPayer <img src="https://user-images.githubusercontent.com/90864900/152699856-c8c281ac-b791-4aa8-99dc-8bcfe0f396e1.png" height=45 width=45>
 This is an abstract class. It has the following methods:
* constructor IncomeTaxPayer() – assigns a uniqueID to this income tax payer.
* equals() – returns true if the argument is indeed an IncomeTaxPayer and if the id’s match,
and otherwise returns false. Two IncomeTaxPayers might have the same name, but they
are guaranteed to have different id’s.
<p align="right">(<a href="#top">↑Top</a>)</p>
</div>

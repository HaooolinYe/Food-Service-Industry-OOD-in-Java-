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
<div id="FoodPlace">
 
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

### Restaurant <img src="https://user-images.githubusercontent.com/90864900/152698314-c710c159-a023-4290-aaab-cdf255446992.png" height=45 width=45>
The Restaurant class extends <a href="FoodPlace">FoodPlace</a>. You will implement the following public methods:
* <strong>a constructor Restaurant()</strong> – sets the fields; note that a Restaurant is a FoodPlace, so call
super().
* <strong>workShift()</strong> – returns nothing (void). This method models that the cook and server are
paid an hourly wage: specifically, the method increases the cook’s and server’s incomes based on
the number of hours worked and per hour salary; the method also adds these wages to the owner’s
accumulated salary expenses.
* <strong>getIncomeTaxPayers()</strong> – returns a List of IncomeTaxPayers that work at that Restaurant,
namely a cook, server, and owner; the List return type allows you to use either a LinkedList or
ArrayList (either is fine). The order of IncomeTaxPayer’s in the list doesn’t matter.
* <strong>distributeIncomeAndSalesTax()</strong> – returns nothing (void) ; the parameter for this method is
a Check. In all restaurants, the menu price component of the check is added to the owner’s income;
the tip component is added to the income of the cook (20 % of tip) and to the server (80 % of tip);
the total sales tax is accumulated as well.
 * <strong>getTipPercentage()</strong> – returns the Server’s target tip percentage

<p align="right">(<a href="#top">↑Top</a>)</p>

---------------------------------------------------------------------------
#### IncomeTaxPayer
<img src="https://user-images.githubusercontent.com/90864900/152654251-b1d88c0a-e5b8-4394-a399-4a24ccfcf8a5.png" height=800 width=600>

<p align="right">(<a href="#top">↑Top</a>)</p>

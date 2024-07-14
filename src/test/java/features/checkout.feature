Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Verify the checkout functionality

Given User is on GreenCard Landing page
When User searched with shortname <Name> and extracted actual name of product
And Added "3" items of selected product to cart
Then User proceeds to checkout and validate the <Name> item in checkout page
#And Verify the quantity of product added
And Verify user have ablitiy to enter promo code and place the order 

Examples:
| Name |
| Tom  |
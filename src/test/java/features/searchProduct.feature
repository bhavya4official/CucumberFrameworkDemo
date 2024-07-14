Feature: Search and Place the order for Products

#Scenario: Search experience for product search in both home & offer page
#
#Given User is on GreenCard Landing page
#When User searched with shortname "Tom" and extracted actual name of product
#Then User searched with "Tom" shortname in offers page
#And Validate product name in offers page matches with Lnading page

#Parameterize the test with different data sets

@OffersPage
Scenario Outline: Search experience for product search in both home & offer page

Given User is on GreenCard Landing page
When User searched with shortname <Name> and extracted actual name of product
Then User searched with <Name> shortname in offers page
And Validate product name in offers page matches with Landing page

Examples:
| Name |
| Tom  |
| Beet |
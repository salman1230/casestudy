Feature: Cart Page
Scenario: The One where the user moves to carry without adding any item in it
Given Alex has registered in to TestMeApp
When Alex search a particular product like Headphone
And Try to proceed to payment without adding any item in it
Then TestMe doesn't display the cart icon
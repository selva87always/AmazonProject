#Author: selva

@tag
Feature: amazon add to cart feature
 
  @tag1
  Scenario Outline: Add 5 items to cart & Verify added or not
  
    Given User is on Amazon page
    When User searches "<item1>","<item2>", "<item3>", "<item4>", "<item5>" and add five items to the cart individually
    Then User verifies whether all the selected items were in cart or not

   Examples:
|item1|item2|item3|item4|item5|
|Dell|HP|Acer|Asus|Lenovo Laptop|
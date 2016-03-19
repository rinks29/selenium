# Selenium test for the following
Write a Selenium script to automate following processes:

o   Order in minimum 2 different products as a non-logged user. Store the data given during the order process

o   Log in to admin side which is https://demo2.shoop.io/sa/   (account: admin password:admin)

o   Go to Menu à Orders

o   Verify that data given in order that you just made has passed correctly to admin & order management

o   Send out the order

## My approach

I wrote seleniumWrapper class that includes methods that may be reused.

OrdersTest is the class which contains the actual test.

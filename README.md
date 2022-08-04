# Level-Payment
A project for Level: Mind Sleep Body Journal, 
implementing the payment screen and home page, 
where the app has been configured using Firebase Console 
implementing In-app messaging.

The use of the following android and kotlin properties have been done as follows:
1. In-app messaging : To take discounted price from firebase console
2. data binding : To bind the UI componenets with the layout
3. coroutine : To run the in-app messaging the background thread
4. extension funciton : To add a new getdata() functionality in the Payment class

#Screen-Shots

#Home Screen

On clicking anywhere in the homescreen the user jumps to the payment screen.

![WhatsApp Image 2022-08-04 at 6 03 42 PM](https://user-images.githubusercontent.com/79468798/182858986-bb6560df-34ef-40ff-9477-3f07d59700b0.jpeg)

#Payment Screen

The payment screen has a default value of 100 $/year.
When the discount button is clicked a discounted price is shown
in the EditText view.

![WhatsApp Image 2022-08-02 at 10 35 32 PM](https://user-images.githubusercontent.com/79468798/182433184-d9e69501-6c0a-4b50-866b-3afda06cc473.jpeg)

#Real-Time-Database(Firebase)

The Firebase consists of discounted price which is retrieved 
by the app when discount button is clicked.

![Firebase Console](https://user-images.githubusercontent.com/79468798/182432661-ab678a80-e17d-432e-9ed4-fd2485888721.jpg)

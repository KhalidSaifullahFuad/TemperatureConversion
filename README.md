# TemperatureConvertion

### Problem Description:

* Write a JavaFX program where users can do login from one screen to another screen.
* If user fails to login than show message `"Invalid user Id or Password"` in a label. 
* Must use provided csv file `(user.csv)` for Username and Password.
* After login user can perform temperature conversion. 
* For Second screen, there will be a text field, a button and a text area. 
* User will enter temperature in degree Fahrenheit in the text field. 
* After clicking the button temperature conversion from degree Fahrenheit to Kelvin, Celsius and Rankine will occur. 
* Then in text area converted results will be shown like below.

  Input:
  ```
  Fahrenheit: 5 F
  ```  
  Output:
  ```
  Kelvin: 258.15 K
  Celsius: -15 C
  Rankine: 464.67 R
  ```
  
* Formulas: 
  - Celsius (°C)= 5 / 9 x (Fahrenheit − 32)
  - Kelvin (K) = Celsius + 273.15
  - Rankine (°R) = (Celsius + 273.15) x 1.8

* After clicking button, Input (5 C) and outputs (278.15 K, 41 F, 500.67 R) will be appended in a file called Text.csv.
  ![output_csv](https://user-images.githubusercontent.com/64584169/172020979-9a84a959-6b7e-4ff7-8792-d4efc94c75bb.png)

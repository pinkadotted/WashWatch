# WashWatch

Things that need to be standardised so that the code doesn't break:

Android version used for development:
SDK version:

Current structure:
1. Landing page (MainActivity.java + activity_main.xml): Contains the 3 BLK buttons to be selected
2. Washer page (Displays 10 washers using CARDS, coloured RED or GREEN based on availability): Each RED washer is selectable and a card pops up displaying the time remaining
3. Dryer page (Displays 10 dryers, coloured RED or GREEN based on availability)

Card layout: 
1. Machine number
2. If occupied, then remaining time 
3. 3-dot menu for report function

Things to note:
1. GridView and GridLayout
2. ScrollView

How do we refresh the washer/dryer page and how often?
1. 

Under what circumstances will the washer/dryer icon turn from GREEN to RED:
1. If th vibration sensor records data for 1 consecutive minute, then timer counts down from 45min.

Under what circumstances will the washer/dryer icon turn from RED to GREEN:
1. If the vibration sensor has not recorded any movement for 5 consecutive minutes, then machine is UNOCCUPIED and icon turns from red to green
2. If the timer of the machine counts all the way down to 0min

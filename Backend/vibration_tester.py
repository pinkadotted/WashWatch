import RPi.GPIO as GPIO
import time
import firebase_admin
from firebase_admin import db
import json

class vibration:
    def __init__(self, channel, threshold = 10) -> None:
        self.vibration_rate = 0
        self.threshold = threshold
        self.channel = channel
        self.last_time_checked = time.time()
    
    # function called when event occurs (0 to 1 or 1 to 0)
    def callback(self, collection):
        new_data = {
                'washer_id': '57_w1', 
                'in_use': True,
                'time_start': time.time(),
                'default_time_end': time.time(), # 37 mins + time_start
                'overrun': False # if the machine is still running past the default end time
                }
        current_state = collection.find_one()
        self.vibration_rate += 1
        # checks vibration rate every minute
        if (time.time()-self.last_time_checked).total_seconds()>60:
            if self.vibration_rate >= self.threshold: # machine is active
                self.vibration_rate = 0
                self.last_time_checked = time.time()
                # machine in use + vibration > threshold
                if current_state["in_use"]:
                    if time.time() > current_state["default_time_end"]:
                        # force machine state to end
                        new_data["in_use"] = False
                #else: machine not in use + vibration > threshold
        ref.update(new_data)

if __name__ == '__main__':


    #GPIO SETUP
    channel = 17
    GPIO.setmode(GPIO.BCM)
    GPIO.setup(channel, GPIO.IN)

    vibrator = vibration(17)

    cred_obj = firebase_admin.credentials.Certificate('washwatch-a725a-firebase-adminsdk-99ewg-ec79c6d04f.json')
    default_app = firebase_admin.initialize_app(cred_obj, {
	'databaseURL':"https://washwatch-a725a-default-rtdb.firebaseio.com/"
	})
    ref = db.reference("/")

    # let us know when the pin goes HIGH or LOW
    GPIO.add_event_detect(channel, GPIO.BOTH, bouncetime=300) 
    # assign function to GPIO PIN, Run function on change
    GPIO.add_event_callback(ref.get(), vibrator.callback) 

    while True:
        time.sleep(1)

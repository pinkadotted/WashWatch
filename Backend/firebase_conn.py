import firebase_admin
from firebase_admin import db



cred_obj = firebase_admin.credentials.Certificate('washwatch-a725a-firebase-adminsdk-99ewg-ec79c6d04f.json')
default_app = firebase_admin.initialize_app(cred_obj, {
	'databaseURL':"https://washwatch-a725a-default-rtdb.firebaseio.com/"
	})
ref = db.reference("/")
print(ref.get())

new_data = {
    'washer_id': '57_w1', 
    'in_use': True,
    'time_start': '0', 
    'time_left': 15, # do we need this? 
    'default_time_end': '', # 37 mins + time_start
    'overrun': False # if the machine is still running past the default end time
    }

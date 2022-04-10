import firebase_admin
from firebase_admin import db
from datetime import datetime, timedelta



cred_obj = firebase_admin.credentials.Certificate('washwatch-a725a-firebase-adminsdk-99ewg-ec79c6d04f.json')
default_app = firebase_admin.initialize_app(cred_obj, {
	'databaseURL':"https://washwatch-a725a-default-rtdb.firebaseio.com/"
	})
ref = db.reference("/")
print(ref.get())

new_data = {
            'washer_id': '57_w1', 
            'in_use': True,
            'time_start': str(datetime.now()),
            'default_time_end': str(datetime.now() + timedelta(minutes=37)), # 37 mins + time_start
            'overrun': False # if the machine is still running past the default end time
            }

# new_data = {
#             'time_start': str(datetime.now()),
#             'default_time_end': str(datetime.now() + timedelta(minutes=37)), # 37 mins + time_start
#             'overrun': False # if the machine is still running past the default end time
#             }

# ref.update(new_data)

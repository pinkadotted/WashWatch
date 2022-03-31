import pymongo
import dns

client = pymongo.MongoClient(
    "mongodb+srv://washwatcher:washwatcheradmin@cluster0.vapic.mongodb.net/?retryWrites=true&w=majority")

collection = client["blk_57"]["washer_1"]

current_state = collection.find_one()

print(current_state)

new_data = {
    'washer_id': '57_w1', 
    'in_use': True,
    'time_start': '0', 
    'time_left': 15, # do we need this? 
    'default_time_end': '', # 37 mins + time_start
    'overrun': False # if the machine is still running past the default end time
    }

# new_doc = { "$set": new_data }
# query = {'washer_id': '57_w1'}
# collection.update_one(query, new_doc)


# 

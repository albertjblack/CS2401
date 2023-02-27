import requests
import time

# create equest to google.com every 5 minutes
counter: int = 0
while True:
    requests.get("http://google.com")
    print(f"counter: {counter}")
    time.sleep(300)

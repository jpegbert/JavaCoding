
import requests
import sys

def my_test(name, age):
    response = requests.get("http://www.baidu.com")
    print("name: "+name)
    print("age: "+age)
    return "success"


my_test(sys.argv[1], sys.argv[2])

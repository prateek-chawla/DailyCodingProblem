'''
Question -->
This problem was asked by Microsoft.
Implement the singleton pattern with a twist. First, instead of storing one instance,
store two instances. And in every even call of getInstance(), return the
first instance and in every odd call of getInstance(), return the second instance.

Approach -->
Create two instances and a flag to keep track of calls to getInstance()
Raise Exception on invalid instantiation
'''


class Singleton:
    first_instance = None
    second_instance = None
    evenFlag = False

    def __init__(self):
        if Singleton.first_instance is not None and Singleton.second_instance is not None:
            raise Exception(" This is a Singleton Class ")
        else:
            if Singleton.first_instance is None:
                Singleton.first_instance = self
            else:
                Singleton.second_instance = self

    @staticmethod
    def getInstance():
        if Singleton.first_instance is None or Singleton.second_instance is None:
            Singleton()
        else:
            if Singleton.evenFlag:
                Singleton.evenFlag = not Singleton.evenFlag
                return Singleton.first_instance
            else:
                Singleton.evenFlag = not Singleton.evenFlag
                return Singleton.second_instance


obj1 = Singleton.getInstance()
obj2 = Singleton.getInstance()

obj3 = Singleton.getInstance()
print(obj3)
obj4 = Singleton.getInstance()
print(obj4)

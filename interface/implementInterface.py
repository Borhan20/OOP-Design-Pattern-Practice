from abc import ABC, abstractmethod
import zope.interface

class Company(ABC): 
    def __init__(self, name):
        self.name = name
    @abstractmethod
    def doWork(self): 
        pass

    def setName(self, name): 
        self.name = name 
    def getName(self):
        print(self.name) 



class FrontEnd(Company): 
    def __init__(self, name):
        super().__init__(name)
    def doWork(self):
        print("this is frontend developers work")

class BackendEnd(Company): 
    def __init__(self, name):
        super().__init__(name)
    def doWork(self):
        print("this is backend work")


class CompanyInterace(zope.interface.Interface):
    def doWork(self): 
        pass 
    def getName(self): 
        pass


@zope.interface.implementer(CompanyInterace)
class FrontendImpl(): 
    def __init__(self, name):
        self.name = name
    def doWork(self):
        print("this is frondend work impl")
    def getName(self): 
        print(self.name)
    

@zope.interface.implementer(CompanyInterace)
class BackendImpl():
    def __init__(self, name):
        self.name = name 
    def doWork(self):
        print("this is backend work impl")
    def getName(self): 
        print(self.name)

if __name__ == "__main__": 
    #this below portion for abstract method using inheritance
    print("this below portion for abstract method using inheritance: ")
    frontEnd = FrontEnd("Penta global")
    frontEnd.doWork()
    frontEnd.getName()
    backend = BackendEnd("Therap bd")
    backend.doWork()
    backend.getName()

    # this below code portion for encapsulating method
    print("this below code portion for encapsulating method: ")
    frontendImpl = CompanyInterace(FrontendImpl("penta"))
    frontendImpl.doWork()
    frontendImpl.getName()
    backendImpl = CompanyInterace(BackendImpl("therap"))
    backendImpl.doWork()
    frontendImpl.getName()

    
    


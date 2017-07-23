from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


def get_page():
    driver = webdriver.Chrome(".\\graber\\chromedriver")
    driver.get(input('the website you want to surf or grab\n'))
    return driver.page_source


def get_driver():
    return webdriver.Chrome(".\\graber\\chromedriver")


'''
def login_weibo_get_driver():
    driver = get_driver()
    driver.get("http://weibo.com")
    return driver
'''


def __init__():
    if __name__ == '__main__':
        print('main program')
    else:
        print('invoke successfully')


'''
try:
    element = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "myDynamicElement"))
    )
finally:
    driver.quit()
'''

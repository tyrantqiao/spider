import requests
from http.cookiejar import LWPCookieJar
import os

headers = {
    'Cache-Control': 'no-cache, must-revalidate',
    'Connection': 'keep-alive',
    'Content-Type': 'text/html',
    'DPOOL_HEADER': 'dryad24',
    'Date': 'Wed, 12 Jul 2017 14:06:05 GMT',
    'Expires': 'Sat, 26 Jul 1997 05:00:00 GMT',
    'Pragma': 'no-cache',
    'SINA-LB': 'aGEuOTEuZzEucXhnLmxiLnNpbmFub2RlLmNvbQ==',
    'SINA-TS': 'ZTljYTk0Y2UgMCAwIDAgMyA0Cg==',
    'Server': 'nginx/1.6.1',
    'Transfer-Encoding': 'chunked',
    'Vary': 'Accept-Encoding'
}

s = requests.Session()
s.headers.update(headers)
html = s.get('https://passport.weibo.cn/signin/login')
print(html.text)


def login_weibo():
    s = requests.Session()
    s.cookies = LWPCookieJar('../graber/cookies/weibo_cookie')
    if not os.path.exists('../graber/cookies/weibo_cookie'):
        # Create a new cookies file and set our Session's cookies
        print('need login first')
        account = input('your account\n')
        password = input('your password\n')
        html = s.get('https://passport.weibo.cn/signin/login')
        print(html.text)
        s.cookies.save()
    else:
        # Load saved cookies from the file and use them in a request
        print('loading saved cookies')
        s.cookies.load(ignore_discard=True)
        r = s.get('http://httpbin.org/cookies')

import requests
from worm.tools.fileio import save_text
from worm.tools.make import build_url
from worm.tools.make import make_json
from worm.tools.make import make_headers

URL_GITHUB = 'https://api.github.com'

url_grab = build_url(URL_GITHUB, 'users/imoocdemo')

# headers = make_headers('''GET /users/tyrantqiao HTTP/1.1
# Host: api.github.com
# Connection: keep-alive
# Cache-Control: max-age=0
# Upgrade-Insecure-Requests: 1
# User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36
# Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
# DNT: 1
# Accept-Encoding: gzip, deflate, sdch, br
# Accept-Language: zh-CN,zh;q=0.8
# ''')
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36',
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8', 'DNT': '1',
    'Accept-Encoding': 'gzip, deflate, sdch, br'}
response = requests.get(url_grab, auth=('tyrantqiao@icloud.com', 'KEnanSHUAI1'),
                        headers=headers)

save_text(response.content)

json_str = make_json(response.text)
print(json_str)
print(response.status_code)
# print(response.headers)

import json
import re


def build_url(url, end_point):
    return '/'.join([url, end_point])


def make_json(text):
    return json.dumps(json.loads(text), indent=4)


def make_headers(original_headers):
    original_headers.strip(' ')
    json_headers = dict()
    key_matches = re.findall('(.*):', original_headers)
    value_matches = re.findall(': (.*)[\n$ ]', original_headers)

    for i in range(key_matches.__len__()):
        # print(i)
        i -= 1
        json_headers.update({key_matches[i]: value_matches[i]})

    return json_headers
    # return json.dumps(json.load(json_headers), indent=4)


# print(make_headers('''GET /users/tyrantqiao HTTP/1.1
# Host: api.github.com
# Connection: keep-alive
# Cache-Control: max-age=0
# Upgrade-Insecure-Requests: 1
# User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36
# Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
# DNT: 1
# Accept-Encoding: gzip, deflate, sdch, br
# Accept-Language: zh-CN,zh;q=0.8
# '''))

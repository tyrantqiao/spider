import re

text = '''<a href="/users/22656/jon-skeet"><div class="gravatar-wrapper-48">
<img src="https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=48&amp;d=identicon&amp;r=PG" 
alt="" width="48" height="48"></div></a>    
'''

# print(text)
url_search = re.search('src="(.*)"', text, re.M | re.I)
# url_match = re.fullmatch('<a href="(.*)" alt', text, re.M | re.I)
print(url_search.group())
# print(url_match.groups())
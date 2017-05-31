import re
from urllib.request import urlretrieve
from worm.fileio import save_text

with open('.\\graber\\users.out', 'r', encoding='UTF-8') as users_obj:
    # print(users_obj)
    html_list = users_obj.readlines()
    # print(type(html_str))
    html_str = "".join(html_list)
    # print(type(html_str))
    # print(html_str)

    image_matches = re.findall('<img src="(https://www.gravatar.*)" alt', html_str, re.M | re.I)
    index = 0
    for image_match in image_matches:
        index += 1
        print(image_match)
        urlretrieve(image_match, './graber/image/user' + str(index) + '.jpg')

        # image_urls_text = '''stackoverflow's users' image url:\n '''
        # for image_match in image_matches:
        #     image_urls_text = image_urls_text + image_match +'\n'
        # print(image_urls_text)

        # save_text(image_urls_text, './graber/imageURL.txt')
        # savefile(image_text.encode('UTF-8'),'image_url')

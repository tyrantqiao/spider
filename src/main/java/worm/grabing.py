from worm.fileio import savefile
import requests

url = 'https://stackoverflow.com/users'
response = requests.get(url)
bytes_html = response.text.encode('UTF-8')
savefile(bytes_html, '.\\graber\\users.out')

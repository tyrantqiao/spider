import chardet
import os


def save_text(text, path='./'+input('file name\n')):
    print(chardet.detect(text))
    print(path)
    save_path = path
    file_obj = open(save_path, 'wb')
    file_obj.write(text)
    file_obj.close()
    print('done')


def file_is_empty(path):
    return os.stat(path).st_size == 0


def __init__():
    if __name__ == '__main__':
        print('main program')
    else:
        print('invoke successfully')

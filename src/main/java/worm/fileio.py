def save_text(text, path='.\\graber\\file.out'):
    save_path = path
    data = text.encode('UTF-8')
    file_obj = open(save_path, 'wb')
    file_obj.write(data)
    file_obj.close()
    print('done')


def __init__():
    if __name__ == '__main__':
        print('main program')
    else:
        print('invoke successfully')

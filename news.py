import xml.etree.ElementTree as ET

file_path = "news.xml"

# создание ElementTree и чтение XML файла
tree = ET.parse('news.xml')
root = tree.getroot()

for item in root.iter("item"):
    # извлечение данных из элементов
    title = item.findtext("title")
    description = item.findtext("description")
    pub_date = item.findtext("pubDate")
    author = item.findtext("author")
    category = item.findtext("category")

    print("Заголовок статьи :", title)
    print("Описание статьи:", description)
    print("Дата публикации статьи :", pub_date)
    print("Автор данной статьи :", author)
    print("Категория статьи :", category)
    print()

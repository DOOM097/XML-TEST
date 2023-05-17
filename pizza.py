import xml.etree.ElementTree as ET

tree = ET.parse('pizza_recipes.xml')
root = tree.getroot()

for pizza in root.findall('pizza'):
    title = pizza.find("title").text
    print(title)
    for i in pizza.find("ingredients"):
        print(i.get("title"), i.get("amount"))
    for s in pizza.find("steps"):
        print(s.text)
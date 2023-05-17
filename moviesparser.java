import org.w3c.dom.*; 
//Библиотека для работы с объектной моделью документа (DOM) XML.

import org.xml.sax.SAXException; 
//Библиотека для обработки SAX (Simple API for XML) XML.

import javax.xml.parsers.*; 
//Библиотека для создания объектов, отвечающих за разбор XML-документов.

import java.io.*; 
//Библиотека для работы с потоками ввода-вывода, используется для чтения и записи данных.


public class moviesparser {
    public static void main(String[] args) {
        try {
        // cоздаем парсер
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // загружаем хмл файл
            File xmlFile = new File("movies.xml");
            Document document = builder.parse(xmlFile);

//создает файл хтмл в который будет записоваться данные из нашего хмл документа 
            File htmlFile = new File("movie.html");
            FileWriter fileWriter = new FileWriter(htmlFile);
            BufferedWriter htmlWriter = new BufferedWriter(fileWriter);


    // получаем список элементов муви из хмл
            NodeList movieList = document.getElementsByTagName("movie");

        // итерация муви (проходимся по каждому атрибуту муви и сохраняем их для дальнейших действий )
            for (int i = 0; i < movieList.getLength(); i++) {
                Node movieNode = movieList.item(i);
                if (movieNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element movieElement = (Element) movieNode;

                       // переписывает атрибуты муви
                    String title = movieElement.getAttribute("title");
                    htmlWriter.write("<h2>Film " + (i + 1) + "</h2>");
                    htmlWriter.write("<p>Title: " + title + "</p>");

                    String year = movieElement.getAttribute("year");
                    htmlWriter.write("<p>Year: " + year + "</p>");

                    String director = movieElement.getAttribute("director");
                    htmlWriter.write("<p>Director: " + director + "</p>");

                    String plot = movieElement.getAttribute("plot");
                    htmlWriter.write("<p>Plot: " + plot + "</p>");
                }
            }
            htmlWriter.close();
            //обрабатывает исключения, именно тут про конфигурацию хмл документов, обработка sax-событий и ошибка ввода вывода 
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

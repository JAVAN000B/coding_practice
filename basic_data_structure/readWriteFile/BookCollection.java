package readWriteFile;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.xml.sax.SAXException;

// you need to import some xml libraries

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

// import any standard library if needed

/**
 * A book collection holds 0 or more books in a collection.
 */
public class BookCollection {
    private List<Book> books;

    /**
     * Creates a new collection with no books by default.
     */
    public BookCollection() {
        this.books = new ArrayList<Book>();
    }

    /**
     * Creates a new book collection with the specified list of books pre-defined.
     *
     * @param books A books list.
     */
    public BookCollection(List<Book> books) {
        this.books = books;
    }

    /**
     * Returns the current list of books stored by this collection.
     *
     * @return A (mutable) list of books.
     */
    public List<Book> getList() {
        return books;
    }

    /**
     * Sets the list of books in this collection to the specified value.
     */
    public void setList(List<Book> books) {
        this.books = books;
    }

    /**
     * A simple human-readable toString implementation. Not particularly useful to
     * save to disk.
     *
     * @return A human-readable string for printing
     */
    @Override
    public String toString() {
        return this.books.stream().map(book -> " - " + book.display() + "\n").collect(Collectors.joining());
    }

    /**
     * Saves this collection to the specified "bespoke" file.
     *
     * @param file The path to a file.
     */
    public void saveToBespokeFile(File file) {
        // TODO: Implement this function yourself. The specific hierarchy is up to you,
        // but it must be in a bespoke format and should match the
        // load function.
        int total = this.books.size();
        int i = 0;
        StringBuffer sb = new StringBuffer();
        while (i<total){
            sb.append(books.get(i).title+",");
            sb.append(books.get(i).authorName+",");
            sb.append(books.get(i).yearReleased+",");
            sb.append(books.get(i).bookGenre);
            sb.append("\r\n");
            i++;
        }
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getName(), true);
            fileWriter.write(sb.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Saves this collection to the specified JSON file.
     *
     * @param file The path to a file.
     */
    public void saveToJSONFile(File file) {
        // TODO: Implement this function yourself. The specific hierarchy is up to you,
        // but it must be in a JSON format and should match the load function.
        String json = new Gson().toJson(this);
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getName(), true);
            fileWriter.write(json);

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves this collection to the specified XML file.
     *
     * @param file The path to a file.
     */
    public void saveToXMLFile(File file) {
        // TODO: Implement this function yourself. The specific hierarchy is up to you,
        // but it must be in an XML format and should match the
        // load function.
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.newDocument();
            Element root = doc.getDocumentElement();
            root = doc.createElement("books");

            int total = this.books.size();
            int i = 0;
            while (i<total){
                Element title = doc.createElement("title");
                Element authorName = doc.createElement("authorName");
                Element yearReleased = doc.createElement("yearReleased");
                Element bookGenre = doc.createElement("bookGenre");
                Element book = doc.createElement("book");
                title.setTextContent(books.get(i).title);
                authorName.setTextContent(books.get(i).authorName);
                yearReleased.setTextContent(String.valueOf(books.get(i).yearReleased));
                bookGenre.setTextContent(String.valueOf(books.get(i).bookGenre));
                book.appendChild(title);
                book.appendChild(authorName);
                book.appendChild(yearReleased);
                book.appendChild(bookGenre);
                root.appendChild(book);
                i++;
            }
            doc.appendChild(root);
            TransformerFactory transformerFactory=TransformerFactory.newInstance();
            try {
                Transformer tf=transformerFactory.newTransformer();
                tf.setOutputProperty(OutputKeys.INDENT, "yes");
                tf.transform(new DOMSource(doc),
                        new StreamResult(file) );
            } catch (TransformerException e) {
                e.printStackTrace();
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    /**
     * Load a pre-existing book collection from a "bespoke" file.
     *
     * @param file The file to load from. This is guaranteed to exist.
     * @return An initialised book collection.
     */
    public static BookCollection loadFromBespokeFile(File file) {
        // TODO: Implement this function yourself.
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        BookCollection bc = new BookCollection();
        while (true) {
            try {
                assert br != null;
                if (((line = br.readLine()) == null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] splits = line.split(",");
            Book book = new Book();
            book.title = splits[0];
            book.yearReleased = Integer.parseInt(splits[splits.length - 2]);
            String bgString = splits[splits.length-1];
            if (bgString.equals("FICTION_COMEDY"))book.bookGenre = BookGenre.FICTION_COMEDY;
            if (bgString.equals("FICTION_ACTION"))book.bookGenre = BookGenre.FICTION_ACTION;
            if (bgString.equals("FICTION_FANTASY"))book.bookGenre = BookGenre.FICTION_FANTASY;
            if (bgString.equals("NON_FICTION"))book.bookGenre = BookGenre.NON_FICTION;
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < splits.length-2; ++i) {
                sb.append(splits[i]+",");
            }
            int sbLength = sb.length();
            book.authorName = sb.substring(0,sbLength-1);
            bc.books.add(book);
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bc;
    }

    /**
     * Load a pre-existing book collection from a JSON file.
     *
     * @param file The file to load from. This is guaranteed to exist.
     * @return An initialised book collection.
     */
    public static BookCollection loadFromJSONFile(File file) {
        // TODO: Implement this function yourself.

        BufferedReader reader = null;
        BookCollection bc =new BookCollection();
        try {
            reader = new BufferedReader(new FileReader(file));
            Gson gson = new GsonBuilder().create();
            BookCollection bcs = gson.fromJson(reader, BookCollection.class);
             bc =bcs;
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bc;
    }

    /**
     * Load a pre-existing book collection from an XML file.
     *
     * @param file The file to load from. This is guaranteed to exist.
     * @return An initialised book collection.
     */
    public static BookCollection loadFromXMLFile(File file) {
        // TODO: Implement this function yourself.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        BookCollection bc = new BookCollection();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            Element root = doc.getDocumentElement();
            NodeList nodes = doc.getElementsByTagName("book");
            int total = nodes.getLength();
            for (int i = 0; i < total; i++) {
                Element book = (Element) nodes.item(i);
                NodeList attributes = book.getChildNodes();
                Book bookBook = new Book();
                bookBook.title = attributes.item(1).getTextContent();
                bookBook.authorName = attributes.item(3).getTextContent();
                bookBook.yearReleased = Integer.parseInt(attributes.item(5).getTextContent());
                String bgString = attributes.item(7).getTextContent();
                if (bgString.equals("FICTION_COMEDY"))bookBook.bookGenre = BookGenre.FICTION_COMEDY;
                if (bgString.equals("FICTION_ACTION"))bookBook.bookGenre = BookGenre.FICTION_ACTION;
                if (bgString.equals("FICTION_FANTASY"))bookBook.bookGenre = BookGenre.FICTION_FANTASY;
                if (bgString.equals("NON_FICTION"))bookBook.bookGenre = BookGenre.NON_FICTION;
                bc.books.add(bookBook);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return bc;
    }
}

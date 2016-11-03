package entity;

import entity.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2016-11-03T23:40:44")
@StaticMetamodel(Reader.class)
public class Reader_ extends Person_ {

    public static volatile ListAttribute<Reader, Book> books;

}
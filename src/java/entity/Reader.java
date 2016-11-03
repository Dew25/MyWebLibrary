/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jvm
 */
@Entity
public class Reader extends Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(orphanRemoval = true,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Book> books = new ArrayList<>();

    public Reader() {
    }

    public Reader(List<Book> books, String firstname, String lastname, String code) {
        super(firstname, lastname, code);
        this.books=books;
    }
    public Reader(Book book, String firstname, String lastname, String code) {
        super(firstname, lastname, code);
        this.addBook(book);
    }
    
    public Boolean isBook(Book book){
        Boolean isBook=false;
        for (Book addBooks : this.books) {
            if(addBooks.getIsbn().equals(book.getIsbn())){
               return isBook=true;
            }
        }
        return false;
    }
    
    public List<String> addBook(Book book){
        List<String> result = new ArrayList<>();
        result.add("false");
        result.add("");
        if(!this.isBook(book)){
            this.books.add(book);
            result.set(0, "true");
            result.set(1, "Книга добавлена");
            return result;
        }else{
            result.set(0, "false");
            result.set(1, "Такая книга есть в списке");
            return result;
        }
    }
    public void removeBook(Book book){
        for (int i = 0; i < this.books.size(); i++) {
            if(this.books.get(i).getIsbn().equals(book.getIsbn())){
                this.books.remove(i);
                break;
            }
            
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reader)) {
            return false;
        }
        Reader other = (Reader) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    private String strFromList(List list){
        String strBooks="";
        for (int i = 0; i < list.size(); i++) {
            strBooks+=list.get(i).toString()+" ";
        }
        return strBooks;
    }
    @Override
    public String toString() {
//        String strBooks="";
//        for (int i = 0; i < this.books.size(); i++) {
//            strBooks+=this.books.get(i)+" ";
//        }
        String strBooks=strFromList(this.books);
        return "Reader{" + "id=" + id + ", books=" + strBooks + '}';
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

   
    
}

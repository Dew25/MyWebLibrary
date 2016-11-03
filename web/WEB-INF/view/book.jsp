<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:forEach var="book" items="${books}">
<div id="container">
    <div id="book-view">
        <h2>Информация о книге</h2>
        <div id="book-title">
            Название книги:<br>
            <input type="text" id="book-title" alt="Название книги" value="${book.title}">
        </div>
        <div id="book-title">
            Автор книги:<br>
            <input type="text" id="book-author" alt="Автор книги" value="${book.author}">
        </div>
        <div id="book-isbn">
            ISBN:<br>
            <input type="text" id="book-isbn" alt="ISBN" value="${book.isbn}">
        </div>
        <div id="buttons">
            <input type="button" id="book-button-add" value="Добавить">
            <input type="button" id="book-button-delete" value="Удалить">
        </div>
    </div>
</div> 
</c:forEach>
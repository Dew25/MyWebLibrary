<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div id="container">
            <div id="readers">
                Читатель:
                <select id="readers-list">
                    <option value="#">Вибери читателя</option>
                    <c:forEach var="reader" items="${readers}">
                        <option value="book?reader_id=${reader.id}">${reader.firstname} ${reader.lastname}</option>          
                    </c:forEach>
                    
                </select>
            </div>
<!--            <div id="books">
                Книги:<br>
                <select id="books-list" size="5">
                    
                    <option value="#"></option>
                </select>
            </div>-->
        </div>


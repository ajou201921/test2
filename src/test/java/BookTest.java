import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BookTest{

    @Test   //김훈민
    public void 책의_첫글자가_대문자인가(){
        UsefulCalculator book = new UsefulCalculator();
        Book book1 = new Book(1,"Kin","we");
        Book book2 = new Book(2,"hun","GE");

        assertTrue(book.UpperCaseCharacter(book1.getTitle()));
        assertFalse(book.UpperCaseCharacter(book2.getTitle()));
    }

    @Test //김훈민
    public void 책의_작가를_출력하는가()
    {
        UsefulCalculator book = new UsefulCalculator();
        Book book1 = new Book(1,"Kin","we");
        Book book2 = new Book(2,"hun","GE");

        assertThat(book.what_is_book_author(book1),is("we"));
        assertThat(book.what_is_book_author(book2),is("GE"));
    }

    @Test //김훈민
    public void 책에_value를_임의로_넣었을때_그_값이_제대로_들어가있고_그_값을_리턴하는가(){
        Book book = mock(Book.class);
        when(book.getTitle()).thenReturn("kin");
        assertThat(book.getTitle(), Is.is("kin"));

        when(book.getAuthor()).thenReturn("kye");
        assertThat(book.getAuthor(), Is.is("kye"));

        when(book.getNum()).thenReturn(1);
        assertThat(book.getNum(), Is.is(1));
    }

    @Test //황수진 method 1
    public void 북리스트사이즈테스트(){
        List<Book> books =new ArrayList<Book>();
        books.add(new Book(1234,"HarryPotter 1","J.K"));
        books.add(new Book(1235,"HarryPotter 2","J.K"));
        books.add(new Book(1236,"HarryPotter 3 ","J.K"));
        assertThat(books.size(),is(3));
    }

    @Test //황수진 method2
    public void Timeout테스트(){

        Book book = mock(Book.class);
        book.setTitle("Harry Potter");
        verify(book, timeout(100).atLeast(1)).setTitle(anyString());
    }

    @Test //황수진 method3
    public void 도서관리숫자(){

        List<Book> books =new ArrayList<Book>();
        List<Book> books_1200 =new ArrayList<Book>();

        books.add(new Book(1000,"HarryPotter Story","J.K"));
        books.add(new Book(1235,"HarryPotter 1","J.K"));
        books.add(new Book(1236,"HarryPotter 2 ","J.K"));

        for(int i=0;i<books.size();i++){
            if(books.get(i).getNum()>=1200){
                books_1200.add(books.get(i));
            }
        }
        assertTrue(books_1200.get(0).getNum()>=1200);
        assertTrue(books_1200.get(1).getNum()>=1200);

    }

    //수찬
    @Test(expected = IllegalArgumentException.class)
    public void 책번호를_음수로_저장하면_예외발생(){
        Book book=mock(Book.class);
        doThrow(new IllegalArgumentException()).when(book).setNum(-1);
        book.setNum(-1);
    }
    //수찬
    @Test
    public void 빈객체인지테스트(){
        List<Book>bookList=mock(List.class);
        assertThat(bookList.size(), Is.is(0));
    }


}
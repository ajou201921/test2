import org.hamcrest.core.Is;
import org.junit.Test;

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
}
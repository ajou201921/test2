public class UsefulCalculator {

    public Boolean UpperCaseCharacter(String str){
        return Character.isUpperCase(str.charAt(0));
    }

    public String what_is_book_author(Book book) {
        return book.getAuthor();
    }
}

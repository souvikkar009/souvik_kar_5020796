package com.olbs.controllers;



import com.olbs.dtos.BookDto;
import com.olbs.entities.Book;
import com.olbs.services.BookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = BookController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    
    private Book book;
    @SuppressWarnings("unused")
	private BookDto bookDto;

    @BeforeEach
    public void init() {
        book = Book.builder().title("My Book").author("Souvik").price(150).isbn("A12345").build();
        bookDto = BookDto.builder().title("My Book").author("Souvik").price(150).isbn("A12345").build();
    }

    @Test
    public void BookController_CreateBook_ReturnCreated() throws Exception {
        given(bookService.addBook(bookDto));

        ResultActions response = mockMvc.perform(post("books/"));

        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void BookController_GetAllBook_ReturnResponseDto() throws Exception {
        List<Book> books = new ArrayList<>();
        when(bookService.getAllBooks()).thenReturn(books);

        ResultActions response = mockMvc.perform(get("/"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void BookController_BookDetail_ReturnBookDto() throws Exception {
        int bookId = 1;
        when(bookService.getBookById(bookId)).thenReturn(book);

        ResultActions response = mockMvc.perform(get("/1"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void BookController_UpdateBookPrice_ReturnResponse() throws Exception {
        int bookId = 1;
        BookDto bookDto2 = BookDto.builder().title("My Book").author("Souvik").price(200).isbn("A12345").build();
        when(bookService.updateBookPrice(bookId, bookDto2.getPrice()));

        ResultActions response = mockMvc.perform(put("/1/update/price"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void BookController_DeleteBook_ReturnString() throws Exception {
        int bookId = 1;
        when(bookService.deleteBookById(bookId));

        ResultActions response = mockMvc.perform(delete("/1"));

        response.andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}


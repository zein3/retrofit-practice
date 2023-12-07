package net.zeinhaddad.perpustakaan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import net.zeinhaddad.perpustakaan.dto.BookDto;
import net.zeinhaddad.perpustakaan.rpc.JsonRpcRequest;
import net.zeinhaddad.perpustakaan.rpc.JsonRpcResponse;
import net.zeinhaddad.perpustakaan.service.BookService;

@RestController
public class JsonRpcController {
    @Autowired
    private BookService bookService;

    @PostMapping("/jsonrpc")
    public ResponseEntity<Object> handleJsonRpcRequest(@RequestBody JsonRpcRequest request) {
        try {
            String method = request.getMethod();
            JsonNode params = request.getParams();
            System.out.println("Method: " + method);
            
            switch(method) {
                case "createBook":
                    String title = params.get("title").asText();
                    String author = params.get("author").asText();
                    String description = params.get("description").asText();
                    BookDto book = BookDto.builder()
                        .title(title)
                        .description(description)
                        .author(author)
                        .build();

                    bookService.createBook(book);
                    return ResponseEntity.ok(new JsonRpcResponse("created", request.getId()));

                case "getBooks":
                    List<BookDto> books = bookService.getBooks();
                    return ResponseEntity.ok(new JsonRpcResponse(books, request.getId()));

                case "searchBooks":
                    String query = params.get("query").asText();
                    List<BookDto> results = bookService.searchBooks(query);
                    return ResponseEntity.ok(new JsonRpcResponse(results, request.getId()));
                
                default:
                    return ResponseEntity.badRequest().build();
            }
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

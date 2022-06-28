import axios from "axios";
import authHeader from "./authHeader";

const API_URL = "http://localhost:8080/api/books";

const saveBook = ({ bookName, summary, isbn, pageCount, categoryId }) => {
    return axios
        .post(API_URL, {
            bookName,
            summary,
            isbn,
            pageCount,
            categoryId,
        }, { headers: authHeader() });
}

const editBook = ({ bookId, bookName, summary, isbn, pageCount, categoryId }) => {
    return axios
        .put(API_URL + `/${bookId}`, {
            bookId,
            bookName,
            summary,
            isbn,
            pageCount,
            categoryId,
        }, { headers: authHeader() });
}

const deleteBook = (id) => {
    return axios
        .delete(API_URL + `/${id}`, {
            headers: authHeader()
        });
}

const getAllBooks = () => {
    return axios
        .get(API_URL, { headers: authHeader() })
}

export default {
    saveBook,
    deleteBook,
    editBook,
    getAllBooks
}
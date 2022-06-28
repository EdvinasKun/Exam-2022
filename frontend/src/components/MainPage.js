import React, { useEffect, useState } from "react";
import AuthService from "../services/AuthService";
import BookService from "../services/BookService";
import { Link } from "react-router-dom";

export default function MainPage() {

    const user = AuthService.getCurrentUser();
    const [noUser, setNoUser] = useState(true);
    const [books, setBooks] = useState([]);


    useEffect(() => {
        if (user === null) {
            setNoUser(true);
        } else {
            setNoUser(false);
        }
        BookService.getAllBooks().then((response) => {
            setBooks(response.data)
        })
    }, [])

    return (
        <>

            <div className="container mt-5">
                <div style={{ display: noUser ? "contents" : "none" }} className="forgot"><Link to={"/"}>P</Link></div>
                <div className="row row-cols-1 row-cols-md-3 g-4">
                    {books.map((book) => {
                        return (
                            <div className="col">
                                <div className="card h-200">
                                    <img src="" className="card-img-top" alt="Image" />
                                    {/* https://vaizdeliai.lt/_data/i/upload/2013/06/30/20130630195907-158e7594-me.png */}
                                    <div className="card-body">
                                        <h5 className="card-title">{book.bookName}</h5>
                                        <p className="card-text">{book.summary}</p>
                                    </div>
                                </div>
                            </div>
                        )
                    })}
                </div>
            </div>
        </>
    )
}
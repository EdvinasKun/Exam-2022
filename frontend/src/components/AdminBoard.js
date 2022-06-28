import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthService from "../services/AuthService";
import BookService from "../services/BookService";
import { useForm } from "react-hook-form";
import { v4 as uuid } from 'uuid';
import "./AdminBoard.css"
import DeleteBooks from "./editDeleteComponents/DeleteBooks";
import EditBooks from "./editDeleteComponents/EditBooks";

export default function AdminBoard() {

    const [books, setBooks] = useState([]);
    const {
        register,
        handleSubmit,
        formState: { errors } } = useForm({ mode: 'onSubmit', reValidateMode: 'onSubmit' });
    const user = AuthService.getCurrentUser();
    const navigate = useNavigate();
    const [forceRender, setForceRender] = useState(false);
    // a function to check if the user is an administrator
    useEffect(() => {
        if (user !== null) {
            if (!(user.roles.includes("ROLE_ADMIN"))) {
                console.log(user)
                alert("You are not an administrator!")
                navigate("/mainPage")
            }
        } else {
            navigate("/")
        }
    })

    // function to get all books
    useEffect(() => {
        BookService.getAllBooks().then((response) => {
            setBooks(response.data)
        })
    }, [forceRender])

    // submit function
    const onSubmit = data => {
        BookService.saveBook(data);
        setForceRender(!forceRender);
    }

    function refreshPage() {
        window.location.reload(false);
    }

    return (
        <div>

            {/* <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul> */}

            <div className="container-fluid">
                {/* <div><strong>Email: </strong>{user.email}</div>
                <div><strong>Id: </strong>{user.id}</div>
                <div>{user.username}</div>
                <div>{user.roles}</div> */}

                <h4 className="af_name container">Pridėti knygą:</h4>

                <div className="container">
                    <div className="row justify-content-center">
                        <div className="col-lg-12 col-11 px-0 ">
                            <div className="form-container mt-0 px-0">
                                <form className="form-horizontal" onSubmit={handleSubmit(onSubmit)}>
                                    <div className="row">
                                    <div className="form-group col-4">
                                            {/* <FontAwesomeIcon icon={faUser} className="cf-icon" /> */}

                                            <input {...register("bookName", { required: true })} type="text" className="form-control p-0" placeholder="Pavadinimas" />
                                            {errors?.businessName?.type === "required" && <p className="login_error_message">Įveskite pavadinimą</p>}

                                        </div>
                                        <div className="form-group col-4">
                                            {/* <FontAwesomeIcon icon={faUser} className="cf-icon" /> */}

                                            <input {...register("bookSummary", { required: true })} type="text" className="form-control p-0" placeholder="Santrauka" />
                                            {errors?.businessName?.type === "required" && <p className="login_error_message">Įveskite santrauką</p>}

                                        </div>
                                        <div className="form-group col-4">
                                            {/* <FontAwesomeIcon icon={faLock} className="cf-icon" /> */}

                                            <input {...register("isbn", { required: true })} type="text" className="form-control p-0" placeholder="ISBN" />
                                            {errors?.address?.type === "required" && <p className="login_error_message">Įveskite ISBN</p>}
                                            {/* {message && message} */}
                                        </div>
                                        {/* <div className="form-group col-4">
                                           

                                            <input {...register("address", { required: true })} type="text" className="form-control p-0" placeholder="ISBN" />
                                            {errors?.address?.type === "required" && <p className="login_error_message">Įveskite ISBN</p>}
                                            
                                        </div> */}
                                        <div className="form-group col-4">
                                            {/* <FontAwesomeIcon icon={faUser} className="cf-icon" /> */}
                                            <input {...register("pageCount", { required: true })} type="number" className="form-control p-0" placeholder="Puslapių skaičius" />
                                            {errors?.codeName?.type === "required" && <p className="login_error_message">Įveskite puslapių skaičių</p>}

                                        </div>
                                        <div className="form-group col-4">
                                            {/* <FontAwesomeIcon icon={faUser} className="cf-icon" /> */}
                                            <input {...register("categoryId", { required: true })} type="number" className="form-control p-0" placeholder="1" />
                                            {errors?.codeName?.type === "required" && <p className="login_error_message">Įveskite kategorijos numeri</p>}

                                        </div>
                                    </div>
                                    <div className="row">
                                        <button type="submit" className="btn signin" >Pridėti</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <table className="table table-striped container">
                    <tbody>
                        {books.map((book) => {
                            return (
                                <tr key={book.bookId + uuid()}>
                                    <td>{book.bookName}</td>
                                    <td>{book.bookSummary}</td>
                                    <td>{book.isbn}</td>
                                    <td>{book.pageCount}</td>
                                    <td>{book.categoryId}</td>
                                    <td>
                                        <DeleteBooks
                                        onClick={() => {setForceRender(!forceRender); console.log("something")}}
                                            id={book.id} 
                                            
                                            
                                            />
                                        <EditBooks
                                            bookId={book.bookId}
                                            bookName={book.bookName}
                                            bookSummary={book.bookSummary}
                                            isbn={book.isbn}
                                            pageCount={book.pageCount}
                                            categoryId={book.categoryId}
                                            forceRender={forceRender}
                                            setForceRender={setForceRender}
                                             />
                                            
                                    </td>
                                    {/* <div className="col-12">
                                        
                                    </div> */}
                                </tr>
                            )
                        })}
                    </tbody>
                </table>

            </div >

        </div >
    )
}
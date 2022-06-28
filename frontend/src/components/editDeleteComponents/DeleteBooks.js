import React from "react";
import { useState } from "react";
import BooksService from "../../services/BookService";

export default function DeleteBooks(props) {
    const [forceRender, setForceRender] = useState(false);

    function deleteBooks() {
        BooksService.deleteBooks(props.id);
        console.log(props.id);
        // setForceRender(!forceRender);
    }

    return (
        <>
            <button className="btn btn-danger mr-2" onClick={() => {setForceRender(!forceRender); console.log("something"); deleteBooks()}}>Delete</button>
        </>
    )
}
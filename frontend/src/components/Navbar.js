import React from "react";
import "./Navbar.css"
import { NavLink } from "react-router-dom";

export default function Navbar() {

    return (
        <>
            <div className="topnav">
                <NavLink to={"/mainPage"}><div className="bookName">BookReserve</div></NavLink>
                <input type="text" placeholder="Search.." className="col-4" />
            </div>
        </>
    )
}
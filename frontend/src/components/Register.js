import React, { useState } from "react";
import { useForm } from "react-hook-form"
import { useNavigate } from "react-router-dom";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLock, faUser, faEyeSlash, faEye } from '@fortawesome/free-solid-svg-icons';
import AuthService from "../services/AuthService";
import "./LoginRegister.css";
import { Link } from "react-router-dom";

export default function Registration() {
    const { register, handleSubmit, formState: { errors } } = useForm({ mode: 'onSubmit', reValidateMode: 'onSubmit' });
    const [passwordShown, setPasswordShown] = useState(false);
    const navigate = useNavigate();

    const onSubmit = data => {
        AuthService.register(data)
            .then(() => {

                navigate("/")
                alert("Successfully registered!")
                console.log("Successfully registered");
            })
    };

    // password visibility toggle
    const togglePassword = (e) => {
        setPasswordShown(!passwordShown);
        e.preventDefault();
    }

    return (
        <>
            <div className="container-fluid login_bg_color">
                <div className="row justify-content-center">
                    <div className="col-lg-4 col-md-5 col-sm-8 col-xs-8">
                        <div className="form-container" id="form_bg">
                            <div style={{ color: "white", marginBottom: "1rem" }}><strong>Knygų rezervavimo aplikacija</strong></div>

                            <form className="form-horizontal" onSubmit={handleSubmit(onSubmit)}>

                                <h4 className="form_name">Registracija</h4>
                                <div className="form-group">
                                    <FontAwesomeIcon icon={faUser} className="input-icon" />
                                    <input {...register("username", { required: true })} type="username" className="form-control" placeholder="Slapyvardis" />
                                    {errors?.username?.type === "required" && <p className="login_error_message">Įveskite slapyvardį</p>}
                                </div>

                                <div className="form-group">
                                    <FontAwesomeIcon icon={faUser} className="input-icon" />
                                    <input {...register("email", { required: true })} type="email" className="form-control" placeholder="El. paštas" />
                                    {errors?.email?.type === "required" && <p className="login_error_message">Įveskite el. paštą</p>}
                                </div>

                                <div className="form-group">
                                    <FontAwesomeIcon icon={faLock} className="input-icon" />
                                    <button onClick={togglePassword} className="password-show-icon btn">{passwordShown ? <FontAwesomeIcon icon={faEye} /> : <FontAwesomeIcon icon={faEyeSlash} />}</button>

                                    <input {...register("password", { required: true })} type={passwordShown ? "text" : "password"} className="form-control" placeholder="Slaptažodis" />
                                    {errors?.password?.type === "required" && <p className="login_error_message">Įveskite slaptažodį</p>}
                                    {/* {message && message} */}

                                    <span className="forgot">Jau užsiregistravę? <Link to={"/"}>Prisijunkite</Link></span>
                                </div>
                                <button type="submit" className="btn signin">Registruotis</button>

                            </form>
                        </div>
                    </div>
                </div>
            </div >
        </>
    )

}
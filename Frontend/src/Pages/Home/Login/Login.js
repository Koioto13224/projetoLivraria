import "bootstrap/dist/css/bootstrap.min.css";
import "./Login.css"

import useForm from "Hooks/useForm";

import { useNavigate } from 'react-router-dom';


export default function Login() {
  const navegar = useNavigate()

  const {
    handleChange, 
    handleSubmit,
    errors,
    formData
  } = useForm()

  return (
    <form className="form" onSubmit={handleSubmit}>
      <div className="form-outline mb-4">
        <label className="form-label" htmlFor="name">
          Nome
        </label>
        <input
          type="text"
          id="name"
          className={`form-control ${errors.name ? "is-invalid" : ""}`}
          value={formData.name}
          onChange={handleChange}
        />
        {errors.name && <div className="invalid-feedback">{errors.name}</div>}
      </div>
      <div className="form-outline mb-4">
        <label className="form-label" htmlFor="email">
          Email
        </label>
        <input
          type="email"
          id="email"
          className={`form-control ${errors.email ? "is-invalid" : ""}`}
          value={formData.email}
          onChange={handleChange}
        />
        {errors.email && <div className="invalid-feedback">{errors.email}</div>}
      </div>
      <div className="form-outline mb-4">
        <label className="form-label" htmlFor="password">
          Senha
        </label>
        <input
          type="password"
          id="password"
          className={`form-control ${errors.password ? "is-invalid" : ""}`}
          value={formData.password}
          onChange={handleChange}
        />
        {errors.password && <div className="invalid-feedback">{errors.password}</div>}
      </div>
      <div className="form-outline mb-4">
        <label className="form-label" htmlFor="birthDate">
          Data de Nascimento
        </label>
        <input
          type="date"
          id="birthDate"
          className={`form-control ${errors.birthDate ? "is-invalid" : ""}`}
          value={formData.birthDate}
          onChange={handleChange}
        />
        {errors.birthDate && <div className="invalid-feedback">{errors.birthDate}</div>}
      </div>
      <div className="form-outline mb-4">
        <label className="form-label" htmlFor="cep">
          CEP
        </label>
        <input
          type="text"
          id="cep"
          className={`form-control ${errors.cep ? "is-invalid" : ""}`}
          value={formData.cep}
          onChange={handleChange}
        />
        {errors.cep && <div className="invalid-feedback">{errors.cep}</div>}
      </div>

      <div className="form-outline mb-4">
        <label className="form-label" htmlFor="street">
          Rua
        </label>
        <input
          type="text"
          id="street"
          className={`form-control ${errors.street ? "is-invalid" : ""}`}
          value={formData.street}
          onChange={handleChange}
        />
        {errors.street && <div className="invalid-feedback">{errors.street}</div>}
      </div>

      <div className="form-outline mb-4">
        <label className="form-label" htmlFor="logradouro">
          Logradouro
        </label>
        <input
          type="text"
          id="logradouro"
          className={`form-control ${errors.logradouro ? "is-invalid" : ""}`}
          value={formData.logradouro}
          onChange={handleChange}
        />
        {errors.logradouro && (
          <div className="invalid-feedback">{errors.logradouro}</div>
        )}
      </div>

      <div className="form-outline mb-4">
        <label className="form-label" htmlFor="city">
          Cidade
        </label>
        <input
          type="text"
          id="city"
          className={`form-control ${errors.city ? "is-invalid" : ""}`}
          value={formData.city}
          onChange={handleChange}
        />
        {errors.city && <div className="invalid-feedback">{errors.city}</div>}
      </div>

      {/* Submit Button */}
      <button type="submit" className="btn btn-primary btn-block mb-4">
        Register
      </button>
    </form>
  );
}

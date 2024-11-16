import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from 'react-router-dom';

export default function Login() {
    const navegar = useNavigate()

    function irParaTabela(){
        navegar('/tabela')
    }

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        password: "",
        birthDate: "",
        cep: "",
        street: "",
        logradouro: "",
        city: "",
      });
    
      const [errors, setErrors] = useState({});
    
      const handleChange = (e) => {
        setFormData({ ...formData, [e.target.id]: e.target.value });
      };
    
      const validate = () => {
        const newErrors = {};
    
        if (!formData.name) newErrors.name = "Nome é obrigatório.";
        if (!formData.email) newErrors.email = "E-mail é obrigatório.";
        else if (!/\S+@\S+\.\S+/.test(formData.email))
          newErrors.email = "E-mail inválido.";
    
        if (!formData.password)
          newErrors.password = "Senha é obrigatória.";
        else if (formData.password.length < 6)
          newErrors.password = "A senha deve ter pelo menos 6 caracteres.";
    
        if (!formData.birthDate) newErrors.birthDate = "Data de nascimento é obrigatória.";
    
        if (!formData.cep) newErrors.cep = "CEP é obrigatório.";
        else if (!/^\d{5}-?\d{3}$/.test(formData.cep))
          newErrors.cep = "CEP inválido. Deve estar no formato 00000-000.";
    
        if (!formData.street) newErrors.street = "Rua é obrigatória.";
        if (!formData.logradouro) newErrors.logradouro = "Logradouro é obrigatório.";
        if (!formData.city) newErrors.city = "Cidade é obrigatória.";
    
        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
      };
    
      const handleSubmit = (e) => {
        e.preventDefault();
        if (validate()) {
          alert("Formulário enviado com sucesso!");
          console.log(formData);
        }
      };
    
      return (
        <form onSubmit={handleSubmit}>
          {/* Name Input */}
          <div className="form-outline mb-4">
            <input
              type="text"
              id="name"
              className={`form-control ${errors.name ? "is-invalid" : ""}`}
              value={formData.name}
              onChange={handleChange}
            />
            <label className="form-label" htmlFor="name">
              Nome
            </label>
            {errors.name && <div className="invalid-feedback">{errors.name}</div>}
          </div>
    
          {/* Email Input */}
          <div className="form-outline mb-4">
            <input
              type="email"
              id="email"
              className={`form-control ${errors.email ? "is-invalid" : ""}`}
              value={formData.email}
              onChange={handleChange}
            />
            <label className="form-label" htmlFor="email">
              Email
            </label>
            {errors.email && <div className="invalid-feedback">{errors.email}</div>}
          </div>
    
          {/* Password Input */}
          <div className="form-outline mb-4">
            <input
              type="password"
              id="password"
              className={`form-control ${errors.password ? "is-invalid" : ""}`}
              value={formData.password}
              onChange={handleChange}
            />
            <label className="form-label" htmlFor="password">
              Senha
            </label>
            {errors.password && <div className="invalid-feedback">{errors.password}</div>}
          </div>
    
          {/* Birth Date Input */}
          <div className="form-outline mb-4">
            <input
              type="date"
              id="birthDate"
              className={`form-control ${errors.birthDate ? "is-invalid" : ""}`}
              value={formData.birthDate}
              onChange={handleChange}
            />
            <label className="form-label" htmlFor="birthDate">
              Data de Nascimento
            </label>
            {errors.birthDate && <div className="invalid-feedback">{errors.birthDate}</div>}
          </div>
    
          {/* Address Section */}
          <div className="form-outline mb-4">
            <input
              type="text"
              id="cep"
              className={`form-control ${errors.cep ? "is-invalid" : ""}`}
              value={formData.cep}
              onChange={handleChange}
            />
            <label className="form-label" htmlFor="cep">
              CEP
            </label>
            {errors.cep && <div className="invalid-feedback">{errors.cep}</div>}
          </div>
    
          <div className="form-outline mb-4">
            <input
              type="text"
              id="street"
              className={`form-control ${errors.street ? "is-invalid" : ""}`}
              value={formData.street}
              onChange={handleChange}
            />
            <label className="form-label" htmlFor="street">
              Rua
            </label>
            {errors.street && <div className="invalid-feedback">{errors.street}</div>}
          </div>
    
          <div className="form-outline mb-4">
            <input
              type="text"
              id="logradouro"
              className={`form-control ${errors.logradouro ? "is-invalid" : ""}`}
              value={formData.logradouro}
              onChange={handleChange}
            />
            <label className="form-label" htmlFor="logradouro">
              Logradouro
            </label>
            {errors.logradouro && (
              <div className="invalid-feedback">{errors.logradouro}</div>
            )}
          </div>
    
          <div className="form-outline mb-4">
            <input
              type="text"
              id="city"
              className={`form-control ${errors.city ? "is-invalid" : ""}`}
              value={formData.city}
              onChange={handleChange}
            />
            <label className="form-label" htmlFor="city">
              Cidade
            </label>
            {errors.city && <div className="invalid-feedback">{errors.city}</div>}
          </div>
    
          {/* Submit Button */}
          <button onClick={irParaTabela} type="submit" className="btn btn-primary btn-block mb-4">
            Register
          </button>
        </form>
  );
}

import { useState } from "react"
import { useNavigate } from "react-router-dom";


export default function useForm() {
  const navigate = useNavigate()
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
  const goToTable = () => { navigate('/tabela') }

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
      goToTable()
      console.log(formData);
    }
  };

  return {
    handleChange,
    handleSubmit,
    formData,
    errors,
  }
}
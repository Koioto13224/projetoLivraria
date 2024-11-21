import useForm from 'Hooks/useForm'

import './SignIn.css'

import ArchiveSVG from 'Components/ArchiveSVG'

// import "bootstrap/dist/css/bootstrap.min.css"

export default function SignIn() {
  const { handleChange, handleSubmit, errors, formData } = useForm()

  return (
    <section className="signin-page col col-2">
      <form action="" className="form container" onSubmit={handleSubmit}>
        <h1 className="mb-1">Cadastro</h1>
        <p className="textGrey mb-4">
          Crie uma conta para uso pessoal e aproveite
        </p>
        <div className="col col-3 gap-1 mb-3">
          <fieldset className="inputGroup">
            <label htmlFor="" name className="label mb-1 textGrey">
              Nome
            </label>
            <input
              types="text"
              id="name"
              className={`input ${errors.name ? 'isInvalid' : ''}`}
              onChange={handleChange}
            />
            <small className="invalidFeedback">{errors.name}</small>
          </fieldset>
          <fieldset className="inputGroup">
            <label htmlFor="" className="label mb-1 textGrey">
              Data de nasc.
            </label>
            <input
              types="date"
              type='date'
              id="birthDate"
              placeholder="mm/dd/yyyy"
              className={`input ${errors.birthDate ? 'isInvalid' : ''}`}
              onChange={handleChange}
            />
            <small className="invalidFeedback">
              {errors.birthDate && 'Campo obrigatório'}
            </small>
          </fieldset>
          <fieldset className="inputGroup">
            <label htmlFor="" className="label mb-1 textGrey">
              CEP
            </label>
            <input
              types="text"
              placeholder='00000-000'
              id="cep"
              className={`input ${errors.cep ? 'isInvalid' : ''}`}
              onChange={handleChange}
            />
            <small className="invalidFeedback">
              {errors.cep && 'Campo obrigatório'}
            </small>
          </fieldset>
        </div>
        <div className="col col-2 gap-1 mb-3">
          <fieldset className="inputGroup">
            <label htmlFor="" className="label mb-1 textGrey">
              Email
            </label>
            <input
              types="email"
              id="email"
              className={`input w-full ${errors.email ? 'isInvalid' : ''}`}
              onChange={handleChange}
            />
            <small className="invalidFeedback">
              {errors.email && 'Campo obrigatório'}
            </small>
          </fieldset>
          <fieldset className="inputGroup">
            <label htmlFor="" className="label mb-1 textGrey">
              Senha
            </label>
            <input
              type="password"
              types="password"
              id="password"
              className={`input w-full ${errors.password ? 'isInvalid' : ''}`}
              onChange={handleChange}
            />
            <small className="invalidFeedback">
              {errors.password && 'Campo obrigatório'}
            </small>
          </fieldset>
        </div>
        <div className="col col-3 gap-1">
          <fieldset className="inputGroup">
            <label htmlFor="" className="label mb-1 textGrey">
              Rua
            </label>
            <input
              types="text"
              id="street"
              className={`input ${errors.street ? 'isInvalid' : ''}`}
              onChange={handleChange}
            />
          </fieldset>
          <fieldset className="inputGroup">
            <label htmlFor="" className="label mb-1 textGrey">
              Logradouro
            </label>
            <input
              types="text"
              id="logradouro"
              className={`input ${errors.logradouro ? 'isInvalid' : ''}`}
              onChange={handleChange}
            />
          </fieldset>
          <fieldset className="inputGroup">
            <label htmlFor="" className="label mb-1 textGrey">
              Cidade
            </label>
            <input
              types="text"
              id="city"
              className={`input ${errors.city ? 'isInvalid' : ''}`}
              onChange={handleChange}
            />
          </fieldset>
        </div>
        <button className="submit">
          <ArchiveSVG />
          Registrar
        </button>
      </form>
    </section>
  )
}

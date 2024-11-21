import React, { useCallback } from 'react'
import { useNavigate, useLocation } from 'react-router-dom'

import './Table.css'

import formatPriceInBRL from 'Utils/format-price-in-brl'

import useModal from 'Hooks/useModal'
import useBooks from 'Hooks/useBooks'
import useAddBook from 'Hooks/useAddBook'
import useTabManager from 'Hooks/useTabManager'
import useContextMenuManager from 'Hooks/useContextManager'
import useContextMenuForm from 'Hooks/useContextMenuForm'

import ECabecalho from 'Enums/ECabecalho'
import ETabs from 'Enums/ETabs'
import EBook from 'Enums/EBook'

import bookMocked from 'Mocks/bookMocked'
import AddCategoryOption from './AddCategoryOption'
import AddPublisherOption from './AddPublisherOption'

function TableRow({ id, categoria, descricao, preco, autor }) {
  const navigation = useNavigate()
  const location = useLocation()
  const modalRef = useModal()

  const handleOnClick = useCallback(() => {
    navigation(`?product_id=${id}`)
    if (modalRef.current) {
      modalRef.current.showModal()
    }
  }, [location.pathname])

  return (
    <tr>
      <td>{id}</td>
      <td>
        <span className="tagged">{categoria}</span>
      </td>
      <td>{descricao}</td>
      <td>{autor}</td>
      <td>{formatPriceInBRL(preco)}</td>
      <td>
        <button className="edit" onClick={handleOnClick}>
          Editar
        </button>
      </td>
    </tr>
  )
}

function PlusIcon() {
  return (
    <svg
      width="14"
      height="14"
      viewBox="0 0 12 12"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path d="M6 1L6 11" stroke="var(--color-white)" strokeLinecap="round" />
      <path d="M1 6L11 6" stroke="var(--color-white)" strokeLinecap="round" />
    </svg>
  )
}

const INITIAL_ADD_BOOK_FORM = {
  [EBook.AUTOR]: '',
  [EBook.CATEGORIA]: '',
  [EBook.DESCRICAO]: '',
  [EBook.PRECO]: '',
}

const CUSTOM_ERRORS = {
  [EBook.AUTOR]: [(value) => (!value ? 'Campo Obrigatório' : undefined)],
  [EBook.CATEGORIA]: [(value) => (!value ? 'Campo Obrigatório' : undefined)],
  [EBook.PRECO]: [
    (value) => (!value ? 'Campo Obrigatório' : undefined),
    (value) => (isNaN(value) ? 'Campo numérico' : undefined),
  ],
  [EBook.DESCRICAO]: (value) => (!value ? 'Campo Obrigatório' : undefined),
}

function AddBooksOption() {
  const [isOpen, setIsOpen] = useContextMenuManager(false)
  const addBook = useAddBook()
  const { formData, errors, resetFormData, handleChange, formIsValid } =
    useContextMenuForm({
      initialFormData: INITIAL_ADD_BOOK_FORM,
      customErrors: CUSTOM_ERRORS,
    })

  const handleButtonClick = useCallback((e) => {
    e.stopPropagation()

    setIsOpen(true)
  }, [])

  const handleOnSubmit = useCallback(
    (e) => {
      e.preventDefault()
      e.stopPropagation()

      if (formIsValid()) {
        addBook(formData)
        setIsOpen(false)
        resetFormData()
      } else {
      }
    },
    [addBook, formData, errors]
  )

  return (
    <div className="addBook row" onClick={handleButtonClick}>
      <div className={`contextMenu ${isOpen ? 'isActive' : ''}`}>
        <form onSubmit={handleOnSubmit}>
          <div className="col col-2 mb-1 gap-1">
            <fieldset>
              <label htmlFor="">Id</label>
              <input
                type="text"
                className="input"
                placeholder={bookMocked.id}
              />
            </fieldset>
            <fieldset>
              <label htmlFor="">Autor</label>
              <input
                onChange={handleChange}
                type="text"
                value={formData[EBook.AUTOR]}
                className={`input ${errors[EBook.AUTOR] ? 'isInvalid' : ''}`}
                id={EBook.AUTOR}
              />
              {errors[EBook.AUTOR] && (
                <small className="textRed">{errors[EBook.AUTOR]}</small>
              )}
            </fieldset>
          </div>
          <div className="col col-2 gap-1 mb-1">
            <fieldset>
              <label htmlFor="">Categoria</label>
              <input
                type="text"
                className={`input ${
                  errors[EBook.CATEGORIA] ? 'isInvalid' : ''
                }`}
                value={formData[EBook.CATEGORIA]}
                onChange={handleChange}
                id={EBook.CATEGORIA}
              />
              {errors[EBook.CATEGORIA] && (
                <small className="textRed">{errors[EBook.CATEGORIA]}</small>
              )}
            </fieldset>
            <fieldset>
              <label htmlFor="">Preço</label>
              <input
                type="text"
                className={`input ${errors[EBook.PRECO] ? 'isInvalid' : ''}`}
                value={formData[EBook.PRECO]}
                onChange={handleChange}
                id={EBook.PRECO}
              />
              {errors[EBook.PRECO] && (
                <small className="textRed">{errors[EBook.PRECO]}</small>
              )}
            </fieldset>
          </div>
          <fieldset>
            <label htmlFor="" className="label small">
              Descrição
            </label>
            <textarea
              className={`${errors[EBook.DESCRICAO] ? 'isInvalid' : ''}`}
              value={formData[EBook.DESCRICAO]}
              onChange={handleChange}
              id={EBook.DESCRICAO}
            ></textarea>
            {errors[EBook.DESCRICAO] && (
              <small className="textRed">{errors[EBook.DESCRICAO]}</small>
            )}
          </fieldset>
          <button type="submit" className="saveButton mt-3">
            Salvar
          </button>
        </form>
      </div>
      <PlusIcon />
      Adicionar livro
    </div>
  )
}

function Null() {
  return null
}

export default function Table() {
  const books = useBooks()
  const { tab, handleSwitchTab } = useTabManager()

  const RightOptions =
    tab === ETabs.BOOKS
      ? AddBooksOption
      : tab === ETabs.CATEGORIES
      ? AddCategoryOption
      : tab === ETabs.PUBLISHER
      ? AddPublisherOption
      : Null

  // console.log('RightOptions', <RightOptions />)

  return (
    <section className="tablePage container">
      <h1 className="mb-1">Produtos</h1>
      <p className="mb-3 textGrey">Alguns Livros do backend para exibição</p>
      <div className="options row">
        <ul className="left row">
          <li
            onClick={handleSwitchTab}
            className={`option ${tab === ETabs.BOOKS ? 'isActive' : ''}`}
            value={ETabs.BOOKS}
          >
            Livros
          </li>
          <li
            onClick={handleSwitchTab}
            className={`option  ${tab === ETabs.AUTHORS ? 'isActive' : ''}`}
            value={ETabs.AUTHORS}
          >
            Autores
          </li>
          <li
            onClick={handleSwitchTab}
            className={`option  ${tab === ETabs.CATEGORIES ? 'isActive' : ''}`}
            value={ETabs.CATEGORIES}
          >
            Categorias
          </li>
          <li
            onClick={handleSwitchTab}
            className={`option  ${tab === ETabs.PUBLISHER ? 'isActive' : ''}`}
            value={ETabs.PUBLISHER}
          >
            Editoras
          </li>
        </ul>
        <div className="right row">
          {/* <AddCategoryBooksOption /> */}
          <RightOptions />
        </div>
      </div>
      <table className="table">
        <thead className="head">
          <tr>
            <th>{ECabecalho.ID}</th>
            <th>{ECabecalho.CATEGORIA}</th>
            <th>{ECabecalho.DESCRICAO}</th>
            <th>{ECabecalho.AUTOR}</th>
            <th>{ECabecalho.PRECO}</th>
            <th>{ECabecalho.EDITAR}</th>
          </tr>
        </thead>
        <tbody>
          {books.length !== 0
            ? books.map((item) => (
                <TableRow {...item} key={`TableRow_${item.id}`} />
              ))
            : 'Carregando...'}
        </tbody>
      </table>
    </section>
  )
}

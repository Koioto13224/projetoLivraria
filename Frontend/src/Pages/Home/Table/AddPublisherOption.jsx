import { useCallback } from 'react'
import useContextMenuForm from 'Hooks/useContextMenuForm'
import useContextMenuManager from 'Hooks/useContextManager'

import PlusIcon from 'Components/PlusIcon'

import useAddCategory from 'Hooks/useAddCategory'
import useAddPublisher from "Hooks/useAddPublisher"
import useCategories from 'Hooks/useCategories'

const INITIAL_ADD_CATEGORY_FORM = {
  publisherName: ""
}

export default function AddPublisherOption() {
  const categories = useCategories()
  const [isOpen, setIsOpen] = useContextMenuManager(false)
  const { formData, errors, handleChange, formIsValid } = useContextMenuForm({
    initialFormData: INITIAL_ADD_CATEGORY_FORM,
    customErrors: {
      publisherName: [
        (value) => {
          return categories?.includes(value)
            ? 'Já existe essa categoria'
            : undefined
        },
        (value) => (!value ? 'Campo obrigatório' : undefined),
      ],
    },
  })

  const handleButtonClick = useCallback((e) => {
    e.stopPropagation()

    setIsOpen(true)
  }, [])

  const addPublisher = useAddPublisher()

  const handleWithSaveBook = useCallback(
    (e) => {
      e.preventDefault()
      e.stopPropagation()

      if (formIsValid()) {
        addPublisher(formData.publisherName)
        setIsOpen(false)
      }
    },
    [addPublisher, formData, errors]
  )

  return (
    <div className="btn row align-center gap-1" onClick={handleButtonClick}>
      <div className={`contextMenu ${isOpen ? 'isActive' : ''}`}>
        <form onSubmit={handleWithSaveBook}>
          <fieldset>
            <label htmlFor="">Nome da Editora</label>
            <input
              type="text"
              id="publisherName"
              className={`input ${errors.publisherName ? 'isInvalid' : ''}`}
              onChange={handleChange}
              placeholder="Nome da categoria"
            />
            {errors.publisherName && (
              <small className="textRed">{errors.publisherName}</small>
            )}
          </fieldset>
          <button type="submit" className="saveButton mt-3">
            Adicionar
          </button>
        </form>
      </div>
      <PlusIcon />
      Nova Editora
    </div>
  )
}

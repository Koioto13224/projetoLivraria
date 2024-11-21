import { useCallback } from 'react'
import useContextMenuForm from 'Hooks/useContextMenuForm'
import useContextMenuManager from 'Hooks/useContextManager'

import PlusIcon from 'Components/PlusIcon'

import useAddCategory from 'Hooks/useAddCategory'
import useCategories from 'Hooks/useCategories'

const INITIAL_ADD_CATEGORY_FORM = {
  categoryName: '',
}

export default function AddCategoryOption() {
  const categories = useCategories()
  const [isOpen, setIsOpen] = useContextMenuManager(false)
  const { formData, errors, handleChange, formIsValid } = useContextMenuForm({
    initialFormData: INITIAL_ADD_CATEGORY_FORM,
    customErrors: {
      categoryName: [
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

  const addCategory = useAddCategory()

  const handleWithSaveBook = useCallback(
    (e) => {
      e.preventDefault()
      e.stopPropagation()

      if (formIsValid()) {
        addCategory(formData.categoryName)
        setIsOpen(false)
      }
    },
    [addCategory, formData, errors]
  )

  return (
    <div className="btn row align-center gap-1" onClick={handleButtonClick}>
      <div className={`contextMenu ${isOpen ? 'isActive' : ''}`}>
        <form onSubmit={handleWithSaveBook}>
          <fieldset>
            <label htmlFor="">Categoria</label>
            <input
              type="text"
              id="categoryName"
              className={`input ${errors.categoryName ? 'isInvalid' : ''}`}
              onChange={handleChange}
              placeholder="Nome da categoria"
            />
            {errors.categoryName && (
              <small className="textRed">{errors.categoryName}</small>
            )}
          </fieldset>
          <button type="submit" className="saveButton mt-3">
            Adicionar
          </button>
        </form>
      </div>
      <PlusIcon />
      Nova Categoria
    </div>
  )
}

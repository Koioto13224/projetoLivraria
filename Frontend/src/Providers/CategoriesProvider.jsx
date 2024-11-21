import { useCallback, useState } from 'react'

import { CategoriesContext } from 'Contexts/CategoriesContext'
import { AddCategoryContext } from 'Contexts/AddCategoryContext'

import ECategoria from 'Enums/ECategoria'

const DEFAULT_CATEGORIES = Object.values(ECategoria)

export default function CategoriesProvider({ children }) {
  const [categories, setCategories] = useState(DEFAULT_CATEGORIES)

  const addCategory = useCallback(
    (newCategory) => {
      console.log(categories)
      if (!categories.includes(newCategory)) {
        setCategories([...categories, newCategory])
        return true
      }

      return false
    },
    [categories]
  )

  return (
    <CategoriesContext.Provider value={categories}>
      <AddCategoryContext.Provider value={addCategory}>
        {children}
      </AddCategoryContext.Provider>
    </CategoriesContext.Provider>
  )
}

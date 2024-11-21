import { useCallback, useEffect, useState } from 'react'

import { ProductsContext } from 'Contexts/ProductsContext'

import { UpdateProductContext } from 'Contexts/UpdateProduct'
import { AddBookContext } from 'Contexts/AddBookContext'

import BackendHttpClient from 'Httpclient/BackendHttpClient'

export default function ProductsProvider({ children }) {
  const [products, setBooks] = useState([])

  useEffect(() => {
    const abortController = new AbortController()
    const signal = abortController.signal

    async function getBooks() {
      try {
        const newBooks = await BackendHttpClient.getBooks({ signal })
        console.log("books inside useEffect in ProductsProvider: ", newBooks)

        setBooks(newBooks)
      } catch (error) {
        console.error(error)

        setBooks([])
      }
    }

    getBooks()

    return () => {
      abortController.abort()
    }
  }, [])

  const addBook = useCallback(
    (newProduct) => {
      const newBooks = [...products, newProduct]
      // console.log(newBooks)
      setBooks(newBooks)
    },
    [products]
  )

  const updateProduct = useCallback(
    (productId, product) => {
      const productIndex = products.findIndex((x) => x.id === productId)
      console.log('Product index:', productIndex)

      if (productId !== 1) {
        const updatedProducts = products
        updatedProducts[productIndex] = {
          ...products[productIndex],
          ...product,
        }

        setBooks(updatedProducts)
      }
      console.log('new products', products)
    },
    [products]
  )

  const removeProduct = useCallback(
    (productId) => {
      setBooks(products.filter((x) => x.id !== productId))
    },
    [products]
  )

  return (
    <ProductsContext.Provider value={products}>
      <AddBookContext.Provider value={addBook}>
        <UpdateProductContext.Provider value={updateProduct}>
          {children}
        </UpdateProductContext.Provider>
      </AddBookContext.Provider>
    </ProductsContext.Provider>
  )
}

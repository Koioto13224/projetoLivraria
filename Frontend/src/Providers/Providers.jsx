import ProductsProvider from './ProductsProvider'
import ModalRefProvider from './ModalRefProvider'
import { RouterProvider } from 'react-router-dom'

import routes from 'Pages/routes'
import CategoriesProvider from './CategoriesProvider'
import PublisherProvider from './PublisherProvider'

export default function Providers({ children }) {
  return (
    <ProductsProvider>
      <PublisherProvider>
        <CategoriesProvider>
          <ModalRefProvider>
            {children}
            <RouterProvider router={routes} />
          </ModalRefProvider>
        </CategoriesProvider>
      </PublisherProvider>
    </ProductsProvider>
  )
}

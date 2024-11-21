import useProducts from "Hooks/useBooks"
import { useEffect, useState } from "react"

import "./Modal.css"

import { useSearchParams } from "react-router-dom"
import useModal from "Hooks/useModal"
import useUpdateProduct from "Hooks/useUpdateProduct"

export default function Modal() {
  const modalRef = useModal()
  const products = useProducts()
  const updateProduct = useUpdateProduct()
  const [product, setProduct] = useState({})
  let [searchParams] = useSearchParams()

  useEffect(() => {
    if (products.length === 0 && modalRef.current) return

    const productId = Number(searchParams.get("product_id"))
    modalRef.current.showModal()

    setProduct(products.find(x => x.id === productId))
  }, [modalRef.current, searchParams])

  function handleOnCloseModal() {
    if (modalRef.current) {
      modalRef.current.close()
    }
  }

  function handleOnSaveChange() {
    updateProduct(1, { ...product, categoria: "Mudou" })
    if (modalRef.current) {
      modalRef.current.close()
    }
  }
  return (
    <dialog
      ref={modalRef}
      className="modal-product"
      onClose={handleOnCloseModal}
    >
      <h2>Produto</h2>
      <label className="form-label">Categoria</label>
      <select className="form-select" placeholder={product?.categoria ?? ""}>
        <option value="Frios">Frios</option>
      </select>
      <label>Descricao</label>
      <input className="form-control" placeholder={product?.descricao ?? ""} />
      <label className="form-label">Autor</label>
      <input className="form-control" placeholder={product?.autor ?? ""} />
      <label className="form-label">Preço</label>
      <input className="form-control" placeholder={product?.preco ?? ""} />
      <div className="d-flex">
        <button onClick={handleOnCloseModal} className="btn left">Descartar</button>
        <button onClick={handleOnSaveChange} className="btn btn-primary right">Salvar</button>
      </div>
    </dialog>
  )
}
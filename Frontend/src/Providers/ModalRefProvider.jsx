import { ModalRefContext } from "Contexts/ModalRefContext"
import {  useRef } from "react"

export default function ModalRefProvider({children}){
  const modalRef = useRef(null)

  return (
    <ModalRefContext.Provider value={modalRef}>
      {children}
    </ModalRefContext.Provider>
  )
}
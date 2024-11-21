import { useContext } from "react"
import { ModalRefContext } from "Contexts/ModalRefContext"

export default function useModal() {
  return useContext(ModalRefContext)
}
import { useEffect, useState } from "react"

export default function useContextMenuManager() {
  const [isOpen, setIsOpen] = useState(false)

  useEffect(() => {
    const handleWindowClick = () => setIsOpen(false)

    window.addEventListener('click', handleWindowClick)

    return () => {
      window.removeEventListener('click', handleWindowClick)
    }
  }, [])


  return [isOpen, setIsOpen]
}
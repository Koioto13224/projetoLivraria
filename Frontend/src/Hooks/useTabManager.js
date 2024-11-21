import { useState, useCallback } from "react"

import ETabs from "Enums/ETabs"

export default function useTabManager() {
  const [tab, setTab] = useState(ETabs.BOOKS)

  const handleSwitchTab = useCallback((e) => {
    const tabValueInDOMElement =
      e.currentTarget.getAttribute('value')
    const tabBelongsEnum = Object.values(ETabs).includes(
      tabValueInDOMElement
    )

    if (tabBelongsEnum) {
      return setTab(tabValueInDOMElement)
    }

    console.error('Current tab was wrong or not exist')
  }, [])

  return {
    tab,
    handleSwitchTab
  }
}
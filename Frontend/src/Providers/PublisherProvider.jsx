import { AddPublisherContext } from 'Contexts/AddPublisherContext'
import { PublishersContext } from 'Contexts/PublishersContext'

import { useCallback, useState } from 'react'

import EPublishers from 'Enums/EPublishers'

const INITIAL_PUBLISHERS = Object.keys(EPublishers)

export default function PublisherProvider({ children }) {
  const [publishers, setPublishers] = useState(INITIAL_PUBLISHERS)

  const addPublisher = useCallback(
    (newPublisher) => {
      if (publishers.includes(newPublisher)) {
        setPublishers([...publishers, newPublisher])
        return true
      }

      return false
    },
    [publishers]
  )

  return (
    <PublishersContext.Provider value={publishers}>
      <AddPublisherContext.Provider value={addPublisher}>
        {children}
      </AddPublisherContext.Provider>
    </PublishersContext.Provider>
  )
}
